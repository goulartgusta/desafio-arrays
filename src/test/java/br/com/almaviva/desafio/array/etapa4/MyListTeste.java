package br.com.almaviva.desafio.array.etapa4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyListTest {

    private MyList<String> list;

    @BeforeEach
    void setup() {
        list = new MyList<>();
    }

    @Test
    void testInitialState() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testAddAndGet() {
        list.add("A");
        list.add("B");
        list.add("A"); 
        assertEquals(3, list.size());
    }

    @Test
    void testAddNull() {
        list.add(null);
        assertEquals(1, list.size());
        assertNull(list.get(0));
        assertTrue(list.contains(null));
    }

    @Test
    void testSet() {
        list.add("X");
        list.add("Y");
        assertEquals("X", list.set(0, "Z"));
        assertEquals("Z", list.get(0));
    }

    @Test
    void testSetInvalidIndex() {
        list.add("OnlyOne");
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, "Fail"));
    }

    @Test
    void testRemoveByIndex() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertFalse(list.contains("B"));
    }

    @Test
    void testRemoveByIndexInvalid() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testContains() {
        list.add("test");
        assertTrue(list.contains("test"));
        assertFalse(list.contains("other"));
        list.add(null);
        assertTrue(list.contains(null));
    }

    @Test
    void testClear() {
        list.add("A");
        list.add("B");
        list.clear();
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testIndexOutOfBoundsOnGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add("Value");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
}
