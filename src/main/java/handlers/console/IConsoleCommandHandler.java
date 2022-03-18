package handlers.console;

import commands.ConsoleCommand;

public interface IConsoleCommandHandler {
    void handleCommand(ConsoleCommand command);
}
