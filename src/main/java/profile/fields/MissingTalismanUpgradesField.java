package profile.fields;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MissingTalismanUpgradesField extends Field<List<Map<String, Object>>>{
    public MissingTalismanUpgradesField(String jsonPath) {
        super(jsonPath);
        this.value = new ArrayList<>();
    }

    @Override
    public double getWeight() {
        System.out.println(value.size());
        return -2d*value.size();
    }

}
