package handlers.discord;

import commands.DiscordCommand;

public interface IDiscordCommandHandler {
    void handleCommand(DiscordCommand command);
}
