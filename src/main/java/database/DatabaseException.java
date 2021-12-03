package database;

public class DatabaseException extends Exception {
    public String playerName;
    public String profileName;

    public DatabaseException(String playerName, String profileName, String message) {
        super(message);
        this.playerName = playerName;
        this.profileName = profileName;
    }
}