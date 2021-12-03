package responses;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;
import java.time.Instant;

public class ResponseSender implements IResponseSender {

    private static final Color messageColor = Color.decode("#304ffe");
    private static final String messageFooter = "Ironman Weight • Created By nomface";

    @Override
    public void sendResponse(MessageChannel channel, String response) {
        channel.sendMessageEmbeds(new EmbedBuilder()
                .setDescription(response)
                .setColor(messageColor)
                .setFooter(messageFooter)
                .setTimestamp(Instant.now())
                .build()
        ).queue();
    }
}
