package requests;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DiscordRequest implements IRequest {

    private final MessageChannel channel;
    private final Message message;
    private final String content;

    public DiscordRequest(MessageReceivedEvent event) {
        this.channel = event.getChannel();
        this.message = event.getMessage();
        this.content = event.getMessage().getContentRaw();
    }

    @Override
    public String getContent() {
        return this.content;
    }

    public MessageChannel getChannel() {
        return this.channel;
    }

    public Message getMessage() {
        return this.message;
    }
}
