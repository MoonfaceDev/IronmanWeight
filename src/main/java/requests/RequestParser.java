package requests;

import database.DatabaseException;
import database.IDatabase;
import profile.SkyblockProfile;

public class RequestParser implements IRequestParser {

    private final IDatabase database;

    public RequestParser(IDatabase database) {
        this.database = database;
    }

    @Override
    public SkyblockProfile parseRequest(String request) throws DatabaseException, ParsingException {
        String[] words = request.split("\\s");
        if(words.length == 3 && words[0].startsWith("/ironweight")) {
            String playerName = words[1];
            String profileName = words[2];
            return database.getProfile(playerName, profileName);
        }
        throw new ParsingException("Could not parse the given request");
    }
}
