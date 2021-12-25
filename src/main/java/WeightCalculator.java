import database.SkyCryptDatabase;
import logging.FirebaseRequestLogger;
import requests.RequestParser;
import requests.RequestReceiver;
import responses.ConsoleResponseSender;
import responses.ResponseFormatter;
import responses.DiscordResponseSender;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WeightCalculator {

    public static final String RUN_MODE = "run";
    public static final String TEST_MODE = "test";

    public static void main(String[] args) {
        SkyCryptDatabase database = new SkyCryptDatabase();
        RequestParser requestParser = new RequestParser(database);
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
            RequestReceiver requestReceiver = new RequestReceiver(requestParser, responseFormatter, responseSender, requestLogger);
            Bot bot = new Bot(new BotListenerAdapter(requestReceiver));
            bot.build();
        } else if(mode.equals(TEST_MODE)) {
            ConsoleResponseSender responseSender = new ConsoleResponseSender();
            RequestReceiver requestReceiver = new RequestReceiver(requestParser, responseFormatter, responseSender, requestLogger);
            Console console = new Console(requestReceiver);
            console.start();
        }
    }

}
