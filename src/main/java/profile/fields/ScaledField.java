package profile.fields;

public class ScaledField implements IField {

    private final IField baseField;
    private final double scaleFactor;

    public ScaledField(IField baseField, double scaleFactor) {
        this.baseField = baseField;
        this.scaleFactor = scaleFactor;
    }

    @Override
    public double getWeight() {
        return scaleFactor * baseField.getWeight();
    }
}
