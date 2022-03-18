import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {

    private final JDABuilder builder;
    private static final String DISCORD_TOKEN_ENV = "DISCORD_TOKEN";
    private static final Activity BOT_ACTIVITY = Activity.playing("Skyblock");

    public Bot(BotListenerAdapter botListenerAdapter) {
        builder = JDABuilder.createDefault(getDiscordToken());
        builder.setActivity(BOT_ACTIVITY);
        builder.addEventListeners(botListenerAdapter);
    }

    private String getDiscordToken() {
        return System.getenv(DISCORD_TOKEN_ENV);
    }

    public void build() {
        try {
            JDA jda = builder.build();
            jda.upsertCommand("ironweight", "Calculate the IronWeight of a skyblock profile").queue();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
