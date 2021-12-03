package profile.fields;

public class GemstonePowderField extends Field<Integer>{
    public GemstonePowderField(String jsonPath) {
        super(jsonPath);
    }

    @Override
    public double getWeight() {
        return 300d/(1+Math.exp(-0.2d*value/1000000d))-150d;
    }
}
