import requests.ConsoleRequest;
import requests.IRequestReceiver;

import java.util.Scanner;

public class Console {

    private final IRequestReceiver requestReceiver;

    public Console(IRequestReceiver requestReceiver) {
        this.requestReceiver = requestReceiver;
    }

    public void start() {
        System.out.println("Started messages console. Type \"exit\" to quit");
        Scanner input = new Scanner(System.in);
        while(true) {
            String request = input.nextLine();
            if(request.equals("exit")) {
                return;
            }
            this.requestReceiver.onNewRequest(new ConsoleRequest(request));
        }
    }

}
