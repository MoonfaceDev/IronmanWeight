package database;

import profile.SkyblockProfile;

public interface IDatabase {
    SkyblockProfile getProfile(String playerName, String profileName) throws DatabaseException;
    SkyblockProfile getProfile(String playerName) throws DatabaseException;
}
