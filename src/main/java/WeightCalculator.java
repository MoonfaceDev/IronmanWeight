import database.SkyCryptDatabase;
import logging.FirebaseRequestLogger;
import requests.RequestReceiver;
import responses.ConsoleResponseSender;
import responses.DiscordResponseSender;
import responses.ResponseFormatter;

import java.io.IOException;

public class WeightCalculator {

    public static final String RUN_MODE = "run";
    public static final String TEST_MODE = "test";

    public static void main(String[] args) {
        SkyCryptDatabase database = new SkyCryptDatabase();
        FirebaseRequestLogger requestLogger = null;
        try {
            requestLogger = new FirebaseRequestLogger();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseFormatter responseFormatter = new ResponseFormatter();
        String mode = args[0];
        if(mode.equals(RUN_MODE)) {
            DiscordResponseSender responseSender = new DiscordResponseSender();
            RequestReceiver requestReceiver = new RequestReceiver(database, responseFormatter, responseSender, requestLogger);
            Bot bot = new Bot(new BotListenerAdapter(requestReceiver));
            bot.build();
        } else if(mode.equals(TEST_MODE)) {
            ConsoleResponseSender responseSender = new ConsoleResponseSender();
            RequestReceiver requestReceiver = new RequestReceiver(database, responseFormatter, responseSender, requestLogger);
            Console console = new Console(requestReceiver);
            console.start();
        }
    }

}
