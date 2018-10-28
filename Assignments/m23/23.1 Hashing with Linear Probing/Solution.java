import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**.
     * main method.
     * Complexity O(N) as since the complexity of put and get is O(N)
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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

/**.
 * Class for implementing the Linear Probing hash table
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashST<Key, Value> {
    /**.
     * Variable for init capacity
     */
    private static final int INIT_CAPACITY = 4;
    /**.
     * variable for size as n
     */
    private int n;
    /**.
     * variable for capacity
     */
    private int m;
    /**.
     * array for Keys array
     */
    private Key[] keys;
    /**.
     * Values array to store he values
     */
    private Value[] vals;    // the values
    /**.
     * constructor
     */
    LinearProbingHashST() {
        this(INIT_CAPACITY);
    }
    /**.
     * constructor with capacity as parameter
     *
     * @param      capacity  The capacity
     */
    LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**.
     * getter method to return the size.
     * Complexity O(1)
     *
     * @return     { int }
     */
    public int size() {
        return n;
    }
    /**.
     * method to check weather the array is empty or not
     * Complexity O(1)
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**.
     * method to check weather the element is present or not
     * Complexity O(N) as it uses get method
     *
     * @param      key   The key
     *
     * @return     { Boolean }
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argumen contains() is null");
        }
        return get(key) != null;
    }
    /**.
     * method to return the hash value
     * Complexity O(1)
     *
     * @param      key   The key
     *
     * @return     { int }
     */
    private int hash(final Key key) {
        // return (key.hashCode() & 0x7fffffff) % m;
        String s = (String) key;
        return ((int) s.charAt(0) * 2 + 2 + 2 + 2 + 2 + 1) % m;
    }
    /**.
     * method to resize the array
     * Complexity O(N) as it uses put method
     * which has the O(N) complexity
     *
     * @param      capacity  The capacity
     */
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
    /**.
     * method to put the value
     * Complexity O(N) in the worst case which is guaranted.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException("first ato put() is null");
        }

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m / 2) {
            resize(2 * m);
        }

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
    /**.
     * method to get the value of the given key
     * Complexity O(N) in the worst case which is guaranted.
     *
     * @param      key   The key of type key
     *
     * @return     { value type }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    /**.
     * delete metthod to delete the given key
     * Complexity O(N) in the worst case which is guaranted.
     *
     * @param      key   The key of type Key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }

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
        if (n > 0 && n <= m / 2 + 2 + 2 + 2) {
            resize(m / 2);
        }

        // assert check();
    }

    /**.
     * method to return the Keys
     * Complexity O(N) since it iterates for all the elements
     *
     * @return     { Keys }
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }


}