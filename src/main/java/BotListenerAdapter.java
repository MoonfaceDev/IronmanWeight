import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.text.DecimalFormat;

public class BotListenerAdapter extends ListenerAdapter {

    private final SkyCryptDatabase database;
    private static final DecimalFormat weightFormat = new DecimalFormat("0.00");

    public BotListenerAdapter() {
        database = new SkyCryptDatabase();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        System.out.println("Message from "+event.getAuthor().getName()+": "+event.getMessage().getContentDisplay());
        String line = event.getMessage().getContentRaw();
        String[] words = line.split("\\s");
        if(words.length == 3 && words[0].startsWith("/ironweight")) {
            String playerName = words[1];
            String profileName = words[2];
            SkyblockProfile player = database.getProfile(playerName, profileName);
            double weight = player.getTotalWeight();
            String response = "### "+playerName+" | "+profileName+
                    "\n**Total Weight:** "+weightFormat.format(weight)+"\n"+
                    "\n**Catacombs:** "+weightFormat.format(player.catacombs.getWeight())+
                    "\n**Talismans:** "+weightFormat.format(player.missingTalismans.getWeight()-player.missingTalismanUpgrades.getWeight());
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                            .setDescription(response)
                            .setColor(Color.decode("#304ffe"))
                            .build()
            ).queue();
        }
    }
}
