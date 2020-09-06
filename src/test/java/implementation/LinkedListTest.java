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

    @Test
    public void testClear() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testOfferFirst() {
        assertTrue(list.offerFirst("Yordan"));
        assertEquals("Yordan", list.getFirst());
    }

    @Test
    public void testOfferLast() {
        assertTrue(list.offerLast("Yordan"));
        assertEquals("Yordan", list.getLast());
    }

    @Test
    public void testPollFirst() {
        String first = list.pollFirst();
        assertEquals("0", first);
        assertEquals("1", list.element());
        assertEquals(99, list.size());
    }

    @Test
    public void testPollLast() {
        String last = list.pollLast();
        assertEquals("99", last);
        assertEquals("98", list.getLast());
        assertEquals(99, list.size());
    }

    @Test
    public void testAdd() {
        assertTrue(list.add("Maria"));
        assertEquals("Maria", list.getLast());
        assertEquals(101, list.size());
    }

    @Test
    public void testOffer() {
        assertTrue(list.offer("Maria"));
        assertEquals("Maria", list.getLast());
        assertEquals(101, list.size());
    }

    @Test
    public void testRemove() {
        String removed = list.remove();
        assertEquals("99", removed);
        assertEquals(99, list.size());
    }

    @Test
    public void testPoll() {
        String removed = list.poll();
        assertEquals("0", removed);
        assertEquals(99, list.size());
    }

    @Test
    public void testPeek() {
        String peeked = list.peek();
        assertEquals("0", peeked);
    }

    @Test
    public void testInsert() {
        list.insert(0, "Pesho");
        list.insert(5, "Elena");
        assertEquals("Pesho", list.get(0));
        assertEquals("Elena", list.get(5));
    }

    @Test
    public void testDelete() {
        list.delete(0);
        list.delete(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-5));
        assertEquals("1", list.getFirst());
        assertEquals("4", list.get(2));
        assertEquals(98, list.size());
    }

    @Test
    public void testSet() {
        list.set(1, "Gosho");
        assertEquals("Gosho", list.get(1));
    }

    @Test
    public void testDeleteByValue() {
        assertTrue(list.delete("0"));
        assertEquals("1", list.get(0));
        assertTrue(list.delete("54"));
        assertEquals("56", list.get(54));
        assertEquals(98, list.size());
    }

    @Test
    public void testContains() {
        assertTrue(list.contains("54"));
        assertFalse(list.contains("1000"));
    }

    @Test
    public void testEnsureValidIndex() {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.poll();
        assertThrows(IllegalStateException.class, integers::poll);
        assertEquals(0, integers.size());
    }
}