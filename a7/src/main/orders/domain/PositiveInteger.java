package orders.domain;

import orders.NotAPositiveNumberException;

/**
 * Die Klasse für positive ganze Zahlen
 */
public class PositiveInteger {
    private int value;

    /**
     * Initialisiert eine positive ganze Zahl mit dem übergebenen Wert, der >=0 sein muss.
     * @param value der Wert der Zahl
     * @throws NotAPositiveNumberException wenn der Wert < 0 ist
     */
    public PositiveInteger(int value) throws NotAPositiveNumberException{
        if (value < 0) throw new NotAPositiveNumberException(""+value);
        this.value=value;
    }

    /**
     * Addiert zwei positive ganze Zahlen (Wertsemantik).
     * @param other eine positive ganze Zahl
     * @return eine positive ganze Zahl
     * @throws NotAPositiveNumberException Folgefehler, da hier eine positive ganze Zahl erzeugt wird.
     */
    public PositiveInteger add(PositiveInteger other) throws NotAPositiveNumberException{
        return  new PositiveInteger(this.value+other.value);
    }

    /**
     * Bereitet den Inhalt der Zahl als Zeichenkette auf.
     * @return die Zeichenkette für die Zahl
     */
    @Override
    public String toString() {
        return String.format("%d",value);
    }
}
