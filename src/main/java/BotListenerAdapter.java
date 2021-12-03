import database.SkyCryptDatabase;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import requests.IRequestReceiver;

public class BotListenerAdapter extends ListenerAdapter {

    private final IRequestReceiver requestReceiver;

    public BotListenerAdapter(IRequestReceiver requestReceiver) {
        this.requestReceiver = requestReceiver;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        System.out.println("Message from "+event.getAuthor().getName()+": "+event.getMessage().getContentDisplay());
        requestReceiver.onNewRequest(event);
    }

}
