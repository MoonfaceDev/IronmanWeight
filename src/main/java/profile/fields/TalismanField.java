package profile.fields;

import java.util.Map;

public class TalismanField extends Field<Map<String, Object>>{

    public String talismanID;
    public double[] tierWeights;

    public TalismanField(String jsonPath, String petID, double[] tierWeights) {
        super(jsonPath);
        this.talismanID = petID;
        this.tierWeights = tierWeights;
        this.value = null;
    }

    @Override
    public double getWeight() {
        if(value == null) {
            return 0;
        }
        switch (value.get("rarity").toString()) {
            case "common" -> {
                return tierWeights[0];
            }
            case "uncommon" -> {
                return tierWeights[1];
            }
            case "rare" -> {
                return tierWeights[2];
            }
            case "epic" -> {
                return tierWeights[3];
            }
            case "legendary" -> {
                return tierWeights[4];
            }
            case "mythic" -> {
                return tierWeights[5];
            }
            default -> {
                return 0;
            }
        }
    }
}
