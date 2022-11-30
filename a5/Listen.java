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
        return null;
    }

    public static void printOpposites(List<Integer> li) {

    }

    public static boolean isProperSuperset(List<Integer> li1, List<Integer> li2) {
        return false;
    }

    public static void removeAll(List<Object> lo, Object o) {

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
