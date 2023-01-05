package recursion;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveCollectionsTest {

    final Object obj = new Object();

    @Test
    void collectAllAtLeastOneNumber() {
        final List<Object> objects = List.of(
                2,
                obj,
                obj,
                List.of(
                        obj,
                        obj,
                        obj,
                        List.of(
                                obj,
                                5,
                                List.of(
                                        1
                                )
                        )
                ),
                obj
        );

        final List<List<?>> expected = List.of(
                objects,
                List.of(
                        obj,
                        5,
                        List.of(
                                1
                        )
                ),
                List.of(1)
        );
        final List<Object> actual = RecursiveCollections.collectAllAtLeastOneNumber(objects);
        assertTrue(expected.size() == actual.size() && actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test
    void countAtLeastContainingCols() {
        final List<Object> objects = List.of(
                obj,
                List.of(
                        obj,
                        List.of(),
                        List.of()
                ),
                obj,
                List.of(
                        List.of(
                                List.of(),
                                List.of()
                        ),
                        List.of()
                ),
                List.of(
                        List.of(
                                List.of(
                                        obj,
                                        obj
                                ),
                                List.of()
                        )
                )
        );
        assertEquals(5, RecursiveCollections.countAtLeastContainingCols(objects, 2));
    }

    @Test
    void depthCollector() {
        final List<Object> depthObjects = List.of(
                1,
                List.of(4, 3),
                8,
                List.of(
                        List.of(6, List.of(8)),
                        5
                )
        );

        assertEquals(List.of(1, 2, 2, 1, 3, 4, 2), RecursiveCollections.depthCollector(depthObjects));
    }

    @Test
    void allContainAtLeastNStrings() {
        final List<Object> objects = List.of(1, Set.of(3, "four"), "eight", Set.of("three", List.of("three", Set.of("eight"))));
        assertTrue(RecursiveCollections.allContainAtLeastNStrings(objects, 1));

        final List<Object> objectsFalse = List.of(1, Set.of(3, "four"), 8, Set.of("three", List.of("three", Set.of("eight"))));
        assertFalse(RecursiveCollections.allContainAtLeastNStrings(objectsFalse, 1));
    }

    @Test
    void isBinary() {
        final List<Object> binaryTree = List.of(1, List.of(2), List.of(3, List.of(4), List.of(5)));
        final List<Integer> binaryTree2 = List.of(5);

        // [1, [2], [3, [4]]]
        final List<Object> nonBinaryTree = List.of(1, List.of(2), List.of(3, List.of(4)));
        // [[1], [2], [3, [4], [5]]]
        final List<List<?>> nonBinaryTree2 = List.of(List.of(1), List.of(2), List.of(3, List.of(4, 5)));
        // [1, 2, [3, [4], [5]]]
        final List<Object> nonBinaryTree3 = List.of(1, 2, List.of(3, List.of(4), List.of(5)));
        // [1, [2]]
        final List<Object> nonBinaryTree4 = List.of(1, List.of(2));

        assertAll(() -> {
            assertTrue(RecursiveCollections.isBinary(binaryTree));
            assertTrue(RecursiveCollections.isBinary(binaryTree2));

            assertFalse(RecursiveCollections.isBinary(nonBinaryTree));
            assertFalse(RecursiveCollections.isBinary(nonBinaryTree2));
            assertFalse(RecursiveCollections.isBinary(nonBinaryTree3));
            assertFalse(RecursiveCollections.isBinary(nonBinaryTree4));
        });
    }

    @Test
    void occurenceMap() {
        final List<Object> objects = List.of(1, Set.of(3, 4), 8, Set.of(3, List.of(3, Set.of(8))));

        assertEquals(Map.of(1, 1, 3, 3, 4, 1, 8, 2), RecursiveCollections.occurenceMap(objects));
    }
}