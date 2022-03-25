package profile.fields;

public class FieldCollection implements IField {

    private final IField[] fields;

    public FieldCollection(IField[] itemFields) {
        this.fields = itemFields;
    }

    @Override
    public double getWeight() {
        double total = 0;
        for(IField field : fields) {
            total += field.getWeight();
        }
        return total;
    }

    public IField[] getFields() {
        return fields;
    }
}
