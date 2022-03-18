package requests;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class DiscordRequest implements IRequest {

    private final SlashCommandEvent event;
    private final MessageChannel channel;
    private final String content;
    private final User author;
    private final boolean isFromGuild;
    private final Guild guild;

    public DiscordRequest(SlashCommandEvent event) {
        this.event = event;
        this.channel = event.getChannel();
        this.content = event.getCommandString();
        this.author = event.getUser();
        this.isFromGuild = event.isFromGuild();
        this.guild = event.getGuild();
    }

    public SlashCommandEvent getEvent() {
        return this.event;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    public MessageChannel getChannel() {
        return this.channel;
    }

    public User getAuthor() {
        return this.author;
    }

    public boolean isFromGuild() {
        return isFromGuild;
    }

    public Guild getGuild() {
        return this.guild;
    }
}
