package requests;

import database.DatabaseException;
import logging.IRequestLogger;
import profile.SkyblockProfile;
import responses.IResponseFormatter;
import responses.IResponseSender;

import java.util.HashMap;
import java.util.Map;

public class RequestReceiver implements IRequestReceiver {

    public IRequestParser requestParser;
    public IResponseFormatter responseFormatter;
    public IResponseSender responseSender;
    public IRequestLogger responseLogger;

    public RequestReceiver(IRequestParser requestParser, IResponseFormatter responseFormatter, IResponseSender responseSender, IRequestLogger responseLogger) {
        this.requestParser = requestParser;
        this.responseFormatter = responseFormatter;
        this.responseSender = responseSender;
        this.responseLogger = responseLogger;
    }

    @Override
    public void onNewRequest(IRequest request) {
        String requestContent = request.getContent();
        if (!isBotRequest(requestContent)) {
            return;
        }
        String response;
        try {
            SkyblockProfile profile = requestParser.parseRequest(requestContent);
            if(request instanceof DiscordRequest) {
                Map<String, Object> logData = new HashMap<>();
                logData.put("timestamp", ((DiscordRequest) request).getMessage().getTimeCreated());
                logData.put("player", profile.playerName);
                logData.put("profile", profile.profileName);
                logData.put("author", ((DiscordRequest) request).getMessage().getAuthor().getAsTag());
                logData.put("weight", profile.getTotalWeight());
                if(((DiscordRequest) request).getMessage().isFromGuild()) {
                    logData.put("guild", ((DiscordRequest) request).getMessage().getGuild().getName());
                    logData.put("channel", ((DiscordRequest) request).getChannel().getName());
                } else {
                    logData.put("guild", null);
                    logData.put("channel", null);
                }
                responseLogger.log(logData);
            }
            response = responseFormatter.format(profile);
        } catch (DatabaseException e) {
            response = getErrorMessage(e.playerName, e.profileName, e.getMessage());
        } catch (ParsingException e) {
            response = e.getMessage();
        }
        this.responseSender.sendResponse(response, request);
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
