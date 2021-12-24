package responses;

import requests.IRequest;

public class ConsoleResponseSender implements IResponseSender {

    private static final String messageFooter = "Ironman Weight • Created By nomface";

    @Override
    public void sendResponse(String response, IRequest request) {
        System.out.println(response);
        System.out.println(messageFooter);
    }
}
