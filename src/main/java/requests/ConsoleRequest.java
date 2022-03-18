package requests;

import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class ConsoleRequest implements IRequest{

    private final String content;

    public ConsoleRequest(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public List<OptionMapping> getOptions() {
        return null;
    }
}
