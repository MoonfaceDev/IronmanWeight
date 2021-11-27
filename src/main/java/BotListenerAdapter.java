import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

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
            String response = ":pick: "+playerName+" | "+profileName+""+
                    "\n**Total Weight:** "+weightFormat.format(weight)+"\n"+
                    "\n**Skills:** "+weightFormat.format(player.getSkillsWeight())+
                    "\n - Taming: "+weightFormat.format(player.taming.getWeight())+
                    "\n - Farming: "+weightFormat.format(player.farming.getWeight())+
                    "\n - Mining: "+weightFormat.format(player.mining.getWeight())+
                    "\n - Combat: "+weightFormat.format(player.combat.getWeight())+
                    "\n - Foraging: "+weightFormat.format(player.foraging.getWeight())+
                    "\n - Fishing: "+weightFormat.format(player.fishing.getWeight())+
                    "\n - Enchanting: "+weightFormat.format(player.enchanting.getWeight())+
                    "\n - Alchemy: "+weightFormat.format(player.alchemy.getWeight())+
                    "\n**Catacombs:** "+weightFormat.format(player.catacombs.getWeight())+
                    "\n**Slayers:** "+weightFormat.format(player.getSlayersWeight())+
                    "\n - Zombie: "+weightFormat.format(player.zombie.getWeight())+
                    "\n - Spider: "+weightFormat.format(player.spider.getWeight())+
                    "\n - Wolf: "+weightFormat.format(player.wolf.getWeight())+
                    "\n - Enderman: "+weightFormat.format(player.enderman.getWeight())+
                    "\n**Items:** "+weightFormat.format(player.getItemsWeight()+player.getPetsWeight())+
                    "\n**Talismans:** "+weightFormat.format(player.missingTalismans.getWeight()+player.missingTalismanUpgrades.getWeight()+
                    "\n**Mithril Powder:** "+weightFormat.format(player.mithrilPowder.getWeight())+
                    "\n**Gemstone Powder:** "+weightFormat.format(player.gemstonePowder.getWeight())+
                    "\n**Pet Score:** "+weightFormat.format(player.petScore.getWeight())+
                    "\n**Minion Slots:** "+weightFormat.format(player.minionSlots.getWeight()));
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                            .setDescription(response)
                            .setColor(Color.decode("#304ffe"))
                            .setFooter("Ironman Weight • Created By nomface")
                            .setTimestamp(Instant.now())
                            .build()
            ).queue();
        }
    }
}
