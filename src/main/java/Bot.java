import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {

    private final JDABuilder builder;

    public Bot(BotListenerAdapter botListenerAdapter) {
        builder = JDABuilder.createDefault(getDiscordToken());
        builder.setActivity(Activity.playing("Skyblock"));
        builder.addEventListeners(botListenerAdapter);
    }

    private String getDiscordToken() {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get("DISCORD_TOKEN");
    }

    public void build() {
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
