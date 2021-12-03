package profile.fields;

public class MithrilPowderField extends Field<Integer>{
    public MithrilPowderField(String jsonPath) {
        super(jsonPath);
    }

    @Override
    public double getWeight() {
        return 200d/(1+Math.exp(-0.2d*value/1000000d))-100d;
    }
}
