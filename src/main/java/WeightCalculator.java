import database.SkyCryptDatabase;
import handlers.console.ConsoleCommandHandler;
import handlers.discord.DiscordCommandHandler;
import logging.FirebaseCommandLogger;
import response_formatter.ResponseFormatter;

import java.io.IOException;

public class WeightCalculator {

    public static final String RUN_MODE = "run";
    public static final String TEST_MODE = "test";

    public static void main(String[] args) {
        SkyCryptDatabase database = new SkyCryptDatabase();
        FirebaseCommandLogger commandLogger = null;
        try {
            commandLogger = new FirebaseCommandLogger();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseFormatter responseFormatter = new ResponseFormatter();
        String mode = args[0];
        if(mode.equals(RUN_MODE)) {
            DiscordCommandHandler commandHandler = new DiscordCommandHandler(database, responseFormatter, commandLogger);
            Bot bot = new Bot(new BotListenerAdapter(commandHandler));
            bot.build();
        } else if(mode.equals(TEST_MODE)) {
            ConsoleCommandHandler commandHandler = new ConsoleCommandHandler(database, responseFormatter);
            Console console = new Console(commandHandler);
            console.start();
        }
    }

}
