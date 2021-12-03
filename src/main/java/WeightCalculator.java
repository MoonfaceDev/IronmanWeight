import database.IDatabase;
import database.SkyCryptDatabase;
import requests.IRequestParser;
import requests.IRequestReceiver;
import requests.RequestParser;
import requests.RequestReceiver;
import responses.IResponseFormatter;
import responses.IResponseSender;
import responses.ResponseFormatter;
import responses.ResponseSender;

public class WeightCalculator {

    public static void main(String[] args) {
        IDatabase database = new SkyCryptDatabase();
        IRequestParser requestParser = new RequestParser(database);
        IResponseFormatter responseFormatter = new ResponseFormatter();
        IResponseSender responseSender = new ResponseSender();
        IRequestReceiver requestReceiver = new RequestReceiver(requestParser, responseFormatter, responseSender);
        Bot bot = new Bot(new BotListenerAdapter(requestReceiver));
        bot.build();
    }

}
