import java.util.*;

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
     * Erstellt eine Doppelt Verkettete Liste mit bereits bekannten Objekten. Die Objekte in der Kollektion dürfen
     * nicht null sein.
     * @param col Start objekte
     */
    public DoublyLinkedList(Collection<Object> col) {
        this.n = col.size();
        this.head = new Node();
        Iterator<Object> iterator = col.iterator();
        Node prev = this.head;
        while (iterator.hasNext()) {
            Node next = new Node(iterator.next(), null, prev);
            prev.succ = next;
            prev = next;
        }
        this.tail = new Node(null, null, prev);
        prev.succ = tail;
    }

    /**
     * Liefert die Anzahl der enthaltenen Elemente zurück
     * @return anzahl von Elemente in der Liste
     */
    public int size() {
        return n;
    }

    /**
     * Prüft ob die Liste leer ist
     * @return wenn Anzahl Elemente = 0 true, ansonsten false
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Fügt ein Object "o" hinten an die Liste heran
     * @param o hinzufügendes Object
     * @return true wenn Operation beendet
     */
    public boolean add(Object o) {
        addBetween(tail.pred, o, tail);
        return true;
    }

    /**
     * Fügt ein Object "o" an der Position "index" ein, dabei werden alle nachgehenden Objekte verschoben
     * @param index index wo das Objekt platziert werden soll
     * @param o hinzufügendes Objekt
     */
    public void add(int index, Object o) {
        final Node node = getNodeAt(index);
        addBetween(node.pred, o, node);
    }

    /**
     * Erzeugt ein Array mit den Inhalten der Liste
     * @return Array mit allen Elementen
     */
    public Object[] toArray() {
        Object[] objects = new Object[n];

        Node current = head;
        int index = 0;
        while (Objects.nonNull(current)) {
            if (!current.isGuardianNode())
                objects[index++] = current.content;
            current = current.succ;
        }
        return objects;
    }

    /**
     * Liefert die Position des ersten Vorkommens von o in der Liste ein
     * @param o Zu überprüfendes Objekt
     * @return position des ersten Vorkommens, wenn nicht gefunden -1
     */
    public int indexOf(Object o) {
        return getNodeIndex(o);
    }

    /**
     * Prüft, ob o in der Liste vorhanden ist.
     * @param o zu überprüfendes Objekt
     * @return true wenn Objekt in Liste vorhanden, ansonsten false
     */
    public boolean contains(Object o) {
        return getNodeIndex(o) > 0;
    }

    /**
     * Löscht das Objekt an der Position index in der Liste und liefert das Objekt an dieser Position zurück
     * @param index zu löschendes Objekt
     * @return gelöschtes Objekt
     */
    public Object removeAt(int index) {
        final Node nodeToRemove = getNodeAt(index);
        removeBetween(nodeToRemove.pred, nodeToRemove, nodeToRemove.succ);
        return nodeToRemove.content;
    }

    /**
     * Löscht das erste Vorkommens von o in der Liste.Wenn o nicht gefunden wurde,
     * liefert die Methode false zurück sonst true
     * @param o zu löschendes Objekt
     * @return wenn Objekt gelöscht true, ansonsten false
     */
    public boolean remove(Object o) {
        final Node nodeToRemove = getNode(o);
        if (Objects.nonNull(nodeToRemove)) {
            removeBetween(nodeToRemove.pred, nodeToRemove, nodeToRemove.succ);
            return true;
        }
        return false;
    }

    /**
     * Liest das Objekt an Position index.
     * @param index zu holendes Objekt an position
     * @return gefundenes Objekt
     */
    public Object get(int index) {
        final Node node = getNodeAt(index);
        if (Objects.nonNull(node)) {
            return node.content;
        }
        return null;
    }

    /**
     * Ersetzt den Wert an Position index durch das Objekt o
     * @param index zu ersetzende Position
     * @param o zu ersetzendes Objekt
     */
    public void set(int index, Object o) {
        final Node node = getNodeAt(index);
        node.content = o;
    }

    private Node getNodeAt(int index) {
        if (!(0 <= index && index < n)) throw new IndexOutOfBoundsException(String.format("Invalid Index %d for List with size %d", index, n));
        Node current = head;
        int currentIndex = 0;
        while (Objects.nonNull(current)) {
            if (!current.isGuardianNode()) {
                if (index == currentIndex++) {
                    return current;
                }
            }
            current = current.succ;
        }
        return null;
    }

    private int getNodeIndex(Object objectToSearch) {
        Node current = head;
        int index = 0;
        while (Objects.nonNull(current)) {
            if (!current.isGuardianNode()) {
                if (current.content.equals(objectToSearch)) return index;
                index++;
            }
            current = current.succ;
        }
        return -1;
    }

    private Node getNode(Object objectToSearch) {
        Node current = head;
        while (Objects.nonNull(current)) {
            if (!current.isGuardianNode()) {
                if (current.content.equals(objectToSearch)) return current;
            }
            current = current.succ;
        }
        return null;
    }

    private void addBetween(Node pred, Object obj, Node succ) {
        Node nodeToAdd = new Node(obj, succ, pred);
        pred.succ = nodeToAdd;
        succ.pred = nodeToAdd;

        n++;
    }

    private void removeBetween(Node pred, Node nodeToRemove, Node succ) {
        nodeToRemove.pred = null;
        nodeToRemove.succ = null;

        pred.succ = succ;
        succ.pred = pred;

        n--;
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

        boolean isGuardianNode() {
            return Objects.isNull(succ) || Objects.isNull(pred);
        }

        @Override
        public String toString() {
            return content.toString();
        }
    }

    /**
     * Vergleicht die gegebene mit der aktuellen
     * @param o zu vergleichende Liste
     * @return wenn Liste identisch true, ansonsten false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedList compare = (DoublyLinkedList) o;
        if (compare.size() != size()) return false;
        return Arrays.deepEquals(compare.toArray(), toArray());
    }

    /**
     * Erzeugt eine lesbare Darstellung der Inhalte der Liste
     * @return lesbare Darstellung
     */
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    /**
     * Liefert eine aktuellen Hashcode basierend auf die Liste
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(toArray());
    }
}
