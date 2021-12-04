import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import requests.IRequestReceiver;

import java.util.logging.Logger;

public class BotListenerAdapter extends ListenerAdapter {

    private final IRequestReceiver requestReceiver;

    private static final Logger logger = Logger.getLogger(BotListenerAdapter.class.getName());

    public BotListenerAdapter(IRequestReceiver requestReceiver) {
        this.requestReceiver = requestReceiver;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        logger.info("Message from "+event.getAuthor().getName()+": "+event.getMessage().getContentDisplay());
        requestReceiver.onNewRequest(event);
    }

}
