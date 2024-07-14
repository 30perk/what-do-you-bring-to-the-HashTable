public class HashTable<Key, Value> {

    private static final int CAPACITY = 12;
    private Node<Key, Value>[] buckets;
    private int size = 0;

    // HT constructor
    public HashTable() {
        buckets = new Node[CAPACITY];
    }

    // Node class to store items
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // key hashing to get bucket idx
    private int hashKey(Key key) {
        int hash = key.hashCode();
        return Math.abs(hash) % buckets.length;
    }

    public int getSize() {
        return size;
    }

    public void add(Key key, Value val) {
        int index = hashKey(key);

        if (buckets[index] == null) {
            buckets[index] = new Node<>(key, val);
        } else {
            Node<Key, Value> current = buckets[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = val; // Update existing key with new val
                    return;
                }
                if (current.next == null) {
                    current.next = new Node<>(key, val);
                    break;
                }
                current = current.next;
            }
        }
        size++;
    }

    public void remove(Key key) {
        int index = hashKey(key);
        Node<Key, Value> current = buckets[index];
        Node<Key, Value> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void remove(Key key, Value value) {
        int index = hashKey(key);
        Node<Key, Value> current = buckets[index];
        Node<Key, Value> prev = null;

        while (current != null) {
            if (current.key.equals(key) && current.value.equals(value)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public Value get(Key key) {
        int index = hashKey(key);
        Node<Key, Value> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public boolean containsKeyAndVal(Key key, Value val) {
        int index = hashKey(key);
        Node<Key, Value> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key) && current.value.equals(val)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean containsKey(Key key) {
        int index = hashKey(key);
        Node<Key, Value> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean containsVal(Value val) {
        for (int i = 0; i < buckets.length; i++) {
            Node<Key, Value> current = buckets[i];

            while (current != null) {
                if (current.value.equals(val)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashTable<Integer, String> hi = new HashTable<>();
        hi.add(1, "sponge");
        hi.add(3, "three");
        hi.add(111, "four");
        hi.add(33, "kobe");
        hi.add(76, "mj");
        hi.add(9, "bron");
        hi.add(7, "bronbron");
        hi.add(43, "curry");

        System.out.println(hi.containsKeyAndVal(3, "three"));
        System.out.println(hi.containsKeyAndVal(111, "four"));
    }
}
