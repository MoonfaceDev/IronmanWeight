package fields;

public abstract class Field <T> {
    public T value;
    public String jsonPath;

    public Field(String jsonPath) {
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
