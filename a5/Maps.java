import java.util.*;

public class Maps {

    /**
     * Mappt die Häufigkeiten einer Liste in eine Map.
     * @param lo Liste von welcher die Häufigkeiten gemappt werden sollen
     * @return die Häufigkeitsmap
     */
    public static Map<Object,Integer> frequencyMap(List<Object> lo) {
        Map<Object, Integer> frequencyMap = new HashMap<>();
        for (Object obj : lo) {
//            frequencyMap.merge(obj, 1, Integer::sum);
            if (frequencyMap.containsKey(obj)) {
                frequencyMap.put(obj, frequencyMap.get(obj) + 1);
            } else {
                frequencyMap.put(obj, 1);
            }
        }
        return frequencyMap;
    }

    /**
     * Überprüft ob die Summe von allen Schlüssel-Wert Paaren kleiner als die gegebene Nummer sind
     * @param mnn Map mit Double Werten welche summiert werden sollen
     * @param num nummer die kleiner sein soll als die Schlüssel Wert Paare
     * @return wenn die summe von den schlüssel wert paaren kleiner als nummer ist true, ansonsten false
     */
    public static boolean allKeyValSumLower(Map<Double,Double> mnn, long num) {
        double sum = 0;
        for (Map.Entry<Double, Double> entry : mnn.entrySet()) {
            sum += (entry.getKey() + entry.getValue());
        }
        return sum < num;
    }

    /**
     * Formatiert die gegebenene Map. Jedes Schlüssel-Wert-Paar steht in einer Zeile. Die Schlüssel
     * werden in der Ausgabe durch "=>" von den Werten getrennt. Die Elemente sindrechtsbündig ausgerichtet.
     * @param moo zu formatierrende Map
     */
    public static void printFormatted(Map<Object,Object> moo) {
        int maxKeyLength = 0;
        int maxValLength = 0;

        for (Map.Entry<Object, Object> entry : moo.entrySet()) {
            int keyLength = String.valueOf(entry.getKey()).length();
            int valLength = String.valueOf(entry.getValue()).length();

            if (maxKeyLength < keyLength) {
                maxKeyLength = keyLength;
            }

            if (maxValLength < valLength) {
                maxValLength = valLength;
            }
        }
        String format = "%-" + maxKeyLength + "s => %" + maxValLength + "s%n";

        for (Map.Entry<Object, Object> entry : moo.entrySet()) {
            System.out.printf(format, entry.getKey(), entry.getValue());
        }
    }

    /**
     * Flattened die gegebene Liste, sprich die Elemente der Liste werden in die oberliegende Liste überführt.
     * @param momoo zu flattende Map
     * @return die flattened Map
     */
    public static List<Object> flatten(Map<Object,Map<Object,Object>> momoo) {
        List<Object> flattened = new ArrayList<>();
        for (Map.Entry<Object, Map<Object, Object>> entry : momoo.entrySet()) {
            for (Map.Entry<Object, Object> innerEntry : entry.getValue().entrySet()) {
                flattened.add(entry.getKey());
                flattened.add(innerEntry.getKey());
                flattened.add(innerEntry.getValue());
            }
        }
        return flattened;
    }

    /**
     * Erstellt aus einer Liste eine geschachtelte Map. Dabei werden jeweils 3 Elemente jeweils gruppiert. Wenn
     * die Elemente kein Vielfaches von 3 wird null ausgegebenn.
     * Gruppierung:
     * Key der äußeren Map: erstes Element
     * Key der inneren Map: zweites Element
     * Value der inneren Map: drittes Element
     * @param lo die Liste der Größe eines vielfachen von 3
     * @return eine nestes Map
     */
    public static Map<Object,Map<Object,Object>> asNestedMap(List<Object> lo) {
        if (lo.size() % 3 != 0) {
            return null;
        }

        Map<Object,Map<Object,Object>> nestedMap = new HashMap<>();
        Iterator<Object> iterator = lo.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Map<Object, Object> inner;
            // Wenn eine nested map bereits existiert, append 2. & 3. Element an das bestehende
            if (nestedMap.containsKey(key)) {
                inner = nestedMap.get(key);
            } else {
                inner = new HashMap<>();
            }
            inner.put(iterator.next(), iterator.next());
            nestedMap.put(key, inner);
        }
        return nestedMap;
    }

    /**
     * Mapt eine gegebene Map auf eine neue, dabei werden die neuen Werte aus der Wurzel der vorherigen Map abgebildet
     * @param mdd Map mit Gleitkommazahlen
     * @return Map mit Gleitkommazahlen, dabei sind die Values aus der Wurzel gebildet
     */
    public static Map<Double,Double> mapToSqrt(Map<Double,Double> mdd) {
        Map<Double, Double> sqrtMap = new HashMap<>();
        for (Map.Entry<Double, Double> entry : mdd.entrySet()) {
            sqrtMap.put(Math.sqrt(entry.getKey()), Math.sqrt(entry.getValue()));
        }
        return sqrtMap;
    }

}
