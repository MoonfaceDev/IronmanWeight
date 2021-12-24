package requests;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DiscordRequest implements IRequest {

    private final MessageChannel channel;
    private final String content;

    public DiscordRequest(MessageReceivedEvent event) {
        this.channel = event.getChannel();
        this.content = event.getMessage().getContentRaw();
    }

    @Override
    public String getContent() {
        return this.content;
    }

    public MessageChannel getChannel() {
        return this.channel;
    }
}
