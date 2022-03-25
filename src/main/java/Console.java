import handlers.console.IConsoleCommandHandler;
import commands.ConsoleCommand;

import java.util.Scanner;

public class Console {

    private final IConsoleCommandHandler commandHandler;

    public Console(IConsoleCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void start() {
        System.out.println("Started messages console. Type \"exit\" to quit");
        Scanner input = new Scanner(System.in);
        while(true) {
            String commandLine = input.nextLine();
            if(commandLine.equals("exit")) {
                return;
            }
            this.commandHandler.handleCommand(ConsoleCommand.fromRawContent(commandLine));
        }
    }

}
