package profile.fields;

public class ItemField extends Field<Boolean> {

    public String[] jsonPaths;
    public String itemID;
    public int weight;

    public ItemField(String[] jsonPaths, String itemID, int weight) {
        super("");
        this.jsonPaths = jsonPaths;
        this.itemID = itemID;
        this.weight = weight;
        this.value = false;
    }

    public ItemField(String jsonPath, String itemID, int weight) {
        super("");
        this.jsonPaths = new String[]{jsonPath};
        this.itemID = itemID;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        if(value) {
            return weight;
        } else {
            return 0;
        }
    }
}
