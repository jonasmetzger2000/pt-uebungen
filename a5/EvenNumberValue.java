/**
 * Bildet eine Ganzzahlige Zahl ab. Erlaubt diverse arithmetische Operationen wie z.B Addition
 * oder subtraktion.
 */
public class EvenNumberValue {

    private final int number;

    /**
     * Erzeugt eine EvenNumberReference Instanz mit den Default Wert "10"
     */
    public EvenNumberValue() {
        this(10);
    }

    /**
     * Erzeugt eine neue Instanz mit einen gegebenen Default Wert
     * @param number zu benutzende Ganzzahl
     */
    public EvenNumberValue(int number) {
        this.number = number;
    }

    /**
     * Gibt die aktuell representierende Zahl zurück
     * @return zahl
     */
    public int getNumber() {
        return number;
    }

    /**
     * Multipliziert die Ganzzahl mit den Factor number
     * @param number faktor mit denen die Nummer mulitpliziert werden soll
     * @return die neu erstellte Number
     */
    public EvenNumberValue mult(EvenNumberValue number) {
        return new EvenNumberValue(ensureEvenNumber(number.getNumber() * getNumber()));
    }

    /**
     * Summiert eine gegebene Zahl auf die andere.
     * @param number zu summierende Zahl
     * @return die neu erstellte Number
     */
    public EvenNumberValue add(EvenNumberValue number) {
        return new EvenNumberValue(ensureEvenNumber(number.getNumber() + getNumber()));
    }

    /**
     * Subtrahiert eine gegebene Zahl auf die Zahl.
     * @param number zu subtrahierende Zahl
     * @return die neu erstellte Number
     */
    public EvenNumberValue sub(EvenNumberValue number) {
        return new EvenNumberValue(ensureEvenNumber(number.getNumber() - getNumber()));
    }

    private int ensureEvenNumber(int number) {
        return number * 2;
    }

    /**
     * Überprüft ob das gegebene Objekt gleich dem aktuellen ist.
     * @param obj zu überprüfendes Objekt
     * @return true wenn Nummer gleich
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EvenNumberValue) {
            if (((EvenNumberValue) obj).getNumber() == getNumber()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Bechnet einen einzigartigen HashCode auf grundlage der aktuellen Zahl
     * @return einzigartiger Wert
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(getNumber());
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
