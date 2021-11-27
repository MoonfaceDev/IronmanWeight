import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class WeightCalculator {

    public static void main(String[] args) {
        Configuration configuration = Configuration.getInstance();
        JDABuilder builder = JDABuilder.createDefault(configuration.discordToken);
        builder.setActivity(Activity.playing("Skyblock"));
        builder.addEventListeners(new BotListenerAdapter());
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
