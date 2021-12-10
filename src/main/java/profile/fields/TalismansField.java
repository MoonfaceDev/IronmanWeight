package profile.fields;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TalismansField extends Field<List<Map<String, Object>>>{
    public TalismansField(String jsonPath) {
        super(jsonPath);
        this.value = new ArrayList<>();
    }

    @Override
    public double getWeight() {
        double weight = 0d;
        for (Map<String, Object> talisman : value) {
            if((boolean) talisman.get("isUnique")) {
                switch (getRarity(talisman)) {
                    case "common" -> weight += 1;
                    case "uncommon" -> weight += 2;
                    case "rare" -> weight += 3;
                    case "epic" -> weight += 4;
                    case "legendary" -> weight += 5;
                    case "mythic" -> weight += 6;
                }
            }
            if(isRecombobulated(talisman)) {
                weight += 1;
            }
        }
        return 2d*weight;
    }

    public String getRarity(Map<String, Object> talisman) {
        return talisman.get("rarity").toString();
    }

    public boolean isRecombobulated(Map<String, Object> talisman) {
        System.out.println(((Map<String, Object>)(talisman.get("extra"))).get("recombobulated"));
        return (boolean) ((Map<String, Object>)(talisman.get("extra"))).get("recombobulated");
    }
}
