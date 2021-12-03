package requests;

import database.DatabaseException;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import profile.SkyblockProfile;
import responses.IResponseFormatter;
import responses.IResponseSender;

public class RequestReceiver implements IRequestReceiver {

    public IRequestParser requestParser;
    public IResponseFormatter responseFormatter;
    public IResponseSender responseSender;

    public RequestReceiver(IRequestParser requestParser, IResponseFormatter responseFormatter, IResponseSender responseSender) {
        this.requestParser = requestParser;
        this.responseFormatter = responseFormatter;
        this.responseSender = responseSender;
    }

    @Override
    public void onNewRequest(MessageReceivedEvent event) {
        String request = event.getMessage().getContentRaw();
        if (!isBotRequest(request)) {
            return;
        }
        String response;
        try {
            SkyblockProfile profile = requestParser.parseRequest(request);
            response = responseFormatter.format(profile);
        } catch (DatabaseException e) {
            response = getErrorMessage(e.playerName, e.profileName, e.getMessage());
        } catch (ParsingException e) {
            response = e.getMessage();
        }
        MessageChannel channel = event.getChannel();
        this.responseSender.sendResponse(channel, response);
    }

    private boolean isBotRequest(String request) {
        return request.startsWith(RequestParser.REQUEST_COMMAND + " ");
    }

    private String getErrorMessage(String playerName, String profileName, String errorMessage) {
        if (profileName == null) {
            return ":pick: " + playerName +
                    "\n**Error:** " + errorMessage;
        } else {
            return ":pick: " + playerName + " | " + profileName + "" +
                    "\n**Error:** " + errorMessage;
        }
    }
}
