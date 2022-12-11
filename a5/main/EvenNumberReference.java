import java.util.Objects;

/**
 * Bildet eine Ganzzahlige Zahl ab. Erlaubt diverse arithmetische Operationen wie z.B Addition
 * oder subtraktion.
 */
public class EvenNumberReference {

    private static final int DEFAULT_NUMBER = 10;
    private int number;

    /**
     * Erzeugt eine EvenNumberReference Instanz mit den Default Wert "10"
     */
    public EvenNumberReference() {
        this(DEFAULT_NUMBER);
    }

    /**
     * Erzeugt eine neue Instanz mit einen gegebenen Default Wert
     * @param number zu benutzende Ganzzahl
     */
    public EvenNumberReference(int number) {
        this.number = number;
    }

    /**
     * Gibt die aktuell representierende Zahl zurück
     * @return zahl
     */
    private int getNumber() {
        return number;
    }

    /**
     * Multipliziert die Ganzzahl mit den Factor number
     * @param number faktor mit denen die Nummer mulitpliziert werden soll
     */
    public void mult(EvenNumberReference number) {
        this.number = ensureEvenNumber(getNumber() * number.getNumber());
    }

    /**
     * Summiert eine gegebene Zahl auf die andere.
     * @param number zu summierende Zahl
     */
    public void add(EvenNumberReference number) {
        this.number = this.number + number.getNumber();
    }

    /**
     * Subtrahiert eine gegebene Zahl auf die Zahl.
     * @param number zu subtrahierende Zahl
     */
    public void sub(EvenNumberReference number) {
        this.number = this.number - number.getNumber();
    }

    private int ensureEvenNumber(int number) {
        return number * 2;
    }

   /**
    * Bechnet einen einzigartigen HashCode auf grundlage der aktuellen Zahl
    * @return einzigartiger Wert
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvenNumberReference that = (EvenNumberReference) o;
        return number == that.number;
    }

    /**
     * Bechnet einen einzigartigen HashCode auf grundlage der aktuellen Zahl
     * @return einzigartiger Wert
     */
    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    /**
     * Liefert eine String Reprensentation der Zahl
     * @return Text Representation der Zahl
     */
    @Override
    public String toString() {
        return String.valueOf(getNumber());
    }
}
