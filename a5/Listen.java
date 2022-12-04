import java.io.PrintStream;
import java.util.*;

public class Listen {

    public static List<Integer> intersectAll(Collection<Collection<Integer>> colOfIntegerCols) {
        Iterator<Collection<Integer>> iterator = colOfIntegerCols.iterator();
        Collection<Integer> first = iterator.next();
        while (iterator.hasNext()) {
            first.retainAll(iterator.next());
        }
        return (List<Integer>) first;
    }

    public static List<Integer> collectAllIndices(List<String> ls, String elem) {
        List<Integer> indices = new ArrayList<>();
        for(int i=0; i<ls.size();i++){  //size gibt die Länge der Liste wieder
            String vergleich = ls.get(i); //get holt den aktuellen i und weist es vergleich zu
            if(elem.equals(vergleich)){
                indices.add(i);
            }
        }
        return indices;
    }

    public static void printOpposites(List<Integer> li) {

        if(li.size()%2!=0){
            System.out.println("Uneven List");
        } else{
            for(int i=0; i<li.size()/2 ;i++){
                int vorne = li.get(i);
                int hinten= li.get(li.size()-i-1);
                System.out.printf("%d:%d %n",vorne,hinten);
            }
        }
    }

    public static boolean isProperSuperset(List<Integer> li1, List<Integer> li2) {
        for(int i :li2){
            if(!li1.contains(li2) || li2.size()>=li1.size()){
                return false;
            }
        }
        return true;
    }

    public static void removeAll(List<Object> lo, Object o) {
        Iterator<Object> objectIterator = lo.iterator();
            while(objectIterator.hasNext()){
                Object compare = objectIterator.next();
                if (compare.equals(o)){
                    objectIterator.remove();
                }
            }
        System.out.println(lo);
    }

    public static void removeX(List<Object> lo, int start, int end) {

    }

    public static boolean hasNoDuplicates(List<Object> lo) {
        return false;
    }

    public static List<Object> collectDuplicates(List<Object> lo) {
        return null;
    }

    public static List<List<Object>> inPairs(List<Object> lo) {
        return null;
    }

}
