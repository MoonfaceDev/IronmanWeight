import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class WeightCalculator {

    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault(Configuration.DISCORD_TOKEN);
        builder.setActivity(Activity.playing("Skyblock"));
        builder.addEventListeners(new BotListenerAdapter());
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
