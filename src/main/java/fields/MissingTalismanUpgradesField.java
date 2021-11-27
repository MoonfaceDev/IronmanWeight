package fields;

import net.minidev.json.JSONArray;

public class MissingTalismanUpgradesField extends Field<JSONArray>{
    public MissingTalismanUpgradesField(String jsonPath) {
        super(jsonPath);
    }

    @Override
    public double getWeight() {
        return -2d*value.size();
    }

}
