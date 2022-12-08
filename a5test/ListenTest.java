import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListenTest {

    @Test
    void intersectionTest() {
        Collection<Collection<Integer>> collection = collection(
                collection(1, 2, 3),
                collection(1, 6, 1),
                collection(8, 6, 1)
        );

        assertEquals(List.of(1), Listen.intersectAll(collection));
    }

    @Test
    void indicesCollectionTest() {
        List<String> collection = collection(
                "Test",
                "foo",
                "foo",
                "bar",
                "sdfghnj",
                "dsf2e1",
                "bar"
        );

        assertEquals(List.of(3, 6), Listen.collectAllIndices(collection, "bar"));
    }

    @Test
    void printOppositesTest() {
        List<Integer> collection = (List<Integer>) collection(
                1,
                2,
                3,
                4,
                5,
                6
        );

        Listen.printOpposites(collection);
    }

    @Test
    void isProperSupersetTest() {
        List<Integer> obermenge = collection(
                1,
                2,
                3,
                4,
                5
        );

        List<Integer> untermenge = collection(
                1,
                2,
                3
        );

        assertTrue(Listen.isProperSuperset(obermenge, untermenge));
    }

    @Test
    void isNotProperSupersetTest() {
        List<Integer> obermenge = collection(
                1,
                2,
                3,
                4,
                5
        );

        List<Integer> untermenge = collection(
                4,
                5,
                6
        );

        assertFalse(Listen.isProperSuperset(obermenge, untermenge));
    }

    @Test
    void removeAllTest() {
        List<Object> collection = collection(
                1,
                2,
                3,
                1,
                5
        );
        Listen.removeAll(collection, 1);
        assertEquals(List.of(2, 3, 5), collection);
    }

    @Test
    void removeLRTest() {
        List<Object> collection = collection(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8
        );

        Listen.removeLR(collection, 1, 6);
        assertEquals(List.of(1, 8), collection);
    }

    @Test
    void removeRLTest() {
        List<Object> collection = collection(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8
        );

        Listen.removeRL(collection, 1, 6);
        assertEquals(List.of(1, 8), collection);
    }

    @Test
    void hasNoDuplicatesTest() {
        List<Object> collection = collection(
                1,
                2,
                3
        );

        assertTrue(Listen.hasNoDuplicates(collection));
    }

    @Test
    void hasDuplicatesTest() {
        List<Object> collection = collection(
                1,
                2,
                2,
                3
        );

        assertFalse(Listen.hasNoDuplicates(collection));
    }

    @Test
    void collectDuplicatesTest() {
        List<Object> collection = collection(
                1,
                2,
                3,
                1,
                3,
                5,
                1
        );

        assertEquals(List.of(1, 3), Listen.collectDuplicates(collection));
    }

    @Test
    void inPairsOddTest() {
        assertNull(Listen.inPairs(List.of(1, 2, 3)));
    }

    @Test
    void inPairsTest() {
        List<Object> collection = collection(
                1,
                2,
                3,
                1,
                3,
                5
        );

        assertEquals(List.of(List.of(1, 2), List.of(3, 1), List.of(3, 5)), Listen.inPairs(collection));
    }

    private <T> List<T> collection(T... elements) {
        List<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

}
