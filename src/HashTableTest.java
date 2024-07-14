import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void addOne() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        assertEquals(1, hi.getSize());
    }
    @Test
    void addTwo() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        hi.add(2, "spongebob");
        assertEquals(2, hi.getSize());
    }
    @Test
    void addMultiple() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        hi.add(2, "spongebob");
        hi.add(3,"hey, there");
        hi.add(100, "one hundred's value");
        hi.add(23, "wassup");
        hi.add(5, "high five");
        assertEquals(6, hi.getSize());
    }

    @Test
    void getOne() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        assertEquals("sponge", hi.get(1));

    }
    @Test
    void getTwo() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        hi.add(3, "three");
        assertEquals("sponge", hi.get(1));
        assertEquals("three", hi.get(3));

    }
    @Test
    void getMultiple() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        hi.add(3, "three");
        hi.add(111, "four");
        hi.add(33, "kobe");
        hi.add(76, "mj");
        hi.add(9, "bron");
        hi.add(7, "bronbron");
        hi.add(43, "curry");
        assertEquals("sponge", hi.get(1));
        assertEquals("three", hi.get(3));
        assertEquals("four", hi.get(111));
        assertEquals("kobe", hi.get(33));
        assertEquals("mj", hi.get(76));
        assertEquals("bron", hi.get(9));
        assertEquals("bronbron", hi.get(7));
        assertEquals("curry", hi.get(43));
        assertEquals(8, hi.getSize());

    }

    @Test
    void containsKeyAndVal() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        hi.add(3, "three");
        hi.add(111, "four");
        hi.add(33, "kobe");
        hi.add(76, "mj");
        hi.add(9, "bron");
        hi.add(7, "bronbron");
        hi.add(43, "curry");

        assertTrue(hi.containsKeyAndVal(1, "sponge"));
        assertFalse(hi.containsKeyAndVal(3, "sponge"));
        assertTrue(hi.containsKeyAndVal(111, "four")); // failed
        assertTrue(hi.containsKeyAndVal(33, "kobe"));
        assertTrue(hi.containsKeyAndVal(76, "mj"));
        assertFalse(hi.containsKeyAndVal(9, "bronbron"));
        assertFalse(hi.containsKeyAndVal(7, "brobron"));
        assertTrue(hi.containsKeyAndVal(43, "curry")); // failed
        assertTrue(hi.containsKeyAndVal(9, "bron")); // failed
        assertTrue(hi.containsKeyAndVal(7, "bronbron"));
        assertFalse(hi.containsKeyAndVal(1, "sponges"));
        // some instances failed bc the return statement wasn't properly formed
    }

    @Test
    void containsKey() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        hi.add(3, "three");
        hi.add(111, "four");
        hi.add(33, "kobe");
        hi.add(76, "mj");
        hi.add(9, "bron");
        hi.add(7, "bronbron");
        hi.add(43, "curry");

        assertTrue(hi.containsKey(1));
        assertFalse(hi.containsKey(11));
        assertTrue(hi.containsKey(3));
        assertTrue(hi.containsKey(111));
        assertTrue(hi.containsKey(33));
        assertTrue(hi.containsKey(76));
        assertFalse(hi.containsKey(77));
        assertFalse(hi.containsKey(77999));
        assertTrue(hi.containsKey(9));
        assertTrue(hi.containsKey(7));
        assertTrue(hi.containsKey(43));

    }

    @Test
    void containsVal() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        hi.add(3, "three");
        hi.add(111, "four");
        hi.add(33, "kobe");
        hi.add(76, "mj");
        hi.add(9, "bron");
        hi.add(7, "bronbron");
        hi.add(43, "curry");

        assertTrue(hi.containsVal("mj"));
        assertFalse(hi.containsVal("spong"));
        assertTrue(hi.containsVal("three"));
        assertTrue(hi.containsVal("bron"));
        assertFalse(hi.containsVal("brom"));
        assertTrue(hi.containsVal("bronbron"));
        assertFalse(hi.containsVal("emjay"));
        assertFalse(hi.containsVal("highfive"));
        assertTrue(hi.containsVal("curry"));
        assertTrue(hi.containsVal("kobe"));
        assertTrue(hi.containsVal("sponge"));
        assertTrue(hi.containsVal("four"));
        assertEquals(8, hi.getSize());
    }

    @Test
    void remove() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        hi.add(3, "three");
        hi.add(111, "four");
        hi.remove(3);
        hi.add(33, "kobe");
        hi.add(76, "mj");
        hi.add(9, "bron");
        hi.remove(111);
        hi.add(7, "bronbron");
        hi.add(43, "curry");

        assertEquals(6, hi.getSize());
        assertTrue(hi.containsVal("mj"));
        assertFalse(hi.containsVal("three"));
    }

    @Test
    void removeKeyAndVal() {
        HashTable<Integer, String> hi = new HashTable<>();

        hi.add(1, "sponge");
        hi.add(3, "three");
        hi.add(111, "four");
        hi.remove(3, "four");
        hi.add(33, "kobe");
        hi.add(76, "mj");
        hi.add(9, "bron");
        hi.remove(111, "four");
        hi.add(7, "bronbron");
        hi.add(43, "curry");

        assertEquals(7, hi.getSize());
        assertTrue(hi.containsVal("three"));
        assertFalse(hi.containsVal("four"));
        assertFalse(hi.containsKeyAndVal(111, "four"));
        assertFalse(hi.containsKey(111));
    }


}