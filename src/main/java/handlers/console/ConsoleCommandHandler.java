package handlers.console;

import database.DatabaseException;
import database.IDatabase;
import profile.SkyblockProfile;
import commands.ConsoleCommand;
import response_formatter.IResponseFormatter;

public class ConsoleCommandHandler implements IConsoleCommandHandler {

    private static final String messageFooter = "Ironman Weight • Created By nomface";
    private static final String IRONWEIGHT_COMMAND = "ironweight";

    public IDatabase database;
    public IResponseFormatter responseFormatter;



    public ConsoleCommandHandler(IDatabase database, IResponseFormatter responseFormatter) {
        this.database = database;
        this.responseFormatter = responseFormatter;
    }

    public SkyblockProfile getProfile(ConsoleCommand command) throws DatabaseException {
        String[] words = command.getContent().split("\\s");
        if(words[0].equals(IRONWEIGHT_COMMAND)) {
            if (words.length == 3) {
                String playerName = words[1];
                String profileName = words[2];
                return database.getProfile(playerName, profileName);
            } else if(words.length == 2) {
                String playerName = words[1];
                return database.getProfile(playerName);
            }
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
    public void handleCommand(ConsoleCommand command) {
        String response;
        try {
            SkyblockProfile profile = getProfile(command);
            response = responseFormatter.format(profile);
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
