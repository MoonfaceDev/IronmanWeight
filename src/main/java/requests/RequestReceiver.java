package requests;

import com.google.firebase.database.ServerValue;
import database.DatabaseException;
import database.IDatabase;
import database.SkyCryptDatabase;
import logging.IRequestLogger;
import profile.SkyblockProfile;
import responses.IResponseFormatter;
import responses.IResponseSender;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class RequestReceiver implements IRequestReceiver {

    public IDatabase database;
    public IResponseFormatter responseFormatter;
    public IResponseSender responseSender;
    public IRequestLogger responseLogger;

    public RequestReceiver(IDatabase database, IResponseFormatter responseFormatter, IResponseSender responseSender, IRequestLogger responseLogger) {
        this.database = database;
        this.responseFormatter = responseFormatter;
        this.responseSender = responseSender;
        this.responseLogger = responseLogger;
    }

    public SkyblockProfile getProfile(IRequest request) throws DatabaseException {
        if (request.getOptions().size() == 2) {
            String playerName = request.getOptions().get(0).getAsString();
            String profileName = request.getOptions().get(1).getAsString();
            return this.database.getProfile(playerName, profileName);
        } else if(request.getOptions().size() == 1) {
            String playerName = request.getOptions().get(0).getAsString();
            return this.database.getProfile(playerName);
        }
        return null;
    }

    @Override
    public void onNewRequest(IRequest request) {
        String response;
        try {
            SkyblockProfile profile = getProfile(request);
            if(request instanceof DiscordRequest) {
                Map<String, Object> logData = new HashMap<>();
                logData.put("timestamp", ServerValue.TIMESTAMP);
                logData.put("player", profile.playerName);
                logData.put("profile", profile.profileName);
                logData.put("author", ((DiscordRequest) request).getAuthor().getAsTag());
                logData.put("weight", profile.getTotalWeight());
                if(((DiscordRequest) request).isFromGuild()) {
                    logData.put("guild", ((DiscordRequest) request).getGuild().getName());
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
        }
        this.responseSender.sendResponse(response, request);
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
