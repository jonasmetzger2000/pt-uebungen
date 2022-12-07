/**
 * Bildet eine Ganzzahlige Zahl ab. Erlaubt diverse arithmetische Operationen wie z.B Addition
 * oder subtraktion.
 */
public class EvenNumberReference {

    private int number;

    /**
     * Erzeugt eine EvenNumberReference Instanz mit den Default Wert "10"
     */
    public EvenNumberReference() {
        this(10);
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
    public int getNumber() {
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
        this.number = ensureEvenNumber(getNumber() + number.getNumber());
    }

    /**
     * Subtrahiert eine gegebene Zahl auf die Zahl.
     * @param number zu subtrahierende Zahl
     */
    public void sub(EvenNumberReference number) {
        this.number = ensureEvenNumber(getNumber() - number.getNumber());
    }

    private int ensureEvenNumber(int number) {
        return number * 2;
    }

    /**
     * Überprüft ob das gegebene Objekt gleich dem aktuellen ist.
     * @param obj zu überprüfendes Objekt
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EvenNumberReference) {
            if (((EvenNumberReference) obj).getNumber() == getNumber()) {
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
