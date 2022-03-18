package responses;

import net.dv8tion.jda.api.EmbedBuilder;
import requests.DiscordRequest;
import requests.IRequest;

import java.awt.*;
import java.time.Instant;

public class DiscordResponseSender implements IResponseSender {

    private static final Color messageColor = Color.decode("#304ffe");
    private static final String messageFooter = "Ironman Weight • Created By nomface";

    @Override
    public void sendResponse(String response, IRequest request) {
        if(!(request instanceof DiscordRequest)) {
            return;
        }
        ((DiscordRequest) request).getEvent().replyEmbeds((new EmbedBuilder()
                .setDescription(response)
                .setColor(messageColor)
                .setFooter(messageFooter)
                .setTimestamp(Instant.now())
                .build()
        )).queue();
    }
}
