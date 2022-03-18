package requests;

import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public interface IRequest {
    String getContent();
    List<OptionMapping> getOptions();
}
