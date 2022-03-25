package handlers.console;

import commands.ConsoleCommand;
import database.DatabaseException;
import database.IDatabase;
import profile.SkyblockProfile;
import response_formatter.ResponseFormatterFactory;

public class ConsoleCommandHandler implements IConsoleCommandHandler {

    private static final String messageFooter = "Ironman Weight • Created By nomface";

    public IDatabase database;
    public ResponseFormatterFactory responseFormatterFactory;



    public ConsoleCommandHandler(IDatabase database, ResponseFormatterFactory responseFormatterFactory) {
        this.database = database;
        this.responseFormatterFactory = responseFormatterFactory;
    }

    public SkyblockProfile getProfile(ConsoleCommand command) throws DatabaseException {
        if (command.getProfile() == null) {
            return database.getProfile(command.getPlayer());
        }
        return database.getProfile(command.getPlayer(), command.getProfile());
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
    public void handleCommand(ConsoleCommand command) {
        String response;
        try {
            SkyblockProfile profile = getProfile(command);
            response = responseFormatterFactory.build(command).format(profile);
        } catch (DatabaseException e) {
            response = getErrorMessage(e.playerName, e.profileName, e.getMessage());
        }
        printResponse(response);
    }

    public void printResponse(String response) {
        System.out.println(response);
        System.out.println(messageFooter);
    }
}
