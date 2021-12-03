package profile.fields;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MissingTalismanUpgradesField extends Field<List<Map<String, String>>>{
    public MissingTalismanUpgradesField(String jsonPath) {
        super(jsonPath);
        this.value = new ArrayList<>();
    }

    @Override
    public double getWeight() {
        return -2d*value.size();
    }

}
