import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Configuration {

    private static Configuration instance;

    public String discordToken;

    public static Configuration getInstance() {
        if(instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    private Configuration()  {
        try {
            JSONObject configurationObject = JsonPath.parse(new FileReader("config.json")).read("@");
            discordToken = configurationObject.getAsString("discord_token");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
