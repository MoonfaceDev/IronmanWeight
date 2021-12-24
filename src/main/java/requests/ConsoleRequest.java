package requests;

public class ConsoleRequest implements IRequest{

    private final String content;

    public ConsoleRequest(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
