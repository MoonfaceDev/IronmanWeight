import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import requests.DiscordRequest;
import requests.IRequestReceiver;

import java.util.logging.Logger;

public class BotListenerAdapter extends ListenerAdapter {

    private final IRequestReceiver requestReceiver;

    private static final Logger logger = Logger.getLogger(BotListenerAdapter.class.getName());

    public BotListenerAdapter(IRequestReceiver requestReceiver) {
        this.requestReceiver = requestReceiver;
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {
        logger.info("Message from "+event.getUser().getName()+": "+event.getCommandString());
        requestReceiver.onNewRequest(new DiscordRequest(event));
    }

}
