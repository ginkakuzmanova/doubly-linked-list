package implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<String> list = new LinkedList<>();

    @BeforeEach
    public void setUp() {
        try {
            this.list = new LinkedList<>();
            for (int i = 0; i < 100; i++) {
                list.addLast(String.valueOf(i));
            }
        } catch (Exception ignored) {
            this.list = new LinkedList<>();
        }
    }

    @Test
    public void testAddSingleElementInFront() {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.addFirst(73);
        assertEquals(Integer.valueOf(73), integers.getFirst());
    }

    @Test
    public void testAddSingleElementInBack() {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.addLast(73);
        assertEquals(Integer.valueOf(73), integers.getLast());
    }

    @Test
    public void testAddFirstShouldAddInFront() {
        this.list.addFirst("Slayer");
        assertEquals("Slayer", list.getFirst());
    }

    @Test
    public void testAddLastShouldAddAtTheEnd() {
        this.list.addLast("Slayer");
        assertEquals("Slayer", list.getLast());
    }

    @Test
    public void testRemoveFirstShouldRemoveTheFirstElement() {
        assertEquals("0", list.getFirst());
        assertEquals("0", list.removeFirst());
        assertEquals("1", list.getFirst());
    }

    @Test
    public void testRemoveLastShouldRemoveTheLastElement() {
        assertEquals("99", list.getLast());
        assertEquals("99", list.removeLast());
        assertEquals("98", list.getLast());
    }

    @Test
    public void testRemoveLastShouldRemoveLast() {
        LinkedList<Integer> doublyLinkedList = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            doublyLinkedList.addLast(i);
        }
        int val = 999;
        while (!doublyLinkedList.isEmpty()) {
            assertEquals(val--, doublyLinkedList.removeLast());
        }
    }

    @Test
    public void testGetFirstShouldReturnButNotRemove() {
        assertEquals("0", list.getFirst());
        assertEquals("0", list.getFirst());
        assertEquals(100, list.size());
    }

    @Test
    public void testGetLastShouldReturnButNotRemove() {
        assertEquals("99", list.getLast());
        assertEquals("99", list.getLast());
        assertEquals(100, list.size());
    }

    @Test
    public void testSize() {
        assertEquals(100, list.size());
        assertEquals(0, new LinkedList<>().size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        assertTrue(new LinkedList<>().isEmpty());
    }
}