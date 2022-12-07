import java.io.PrintStream;
import java.util.*;

public class Listen {

    public static List<Integer> intersectAll(Collection<Collection<Integer>> colOfIntegerCols) {
        Iterator<Collection<Integer>> iterator = colOfIntegerCols.iterator();
        List<Integer> intersection = new ArrayList<>(iterator.next());
        while (iterator.hasNext()) {
            intersection.retainAll(iterator.next());
        }
        return intersection;
    }

    public static List<Integer> collectAllIndices(List<String> ls, String elem) {
        List<Integer> indices = new ArrayList<>();
        for(int i=0; i<ls.size();i++){
            String vergleich = ls.get(i);
            if(elem.equals(vergleich)){
                indices.add(i);
            }
        }
        return indices;
    }

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

    /*public static boolean isProperSuperset(List<Integer> li1, List<Integer> li2) {
        for(int i :li2){
            if(!li1.contains(li2) || li2.size()>=li1.size()){
                return false;
            }
        }return true;
    }*/
    public static boolean isProperSuperset(List<Integer> li1, List<Integer> li2) {
        Set<Integer> se1 = new HashSet<>(li1);
        Set<Integer> se2 = new HashSet<>(li2);
        if (se1.size() > se2.size() && se1.containsAll(se2)){
            return true;
        }else return false;
        //return (se1.size() > se2.size() && se1.containsAll(se2));
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

    public static void removeXRL(List <Object> lo, int start, int end) {
        int startPoint = start;

        while (startPoint < end){
            Iterator<Object> removeIterator = lo.listIterator(start);
            removeIterator.next();
            removeIterator.remove();
            startPoint++;
        }
        System.out.println(lo);
    }
    public static void removeXLR (List <Object> lo, int start, int end){
        int endPoint = end;
        ListIterator<Object> removeIterator = lo.listIterator(end-1);

        while (endPoint > start){
            removeIterator.previous();
            removeIterator.remove();
            endPoint--;
        }
        System.out.println(lo);
    }
    public static boolean hasNoDuplicates(List<Object> lo) {
        return new HashSet<>(lo).size() == lo.size();
    }

    public static List<Object> collectDuplicates(List<Object> lo) {
        List<Object> duplicateList = new ArrayList<Object>(lo);
        for (Object i : duplicateList) {
            for(Object a : lo){
                if(lo.get((Integer)i).equals(a)){
                    duplicateList.remove(i);
                }
            }
        }
        return duplicateList;
    }

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
