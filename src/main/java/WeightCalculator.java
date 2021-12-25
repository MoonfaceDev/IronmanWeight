import database.SkyCryptDatabase;
import logging.FileRequestLogger;
import requests.RequestParser;
import requests.RequestReceiver;
import responses.ConsoleResponseSender;
import responses.ResponseFormatter;
import responses.DiscordResponseSender;

import java.io.FileNotFoundException;

public class WeightCalculator {

    public static final String RUN_MODE = "run";
    public static final String TEST_MODE = "test";
    public static final String LOG_FILE_PATH = "log.txt";

    public static void main(String[] args) {
        SkyCryptDatabase database = new SkyCryptDatabase();
        RequestParser requestParser = new RequestParser(database);
        FileRequestLogger requestLogger = null;
        try {
            requestLogger = new FileRequestLogger(LOG_FILE_PATH);
        } catch (FileNotFoundException e) {
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
