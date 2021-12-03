package profile.fields;

public class PetScoreField extends Field<Integer>{
    public PetScoreField(String jsonPath) {
        super(jsonPath);
        this.value = 0;
    }

    @Override
    public double getWeight() {
        return value/2d;
    }
}
