package responses;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;
import java.time.Instant;

public class ResponseSender implements IResponseSender {

    @Override
    public void sendResponse(MessageChannel channel, String response) {
        channel.sendMessageEmbeds(new EmbedBuilder()
                .setDescription(response)
                .setColor(Color.decode("#304ffe"))
                .setFooter("Ironman Weight • Created By nomface")
                .setTimestamp(Instant.now())
                .build()
        ).queue();
    }
}
