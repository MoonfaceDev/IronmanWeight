package handlers.discord;

import com.google.firebase.database.ServerValue;
import database.DatabaseException;
import database.IDatabase;
import logging.ICommandLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import profile.SkyblockProfile;
import commands.DiscordCommand;
import response_formatter.IResponseFormatter;
import response_formatter.ResponseFormatterFactory;

import java.awt.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class DiscordCommandHandler implements IDiscordCommandHandler {

    private static final Color messageColor = Color.decode("#304ffe");
    private static final String messageFooter = "Ironman Weight • Created By nomface";

    public IDatabase database;
    public ResponseFormatterFactory responseFormatterFactory;
    public ICommandLogger commandLogger;


    public DiscordCommandHandler(IDatabase database, ResponseFormatterFactory responseFormatterFactory, ICommandLogger commandLogger) {
        this.database = database;
        this.responseFormatterFactory = responseFormatterFactory;
        this.commandLogger = commandLogger;
    }

    public SkyblockProfile getProfile(DiscordCommand command) throws DatabaseException {
        if (command.getOptions().size() == 2) {
            String playerName = command.getOptions().get(0).getAsString();
            String profileName = command.getOptions().get(1).getAsString();
            return this.database.getProfile(playerName, profileName);
        } else if(command.getOptions().size() == 1) {
            String playerName = command.getOptions().get(0).getAsString();
            return this.database.getProfile(playerName);
        }
        return null;
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

    @Override
    public void handleCommand(DiscordCommand command) {
        String response;
        try {
            SkyblockProfile profile = getProfile(command);
            logCommand(command, profile);
            IResponseFormatter responseFormatter = responseFormatterFactory.build(command);
            response = responseFormatter.format(profile);
        } catch (DatabaseException e) {
            response = getErrorMessage(e.playerName, e.profileName, e.getMessage());
        }
        sendResponse(response, command);
    }

    public void logCommand(DiscordCommand command, SkyblockProfile profile) {
        Map<String, Object> logData = new HashMap<>();
        logData.put("timestamp", ServerValue.TIMESTAMP);
        logData.put("player", profile.playerName);
        logData.put("profile", profile.profileName);
        logData.put("author", command.getAuthor().getAsTag());
        logData.put("ironweight", profile.fields.getWeight());
        logData.put("faceweight", profile.faceFields.getWeight());
        if(command.isFromGuild()) {
            logData.put("guild", command.getGuild().getName());
            logData.put("channel", command.getChannel().getName());
        } else {
            logData.put("guild", null);
            logData.put("channel", null);
        }
        commandLogger.log(logData);
    }

    public void sendResponse(String response, DiscordCommand command) {
        command.getEvent().replyEmbeds((new EmbedBuilder()
                .setDescription(response)
                .setColor(messageColor)
                .setFooter(messageFooter)
                .setTimestamp(Instant.now())
                .build()
        )).queue();
    }
}
