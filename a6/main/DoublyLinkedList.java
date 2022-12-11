import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Doppelt verkette Kette. Es können beliebige Objekte hinzugefügt werden, dabei zeigt aber immer Objekt auf einen
 * Vorgänger und ein Nachgänger. Dabei kann es aber passieren das der Anfang oder Ende getroffen wird. Dann zeigt der
 * Vorgänger bzw. Nachgännger auf einen nicht existierendes Objekt
 *
 * Objekte zwischen dem ersten und letzten Objekt zeigen in jeden Fall auf einen Vorgänger bzw. einen Nachgänger.
 */
public class DoublyLinkedList {
    // head and tail are sentinal nodes (Wächterknoten)
    private final Node head, tail;
    // size of the list
    private int n;

    /**
     * Initializes an empty list.
     */
    public DoublyLinkedList() {
        this.tail = new Node();
        this.head = new Node(null, tail);
        tail.pred = head;
        n = 0;
    }

    /**
     * Erstellt eine Doppelt Verkettete Liste mit bereits bekannten Objekten.
     * @param col Start objekte
     */
    public DoublyLinkedList(Collection<Object> col) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Liefert die Anzahl der enthaltenen Elemente zurück
     * @return anzahl von Elemente in der Liste
     */
    public int size() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Prüft ob die Liste leer ist
     * @return wenn Anzahl Elemente = 0 true, ansonsten false
     */
    public boolean isEmpty() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Fügt ein Object "o" hinten an die Liste heran
     * @param o hinzufügendes Object
     * @return true wenn Operation beendet
     */
    public boolean add(Object o) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Fügt ein Object "o" an der Position "index" ein, dabei werden alle nachgehenden Objekte verschoben
     * @param index index wo das Objekt platziert werden soll
     * @param o hinzufügendes Objekt
     */
    public void add(int index, Object o) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Erzeugt ein Array mit den Inhalten der Liste
     * @return Array mit allen Elementen
     */
    public Object[] toArray() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Erzeugt eine lesbare Darstellung der Inhalte der Liste
     * @return lesbare Darstellung
     */
    public String toString() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Liefert die Position des ersten Vorkommens von o in der Liste ein
     * @param o Zu überprüfendes Objekt
     * @return position des ersten Vorkommens, wenn nicht gefunden -1
     */
    public int indexOf(Object o) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Prüft, ob o in der Liste vorhanden ist.
     * @param o zu überprüfendes Objekt
     * @return true wenn Objekt in Liste vorhanden, ansonsten false
     */
    public boolean contains(Object o) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Löscht das Objekt an der Position index in der Liste und liefert das Objekt an dieser Position zurück
     * @param index zu löschendes Objekt
     * @return gelöschtes Objekt
     */
    public Object removeAt(int index) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Löscht das erste Vorkommens von o in der Liste.Wenn o nicht gefunden wurde,
     * liefert die Methode false zurück sonst true
     * @param o zu löschendes Objekt
     * @return wenn Objekt gelöscht true, ansonsten false
     */
    public boolean remove(Object o) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Liest das Objekt an Position index.
     * @param index zu holendes Objekt an position
     * @return gefundenes Objekt
     */
    public Object get(int index) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Ersetzt den Wert an Position index durch das Objekt o
     * @param index zu ersetzende Position
     * @param o zu ersetzendes Objekt
     */
    public void set(int index, Object o) {
        throw new RuntimeException("Not implemented");
    }

    private static class Node {
        private Node succ;
        private Node pred;
        private Object content;

        public Node() {
            this(null);
        }

        public Node(Object content) {
            this(content, null);
        }

        public Node(Object content, Node succ) {
            this(content, succ, null);
        }

        public Node(Object content, Node succ, Node pred) {
            this.content = content;
            this.succ = succ;
            this.pred = pred;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedList that = (DoublyLinkedList) o;
        return n == that.n && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, n);
    }
}
