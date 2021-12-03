import database.SkyCryptDatabase;
import requests.RequestParser;
import requests.RequestReceiver;
import responses.ResponseFormatter;
import responses.ResponseSender;

public class WeightCalculator {

    public static void main(String[] args) {
        SkyCryptDatabase database = new SkyCryptDatabase();
        RequestParser requestParser = new RequestParser(database);
        ResponseFormatter responseFormatter = new ResponseFormatter();
        ResponseSender responseSender = new ResponseSender();
        RequestReceiver requestReceiver = new RequestReceiver(requestParser, responseFormatter, responseSender);
        Bot bot = new Bot(new BotListenerAdapter(requestReceiver));
        bot.build();
    }

}
