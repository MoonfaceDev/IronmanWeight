package profile.fields;

import net.minidev.json.JSONArray;

import java.util.Map;

public class MissingTalismansField extends Field<JSONArray>{
    public MissingTalismansField(String jsonPath) {
        super(jsonPath);
    }

    @Override
    public double getWeight() {
        double weight = 238d;
        for(int i=0; i<value.size(); i++) {
            Map<String, String> talisman = (Map<String, String>) value.get(i);
            switch (talisman.get("rarity")) {
                case "common" -> weight -= 1;
                case "uncommon" -> weight -= 2;
                case "rare" -> weight -= 3;
                case "epic" -> weight -= 4;
                case "legendary" -> weight -= 5;
            }
        }
        return 2d*weight;
    }
}
