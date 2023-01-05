package orders;

public class IncompleteOrderException extends Exception {
    /**
     * Erzeugt die Nachricht der Exception aus einem String-Array, das die Daten einer Orderzeile enthält.
     * @param data Array der Daten einer Order-Zeile nach dem Zerlegen über ein Trennzeichen.
     */
    public IncompleteOrderException(String[] data) {
        super(String.format("essential order parts are missing: expected 3 but was %d",data.length));
    }
}
