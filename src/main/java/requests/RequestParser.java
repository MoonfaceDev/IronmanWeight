package requests;

import database.DatabaseException;
import database.IDatabase;
import profile.SkyblockProfile;

public class RequestParser implements IRequestParser {

    public static final String REQUEST_COMMAND = "/ironweight";

    private final IDatabase database;

    public RequestParser(IDatabase database) {
        this.database = database;
    }

    @Override
    public SkyblockProfile parseRequest(String request) throws DatabaseException, ParsingException {
        String[] words = request.split("\\s");
        if(words[0].equals(REQUEST_COMMAND)) {
            if (words.length == 3) {
                String playerName = words[1];
                String profileName = words[2];
                return database.getProfile(playerName, profileName);
            } else if(words.length == 2) {
                String playerName = words[1];
                return database.getProfile(playerName);
            }
        }
        throw new ParsingException("Could not parse the given request");
    }
}
