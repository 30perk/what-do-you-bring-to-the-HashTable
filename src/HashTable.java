import java.util.LinkedList;

public class HashTable<Key, Value> {

    private static final int CAPACITY = 12;
    private LinkedList< Item<Key, Value> >[] buckets;
    private int size = 0;

    // HT constructor
    public HashTable() {
        buckets = new LinkedList[CAPACITY];
        // turning each idx into a "bucket" with empty LL
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // item constructor
    private static class Item<K, V> {
        K key;
        V value;

        Item(K key, V value) {
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
        // get idx
        int index = hashKey(key);
        LinkedList< Item<Key, Value> > bucket = buckets[index];

        for (int i=0; i<bucket.size(); i++) {
            // get the item at idx i
            Item<Key, Value> item = bucket.get(i);
            if (item.key.equals(key)) {
                // Update existing key with new val
                item.value = val;
                return;
            }
        }
        // add new item if no key
        bucket.add(new Item<>(key, val));
        size++;
    }

    public Value get(Key key) {
        // val for if item is found
        Value found = null;
        // get idx
        int index = hashKey(key);
        LinkedList< Item<Key, Value> > bucket = buckets[index];

        for (int i=0; i<bucket.size(); i++) {
            // get the item at idx i
            Item<Key, Value> item = bucket.get(i);
            if (item.key.equals(key)) {
                // update found
                found = item.value;
                break;
            }
        }
        return found;
    }

    public boolean containsKeyAndVal(Key key, Value val) {
        // get idx
        int index = hashKey(key);
        LinkedList< Item<Key, Value> > bucket = buckets[index];

        for (int i=0; i<bucket.size(); i++) {
            // get the item at idx i
            Item<Key, Value> item = bucket.get(i);

            if ( item.key.equals(key) && item.value.equals(val) ) {
                return (item.key.equals(key) && item.value.equals(val));
            }
        }
        return false;
    }

    public boolean containsKey(Key key) {
        // get idx
        int index = hashKey(key);
        LinkedList< Item<Key, Value> > bucket = buckets[index];

        for (int i=0; i<bucket.size(); i++) {
            // get the item at idx i
            Item<Key, Value> item = bucket.get(i);

            if ( item.key.equals(key) ) {
                return true;
            }

        }
        return false;
    }

    public boolean containsVal(Value val) {
        // loop thru array
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Item<Key, Value>> bucket = buckets[i];
            //loop thru bucket
            for (int j = 0; j < bucket.size(); j++) {
                Item<Key, Value> item = bucket.get(j);
                if (item.value.equals(val)) {
                    return true;
                }
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
//        System.out.println(hi.get(1));
//        System.out.println(hi.get(2));
//        System.out.println(hi.size);
//        System.out.println(hi.containsKeyAndVal(1,"spong"));
//        System.out.println(hi.containsKey(1));
//        System.out.println(hi.containsVal("sponge"));










    }

}
