import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

import javax.security.auth.login.LoginException;

public class Bot {

    private final JDABuilder builder;
    private static final String DISCORD_TOKEN_ENV = "DISCORD_TOKEN";
    private static final Activity BOT_ACTIVITY = Activity.playing("Skyblock");
    private static final String IRONWEIGHT_COMMAND = "ironweight";

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
            jda.upsertCommand(new CommandData(IRONWEIGHT_COMMAND, "Calculate the IronWeight of a skyblock profile")
                    .addOption(OptionType.STRING, "player", "Minecraft player name")
                    .addOption(OptionType.STRING, "profile", "Skyblock profile name")
            ).queue();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
