import database.SkyCryptDatabase;
import requests.RequestParser;
import requests.RequestReceiver;
import responses.ConsoleResponseSender;
import responses.ResponseFormatter;
import responses.DiscordResponseSender;

public class WeightCalculator {

    public static final String RUN_MODE = "run";
    public static final String TEST_MODE = "test";

    public static void main(String[] args) {
        SkyCryptDatabase database = new SkyCryptDatabase();
        RequestParser requestParser = new RequestParser(database);
        ResponseFormatter responseFormatter = new ResponseFormatter();
        String mode = args[0];
        if(mode.equals(RUN_MODE)) {
            DiscordResponseSender responseSender = new DiscordResponseSender();
            RequestReceiver requestReceiver = new RequestReceiver(requestParser, responseFormatter, responseSender);
            Bot bot = new Bot(new BotListenerAdapter(requestReceiver));
            bot.build();
        } else if(mode.equals(TEST_MODE)) {
            ConsoleResponseSender responseSender = new ConsoleResponseSender();
            RequestReceiver requestReceiver = new RequestReceiver(requestParser, responseFormatter, responseSender);
            Console console = new Console(requestReceiver);
            console.start();
        }
    }

}
