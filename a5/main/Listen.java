import java.io.PrintStream;
import java.util.*;

public class Listen {

    /**
     * Bildet eine Schnittmenge über die Ansammlungen von List-Collections
     * @param colOfIntegerCols geschachtelte Collection eines Integers, über welche eine Schnittmenge gebildet werden soll
     * @return Das Ergebnis der Schnittmenge
     */

    public static List<Integer> intersectAll(Collection<Collection<Integer>> colOfIntegerCols) {
        Iterator<Collection<Integer>> iterator = colOfIntegerCols.iterator();
        List<Integer> intersection = new ArrayList<>(iterator.next());
        while (iterator.hasNext()) {
            intersection.retainAll(iterator.next());
        }
        return intersection;
    }

    /**
     * Sammelt alle Indices bzw. Vorkommen des Strings "elem" in einer Liste
     * @param ls Liste mit Vorkommen
     * @param elem Element, von der die Vorkommen bestimmt werden sollen
     * @return indices eine Liste von Indices der Vorkommen von elem
     */
    public static List<Integer> collectAllIndices(List<String> ls, String elem) {
        List<Integer> indices = new ArrayList<>();
        for(int i=0; i<ls.size();i++){
            if(ls.get(i).equals(elem)){
                indices.add(i);
            }
        }
        return indices;
    }

    /**
     * Gibt die gegenüberliegenden Elemente der Liste aus
     * @param li auszugebende Liste
     */
    public static void printOpposites(List<Integer> li) {
        if(li.size() % 2 != 0){
            System.out.println("Uneven List");
        } else{
            for(int i=0; i<li.size()/2 ;i++){
                int vorne = li.get(i);
                int hinten= li.get(li.size()-i-1);
                System.out.printf("%d:%d %n",vorne,hinten);
            }
        }
    }
    /**
     * Überprüft, ob li1 eine echte Obermenge von li2 ist
     * @param li1 Liste mit Elementen
     * @param li2 Liste mit Elementen
     * @return Wenn li1 eine echte Obermenge von li2 ist true, ansonsten false
     */
    public static boolean isProperSuperset(List<Integer> li1, List<Integer> li2) {
        Set<Integer> se1 = new HashSet<>(li1);
        Set<Integer> se2 = new HashSet<>(li2);
        return  (se1.size() > se2.size() && se1.containsAll(se2));
    }

    /**
     * Entfernt alle Vorkommen von Objekten in der gegebenen Liste
     * @param lo Liste mit zu entfernenden Elementen
     * @param o zu entfernendes Element
     */
    public static void removeAll(List<Object> lo, Object o) {
        Iterator<Object> objectIterator = lo.iterator();
            while(objectIterator.hasNext()){
                Object compare = objectIterator.next();
                if (compare.equals(o)){
                    objectIterator.remove();
                }
            }
        //System.out.println(lo);
    }
    /**
     * Entfernt alle Elemente von einem Index zu einem anderen Index. Dabei werden von rechts nach Links die Elemente gelöscht
     * @param lo Liste, von der Elemente gelöscht werden sollen
     * @param start Index, ab dem das Löschen beginnen soll
     * @param end Index, bis zu welcher Position das Löschen stoppen soll
     */
    public static void removeLR(List <Object> lo, int start, int end) {
        int startPoint = start;

        while (startPoint <= end){
            Iterator<Object> removeIterator = lo.listIterator(start);
            removeIterator.next();
            removeIterator.remove();
            startPoint++;
        }
    }
    /**
     * Entfernt alle Elemente von einem Index zu einem anderen Index. Dabei wird von links nach rechts gelöscht
     * @param lo Liste, von der Elemente gelöscht werden sollen
     * @param start Index, ab dem das Löschen beginnen soll
     * @param end Index, bis zu welcher Position das Löschen stoppen soll
     */
    public static void removeRL (List <Object> lo, int start, int end){
        int endPoint = end;
        ListIterator<Object> removeIterator = lo.listIterator(end+1);

        while (endPoint >= start){
            removeIterator.previous();
            removeIterator.remove();
            endPoint--;
        }
    }
    /**
     * Überprüft, ob in der gegebenen Liste Duplikate vorhanden sind
     * @param lo Zu überprüfende Liste
     * @return true, wenn Liste keine Duplikate enthält, ansonsten false
     */
    public static boolean hasNoDuplicates(List<Object> lo) {
        return new HashSet<>(lo).size() == lo.size();
    }
    /**
     * Sammelt alle Duplikate (einzigartig) in einer Liste
     * @param lo Liste von welcher die Duplikate gesammelt werden sollen
     * @return Liste welche nur die Duplikate enthält
     */

    public static List<Object> collectDuplicates(List<Object> lo) {
        List<Object> duplicates = new ArrayList<>();
        Set<Object> knownObjects = new HashSet<>();

        for (Object i : lo) {
            if (knownObjects.contains(i)) {
                if (!duplicates.contains(i)) {
                    duplicates.add(i);
                }
            }
            knownObjects.add(i);
        }
        return duplicates;
    }

    /**
     * Sammelt die gegebenene Liste in eine Liste von Paaren. Die Paare selber werden als Liste representiert.
     * Wenn die gegebenene Liste eine ungrade Anzahl von Elementen enthält, gibt die Methode null zurück
     * @param lo Liste welche in Paare gruppiert werden sollen
     * @return die paarweise Liste von Paaren
     */
    public static List<List<Object>> inPairs(List<Object> lo) {
        List<List<Object>>inPairs = new ArrayList<>();
        if (lo.size() % 2 != 0) {
            return null;
        } else {
            for (int i = 0; i < lo.size(); i+=2) {
                List<Object> storeElem = new ArrayList<>();
                storeElem.add(lo.get(i));
                storeElem.add(lo.get(i+1));
                inPairs.add(storeElem);
            }
        }
        return inPairs;
    }
}
