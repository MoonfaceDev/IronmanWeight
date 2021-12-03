package responses;

import net.dv8tion.jda.api.entities.MessageChannel;

public interface IResponseSender {
    void sendResponse(MessageChannel channel, String response);
}
