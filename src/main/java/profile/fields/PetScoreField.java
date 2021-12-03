package profile.fields;

public class PetScoreField extends Field<Integer>{
    public PetScoreField(String jsonPath) {
        super(jsonPath);
    }

    @Override
    public double getWeight() {
        return value/2d;
    }
}
