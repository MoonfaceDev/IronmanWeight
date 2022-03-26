package profile.fields;

public class TransformedField implements IField {

    private final IField field;
    private final TransformationFunction function;

    public TransformedField(IField field, TransformationFunction function) {
        this.field = field;
        this.function = function;
    }

    @Override
    public double getWeight() {
        return function.transform(field.getWeight());
    }
}
