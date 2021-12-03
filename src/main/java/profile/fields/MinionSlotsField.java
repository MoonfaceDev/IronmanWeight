package profile.fields;

public class MinionSlotsField extends Field<Integer> {
    public MinionSlotsField(String jsonPath) {
        super(jsonPath);
    }

    @Override
    public double getWeight() {
        return value*2;
    }
}
