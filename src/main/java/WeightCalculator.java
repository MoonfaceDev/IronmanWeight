import fields.ItemField;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class WeightCalculator {

    static String DISCORD_TOKEN = "OTE0MTAyMDk2OTY0NDg5MjE2.YaIJ6w.LSJtmaS5cowRI_dTVLGzFOYGhAU";

    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault(DISCORD_TOKEN);
        builder.setActivity(Activity.playing("Skyblock"));
        builder.addEventListeners(new BotListenerAdapter());
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
