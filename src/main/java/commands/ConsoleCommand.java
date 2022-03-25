package commands;

public class ConsoleCommand implements ICommand {

    private final String name;
    private final String player;
    private final String profile;
    private final String rawContent;

    public ConsoleCommand(String name, String player, String profile, String rawContent) {
        this.name = name;
        this.player = player;
        this.profile = profile;
        this.rawContent = rawContent;
    }

    public static ConsoleCommand fromRawContent(String rawContent) {
        if (!rawContent.startsWith("/")) {
            return null;
        }
        rawContent = rawContent.substring(1);
        String[] words = rawContent.split("\\s");
        if (words.length == 3) {
            String name = words[0];
            String playerName = words[1];
            String profileName = words[2];
            return new ConsoleCommand(name, playerName, profileName, rawContent);
        } else if(words.length == 2) {
            String name = words[0];
            String playerName = words[1];
            return new ConsoleCommand(name, playerName, null, rawContent);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getPlayer() {
        return player;
    }

    public String getProfile() {
        return profile;
    }

    public String getRawContent() {
        return this.rawContent;
    }
}
