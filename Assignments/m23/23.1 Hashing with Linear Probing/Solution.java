import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int noOfTests = s.nextInt();
        LinearProbingHashST<String, Integer> l = new LinearProbingHashST<>();
        for (int i = 0; i <= noOfTests; i++) {
            String[] temp = s.nextLine().split(" ");
            switch (temp[0]) {
            case "put": l.put(temp[1], Integer.parseInt(temp[2]));
                break;
            case "display":
                if (l.size() == 0) {
                    System.out.println("{}");
                } else {
                    String str = "";
                    for (String s1 : l.keys()) {
                        str += s1 + ":" + l.get(s1) + ", ";
                    }
                    System.out.println("{" + str.substring(0, str.length() - 2) + "}");
                }

                break;
            case "delete":
                l.delete(temp[1]);
                break;
            case "get":
                System.out.println(l.get(temp[1]));
                break;
            default:
                break;
            }
        }
    }
}


class LinearProbingHashST<Key, Value> {

    private static final int INIT_CAPACITY = 4;

    private int n;

    private int m;

    private Key[] keys;

    private Value[] vals;    // the values



    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }


    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }


    public int size() {
        return n;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argumen contains() is null");
        }
        return get(key) != null;
    }

    // hash function for keys - returns value between 0 and M-1
    private int hash(final Key key) {
        // return (key.hashCode() & 0x7fffffff) % m;
        String s = (String) key;
        return ((int)s.charAt(0) * 11) % m;
    }

    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp =
            new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }


    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException("first ato put() is null");
        }

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m / 2) resize(2 * m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)

            if (keys[i].equals(key)) {
                return vals[i];
            }

        return null;
    }


    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / 8) resize(m / 2);

        // assert check();
    }


    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)

            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        return queue;
    }


}