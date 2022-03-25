package response_formatter;

import commands.ICommand;


public class ResponseFormatterFactory {
    public IResponseFormatter build(ICommand command) {
        if(command.getName().equals(commands.Constants.IRONWEIGHT_COMMAND)) {
            return new IronWeightResponseFormatter();
        } else if(command.getName().equals(commands.Constants.FACEWEIGHT_COMMAND)) {
            return new FaceWeightResponseFormatter();
        }
        return null;
    }
}
