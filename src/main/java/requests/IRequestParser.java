package requests;

import database.DatabaseException;
import profile.SkyblockProfile;

public interface IRequestParser {
    SkyblockProfile parseRequest(String request) throws DatabaseException, ParsingException;
}
