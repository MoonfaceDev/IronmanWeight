import handlers.discord.IDiscordCommandHandler;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import commands.DiscordCommand;

import java.util.logging.Logger;

public class BotListenerAdapter extends ListenerAdapter {

    private final IDiscordCommandHandler commandHandler;

    private static final Logger logger = Logger.getLogger(BotListenerAdapter.class.getName());

    public BotListenerAdapter(IDiscordCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {
        logger.info("Message from "+event.getUser().getName()+": "+event.getCommandString());
        commandHandler.handleCommand(new DiscordCommand(event));
    }

}
