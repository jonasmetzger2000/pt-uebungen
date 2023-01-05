package recursion;

import java.util.*;

public class RecursiveCollections {

    /**
     * Die Methode sammelt alle Collections ein, die mindestens eine Zahl enthalten
     *
     * @param col eine beliebig geschachtelte Collection
     * @return Eine Liste mit den Collections, die mindestens eine Zahl enthalten
     */
    public static List<Object> collectAllAtLeastOneNumber(Collection<?> col) {
        return collectAllAtLeastOneNumber(col, new ArrayList<>());
    }

    private static List<Object> collectAllAtLeastOneNumber(Collection<?> col, List<Object> collectionsWithInteger) {
        for (Object obj : col) {
            if (obj instanceof Collection<?>) {
                collectAllAtLeastOneNumber((Collection<?>) obj, collectionsWithInteger);
            } else addCollectionIfInteger(col, collectionsWithInteger, obj);
        }
        return collectionsWithInteger;
    }

    private static void addCollectionIfInteger(Collection<?> col, List<Object> collectionsWithInteger, Object obj) {
        if (!collectionsWithInteger.contains(col) && obj instanceof Integer) {
            collectionsWithInteger.add(col);
        }
    }

    /**
     * Die Methode zählt die Collections einer beliebig geschachtelten Collection,
     * die eine Mindestanzahl von Collections enthält.
     *
     * @param col                die beliebig geschachtelte Collection
     * @param numOfContainedCols Mindestanzahl der enthaltenen Collections
     * @return Anzahl der Collections inkl. ggf. der äußeren, die die Bdg. erfüllen.
     */
    public static int countAtLeastContainingCols(Collection<?> col, int numOfContainedCols) {
        int currentContainedCols = 0;
        for (Object obj : col) {
            if (obj instanceof Collection<?>) {
                currentContainedCols += countAtLeastContainingCols((Collection<?>) obj, numOfContainedCols);
            }
        }
        if (collectionContainsNInnerCollections(col, numOfContainedCols)) {
            return 1 + currentContainedCols;
        } else {
            return currentContainedCols;
        }
    }

    private static boolean collectionContainsNInnerCollections(Collection<?> col, int expectedNumberOfInnerCollections) {
        int numberOfInnerCollections = 0;
        for (Object obj : col) {
            if (obj instanceof Collection<?>) {
                numberOfInnerCollections++;
            }
            if (numberOfInnerCollections >= expectedNumberOfInnerCollections) {
                return true;
            }
        }
        return false;
    }

    /**
     * Die Methode bestimmt für jedes Element, das keine Collection ist, die Schachtelungstiefe
     * in einer beliebig geschachtelten Collection und sammelt diese in einer Liste ein.
     *
     * @param col die beliebig geschachtelte Collection
     * @return die Liste mit den Schachtelungstiefen. Die Nicht-Collection-Elemente der äußeren Collection
     * haben die Schachtelungstiefe 1.
     */
    public static List<Integer> depthCollector(Collection<?> col) {
        return depthCollector(col, 1, new ArrayList<>());
    }

    private static List<Integer> depthCollector(Collection<?> col, int depth, List<Integer> result) {
        for (Object obj : col) {
            if (obj instanceof Collection<?>) {
                depthCollector((Collection<?>) obj, depth+1, result);
            } else {
                result.add(depth);
            }
        }
        return result;
    }

    /**
     * Die Methode prüft, ob alle Collections einer beliebig geschachtelten Collection, auch die äußere,
     * eine Mindestanzahl von Strings enthalten.
     *
     * @param col          die beliebig geschachtelte Collection
     * @param numOfStrings die Mindestanzahl an Strings pro Collection
     * @return false, wenn mindestens eine Collection, die Mindestanzahl nicht enthält, sonst false.
     */
    public static boolean allContainAtLeastNStrings(Collection<?> col, int numOfStrings) {
        for (Object obj : col) {
            if (obj instanceof Collection<?>) {
                final boolean b = allContainAtLeastNStrings((Collection<?>) obj, numOfStrings);
                if (!b)
                    return false;
            }
        }
        return collectionContainsAtleastNStrings(col, numOfStrings);
    }

    private static boolean collectionContainsAtleastNStrings(Collection<?> col, int expectedNumOfStrings) {
        int numOfStrings = 0;
        for (Object obj : col) {
            if (obj instanceof String) {
                numOfStrings++;
            }
            if (numOfStrings >= expectedNumOfStrings) {
                return true;
            }
        }
        return false;
    }

    /**
     * Die Methode prüft, ob eine beliebig geschachtelte Liste die Struktur eines Binärbaums hat.
     * Ein Binärbaum ist entweder eine Liste mit einem Element, das keine Liste ist, oder eine Liste
     * mit 3 Elementen, von denen das erste keine Liste ist und das zweite und dritte Element ein Binärbaum sind.
     *
     * @param list die beliebig geschachtelte Liste
     * @return true, wenn der Parameter die Struktur eines Binärbaums hat, sonst false.
     */
    public static boolean isBinary(List<?> list) {
        if (list.size() == 1) {
            return (!(list.get(0) instanceof List));
        } else if (list.size() == 3) {
            int elements = 0;
            int lists = 0;
            boolean isInnerTreeABinary = false;
            for (Object obj : list) {
                if (obj instanceof List<?>) {
                    lists++;
                    isInnerTreeABinary = isBinary((List<?>) obj);
                } else {
                    elements++;
                }
            }
            return isInnerTreeABinary && elements == 1 && lists == 2;
        }
        return false;
    }

    /**
     * Die Methode berechnet für eine beliebig geschachtelte Collection eine Map, in der die Häufigkeit des Auftretens
     * der Nicht-Collection-Elemente protokolliert wird.
     *
     * @param col die beliebig geschachtelte Collection
     * @return die Häufigkeits-Map
     */
    public static Map<Object, Integer> occurenceMap(Collection<?> col) {
        return occurenceMap(col, new HashMap<>());
    }

    private static Map<Object, Integer> occurenceMap(Collection<?> col, Map<Object, Integer> result) {
        for (Object obj : col) {
            if (obj instanceof Collection<?>) occurenceMap((Collection<?>) obj, result);
            else result.merge(obj, 1, Integer::sum);
        }
        return result;
    }


    public static void main(String[] args) {
        Collection<?> colOfCols = List.of(1, Set.of(3, 4), 8, Set.of(3, List.of(3, Set.of(8))));
        System.out.println(colOfCols);
        System.out.println(depthCollector(colOfCols));

        List<?> listOfLists = List.of(1, List.of(2), List.of(3, List.of(4), List.of(5)));
        System.out.println(listOfLists);

        System.out.println(isBinary(listOfLists));

        System.out.println(colOfCols);
        System.out.println(occurenceMap(colOfCols));

        Collection<?> colOfCols2 = List.of(1, Set.of(3, "four"), "eight", Set.of("three", List.of("three", Set.of("eight"))));
        System.out.println(colOfCols2);
        System.out.println(allContainAtLeastNStrings(colOfCols2, 1));
    }


}
