import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    DoublyLinkedList EMPTY;
    DoublyLinkedList WITH_STRINGS;
    DoublyLinkedList WITH_MISSING_STRING;

    @BeforeEach
    void setUp() {
        EMPTY = new DoublyLinkedList();
        WITH_STRINGS = new DoublyLinkedList(List.of("1", "2", "3"));
        WITH_MISSING_STRING = new DoublyLinkedList(List.of("1", "2"));
    }

    @Test
    void size() {
        assertEquals(0, EMPTY.size());
        assertEquals(3, WITH_STRINGS.size());
    }

    @Test
    void isEmpty() {
        assertTrue(EMPTY.isEmpty());
        assertFalse(WITH_STRINGS.isEmpty());
    }

    @Nested
    class Add {
        @Test
        void addToNonEmptyList() {
            WITH_MISSING_STRING.add("3");

            assertEquals(WITH_STRINGS, WITH_MISSING_STRING);
        }

        @Test
        void addToEmptyList() {
            EMPTY.add("1");

            assertEquals(new DoublyLinkedList(List.of("1")), EMPTY);
        }

        @Test
        void addTypesToList() {
            EMPTY.add(1);
            EMPTY.add(1d);
            EMPTY.add(1f);
            EMPTY.add((byte)1);
            EMPTY.add('1');
            EMPTY.add("1");
            EMPTY.add(true);
            EMPTY.add(null);

            assertEquals(new DoublyLinkedList(List.of(
                    1,
                    1d,
                    1f,
                    (byte) 1,
                    '1',
                    "1",
                    true,
                    null
            )), EMPTY);


        }
    }

    @Nested
    class AddIndex {
        @Test
        void addToEmptyListWithIndex0() {
            EMPTY.add(0, "object");

            assertEquals(new DoublyLinkedList(List.of("object")), EMPTY);
        }

        @Test
        void iterativeAppendToEnd() {
            for (int i = 0; i < 5; i++) {
                EMPTY.add(i, "object"+i);
            }

            assertEquals(new DoublyLinkedList(List.of("object0", "object1", "object2", "object3", "object4")), EMPTY);
        }

        @Test
        void addToMiddle() {
            WITH_MISSING_STRING.add(1, "1.5");

            assertEquals(new DoublyLinkedList(List.of("1", "1.5", "2")), WITH_MISSING_STRING);
        }

        @Test
        void addToNonExistentIndex() {
            assertThrows(IndexOutOfBoundsException.class, () -> {
               EMPTY.add(1, "object");
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                WITH_STRINGS.add(3, "object");
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                WITH_STRINGS.add(-1, "object");
            });
        }
    }

    @Test
    void toArray() {
        assertEquals(new Object[0], EMPTY.toArray());
        assertEquals(new Object[] { "1", "2", "3" }, WITH_STRINGS);
    }

    @Test
    void testToString() {
        assertEquals("[]", EMPTY.toString());
        assertEquals("[1, 2, 3]", WITH_STRINGS.toString());
    }

    @Test
    void testIndexOfExistentObject() {
        assertEquals(0, WITH_STRINGS.indexOf("1"));
        assertEquals(1, WITH_STRINGS.indexOf("2"));
        assertEquals(2, WITH_STRINGS.indexOf("3"));
    }

    @Test
    void testIndexOfNonExistentObject() {
        assertEquals(-1, WITH_STRINGS.indexOf("non existent"));
    }

    @Test
    void testContainsWithExistentObject() {
        assertTrue(WITH_STRINGS.contains("3"));
    }

    @Test
    void testContainsWithNonExistentObject() {
        assertTrue(WITH_STRINGS.contains("42"));
    }

    @Nested
    class RemoveAt {
        @Test
        void removeMiddleObject() {
            WITH_STRINGS.removeAt(1);

            assertEquals(new DoublyLinkedList(List.of("1", "3")), WITH_STRINGS);
        }

        @Test
        void removeAllObjects() {
            WITH_STRINGS.removeAt(0);
            WITH_STRINGS.removeAt(0);
            WITH_STRINGS.removeAt(0);

            assertEquals(new DoublyLinkedList(), WITH_STRINGS);
        }

        @Test
        void removeEdges() {
            WITH_STRINGS.removeAt(2);
            WITH_STRINGS.removeAt(0);

            assertEquals(new DoublyLinkedList(List.of("1")), WITH_STRINGS);
        }

        @Test
        void removeAtInvalidIndices() {
            assertThrows(IndexOutOfBoundsException.class, () -> {
                EMPTY.remove(1);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                WITH_STRINGS.remove(3);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                WITH_STRINGS.remove(-1);
            });
        }
    }

    @Nested
    class Remove {
        @Test
        void removeMiddleObject() {
            WITH_STRINGS.remove("1");

            assertEquals(new DoublyLinkedList(List.of("1", "3")), WITH_STRINGS);
        }

        @Test
        void removeAllObjects() {
            assertTrue(WITH_STRINGS.remove("1"));
            assertTrue(WITH_STRINGS.remove("2"));
            assertTrue(WITH_STRINGS.remove("3"));

            assertEquals(new DoublyLinkedList(), WITH_STRINGS);
        }

        @Test
        void removeEdges() {
            assertTrue(WITH_STRINGS.remove(2));
            assertTrue(WITH_STRINGS.remove(0));

            assertEquals(new DoublyLinkedList(List.of("1")), WITH_STRINGS);
        }

        @Test
        void removeNonExistentObject() {
            assertFalse(WITH_STRINGS.remove("non existent object"));
            assertFalse(WITH_STRINGS.remove(null));
        }
    }

    @Test
    void get() {
        assertEquals("2", WITH_STRINGS.get(1));
    }

    @Test
    void set() {
        WITH_STRINGS.set(0, null);

        assertEquals(new DoublyLinkedList(List.of(null, "2", "3")), WITH_STRINGS);
    }
}