package commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class DiscordCommand implements ICommand {

    private final SlashCommandEvent event;
    private final MessageChannel channel;
    private final String rawContent;
    private final String name;
    private final List<OptionMapping> options;
    private final User author;
    private final boolean isFromGuild;
    private final Guild guild;

    public DiscordCommand(SlashCommandEvent event) {
        this.event = event;
        this.channel = event.getChannel();
        this.rawContent = event.getCommandString();
        this.name = event.getName();
        this.options = event.getOptions();
        this.author = event.getUser();
        this.isFromGuild = event.isFromGuild();
        this.guild = event.getGuild();
    }

    public SlashCommandEvent getEvent() {
        return this.event;
    }

    public String getRawContent() {
        return this.rawContent;
    }

    public String getName() {
        return name;
    }

    public List<OptionMapping> getOptions() {
        return options;
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
