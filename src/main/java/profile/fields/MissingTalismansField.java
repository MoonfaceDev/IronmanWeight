package profile.fields;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MissingTalismansField extends Field<List<Map<String, Object>>>{
    public MissingTalismansField(String jsonPath) {
        super(jsonPath);
        this.value = new ArrayList<>();
    }

    @Override
    public double getWeight() {
        double weight = 238d;
        for (Map<String, Object> talisman : value) {
            switch (talisman.get("rarity").toString()) {
                case "common" -> weight -= 1;
                case "uncommon" -> weight -= 2;
                case "rare" -> weight -= 3;
                case "epic" -> weight -= 4;
                case "legendary" -> weight -= 5;
            }
        }
        System.out.println(weight);
        return 2d*weight;
    }
}
