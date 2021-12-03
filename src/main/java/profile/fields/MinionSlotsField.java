package profile.fields;

public class MinionSlotsField extends Field<Integer> {
    public MinionSlotsField(String jsonPath) {
        super(jsonPath);
        this.value = 0;
    }

    @Override
    public double getWeight() {
        return value*2;
    }
}
