package profile.fields;

public class MinionSlotsField extends SimpleField<Integer> {
    public MinionSlotsField(String jsonPath) {
        super(jsonPath);
        this.value = 0;
    }

    @Override
    public double getWeight() {
        return value*2;
    }
}
