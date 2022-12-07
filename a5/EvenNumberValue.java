public class EvenNumberValue {

    private final int number;

    public EvenNumberValue() {
        this(10);
    }

    public EvenNumberValue(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public EvenNumberValue mult(EvenNumberValue number) {
        return new EvenNumberValue(ensureEvenNumber(number.getNumber() * getNumber()));
    }

    public EvenNumberValue add(EvenNumberValue number) {
        return new EvenNumberValue(ensureEvenNumber(number.getNumber() + getNumber()));
    }

    public EvenNumberValue sub(EvenNumberValue number) {
        return new EvenNumberValue(ensureEvenNumber(number.getNumber() - getNumber()));
    }

    private int ensureEvenNumber(int number) {
        return number * 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EvenNumberValue) {
            if (((EvenNumberValue) obj).getNumber() == getNumber()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(getNumber());
    }
}
