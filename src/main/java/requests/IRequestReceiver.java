package requests;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface IRequestReceiver {
    void onNewRequest(MessageReceivedEvent event);
}
