import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MapsTest {

    @Test
    public void frequencyMapTest() {
        List<Object> collection = collection(1, "hi", 6, 7.8, 6, "hi", 1, 1, 1, "ho");

        assertEquals(Map.of(
                1, 4,
                "hi", 2,
                6, 2,
                "ho", 1,
                7.8, 1
        ), Maps.frequencyMap(collection));
    }

    @Test
    public void allKeyValSumLowerTest() {
        Map<Double, Double> map = Map.of(
                5.5d, 4.5d,
                1.0d, 17.0d
        );

        assertTrue(Maps.allKeyValSumLower(map, 40));
        assertFalse(Maps.allKeyValSumLower(map, 25));
    }

    @Test
    public void printFormattedTest() {
        Map<Object, Object> map = Map.of(
                5.5d, 4.5d,
                1.0d, 17.0d
        );

        Maps.printFormatted(map);
    }

    @Test
    public void flattenTest() {
        Map<Object,Map<Object,Object>> momoo = Map.of(
                "$", Map.of(1, 4, "hi", 2, 6, 2, "ho", 1, 7.8, 1),
                "§", Map.of(1, 3, 6, 2, "ho", 2, "hello", 1, 7.8, 2)
        );
        List<Object> expected = List.of("$", 1, 4, "$", "hi", 2, "$", 6, 2, "$", "ho", 1, "$", 7.8, 1, "§",
                1, 3, "§", 6, 2, "§", "ho", 2, "§", "hello", 1, "§", 7.8, 2);

        List<Object> actual = Maps.flatten(momoo);
        assertTrue(actual.size() == expected.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));

    }

    @Test
    public void asNestedMapTest() {
        List<Object> input = List.of("$", 1, 4, "$", "hi", 2, "$", 6, 2, "$", "ho", 1, "$", 7.8, 1, "§",
                1, 3, "§", 6, 2, "§", "ho", 2, "§", "hello", 1, "§", 7.8, 2);
        Map<Object,Map<Object,Object>> expected = Map.of(
                "$", Map.of(1, 4, "hi", 2, 6, 2, "ho", 1, 7.8, 1),
                "§", Map.of(1, 3, 6, 2, "ho", 2, "hello", 1, 7.8, 2)
        );

        assertEquals(expected, Maps.asNestedMap(input));
    }

    @Test
    public void mapToSqrtTest() {
        Map<Double, Double> values = Map.of(17.0, 21.0, 121.0, 144.0);
        Map<Double, Double> result = Map.of(11.0, 12.0, 4.123105625617661, 4.58257569495584);

        assertEquals(result, Maps.mapToSqrt(values));
    }

    private <T> List<T> collection(T... elements) {
        List<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

}