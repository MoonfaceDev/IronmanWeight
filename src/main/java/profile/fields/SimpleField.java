package profile.fields;

public abstract class SimpleField <T> implements IField {
    public T value;
    public String jsonPath;

    public SimpleField(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public abstract double getWeight();

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}