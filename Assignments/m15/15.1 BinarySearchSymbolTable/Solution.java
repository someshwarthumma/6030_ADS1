import java.util.Scanner;
import java.util.Arrays;
/**.
 * solution class
 */
final class Solution {
    private Solution() {
        //constructor
    }
    /**.
     * main method to handle input testcases
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**.
         * Scanner Object
         */
        Scanner scan = new Scanner(System.in);
        SymbolTable<String, Integer> st = new SymbolTable<String, Integer>();
        String[] input = scan.nextLine().split(" ");
        try {
            for (int i = 0; i < input.length; i++) {
                st.put(input[i], i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        while (scan.hasNext()) {
            try {
                String[] tokens = scan.nextLine().split(" ");
                switch (tokens[0]) {
                case "max":
                    System.out.println(st.Max());
                    break;
                case "get":
                    System.out.println(st.get(tokens[1]));
                    break;
                case "contains":
                    System.out.println(st.contains(tokens[1]));
                    break;
                case "floor":
                    System.out.println(st.floor(tokens[1]));
                    break;
                case "rank":
                    System.out.println(st.rank(tokens[1]));
                    break;
                case "deleteMin":
                    st.deleteMin();
                    break;
                case "keys":
                    st.keys();
                    break;
                default:
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
/**.
 * symbolTable
 *
 * @param      <Key>    Key of generic type
 * @param      <Value>  value of generic type
 */
class SymbolTable <Key extends Comparable<Key>, Value> {
    /**.
     * Key array to store the keys
     */
    private Key[] keyArr;
    /**.
     * value array to store the values
     */
    private Value[] valueArr;
    /**.
     * size varible
     */
    private int size;
    /**.
     * SymbolTable constructor
     */
    SymbolTable() {
        keyArr = (Key[]) new Comparable[5];
        valueArr = (Value[]) new Object[5];
        size = 0;
    }
    /**.
     * Resize method to resize array
     * Complexity is O(N)
     * Here it copies all elements
     */
    private void resize() {
        keyArr = Arrays.copyOf(keyArr, 2 * keyArr.length);
        valueArr = Arrays.copyOf(valueArr, 2 * valueArr.length);
    }
    /**.
     * method to put the elements into the symbol table
     * complexity is O(N)
     * because we iterate over all elements in worst case
     * @param      key        The key
     * @param      val        The value
     *
     * @throws     Exception  { when key is null }
     */
    public void put(final Key key, final Value val) throws Exception {
        if (key == null) {
            throw new Exception("Key cannot be null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);

        // key is already in table
        if (i < size && keyArr[i].compareTo(key) == 0) {
            valueArr[i] = val;
            return;
        }

        // insert new key-value pair
        if (size == keyArr.length) {
            resize();
        }

        for (int j = size; j > i; j--)  {
            keyArr[j] = keyArr[j - 1];
            valueArr[j] = valueArr[j - 1];
        }
        keyArr[i] = key;
        valueArr[i] = val;
        size++;
    }
    /**.
     * method to find the rank of a key in the table
     * complexity is O(N)
     * because iterates over all keys in worst case
     * @param      key        The key
     *
     * @return     { rank of the key as integer }
     *
     * @throws     Exception  { when key is null }
     */
    public int rank(final Key key) throws Exception {
        if (key == null) {
            throw new Exception("Key cannot be null");
        }
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keyArr[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else return mid;
        }
        return lo;
    }
    /**.
     * method to check weather table is empty or not
     * complexity is O(1)
     * since simple condition
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**.
     * Method to find the min of the table
     * complexity is O(1)
     * beacuse of the simple return statement
     *
     * @return     { Key which is min }
     *
     * @throws     Exception  { when table is empty }
     */
    public Key Min() throws Exception {
        if (isEmpty()) {
            throw new Exception("Table is empty ");
        }
        return keyArr[0];
    }
    /**.
     * method to find the maximum element
     * complexity is O(1)
     * beacuse of the simple return statement
     *
     * @return     { key which is maximum }
     *
     * @throws     Exception  { when table is empty }
     */
    public Key Max() throws Exception {
        if (isEmpty()) {
            throw new Exception("Table is empty ");
        }
        return keyArr[size - 1];
    }
    /**.
     * Method to get the value for the given key
     * complexity is O(Log(N))
     * since rank has complexity of O(Log(N))
     * @param      key        The key
     *
     * @return     { Value as for the given key }
     *
     * @throws     Exception  { when key is null }
     */
    public Value get(final Key key) throws Exception {
        if (key == null) {
            throw new Exception("argument to get() is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < size && keyArr[i].compareTo(key) == 0) {
            return valueArr[i];
        }
        return null;
    }
    /**.
     * method to delete the key provided
     * complexity is O(Log(N))
     * since rank has O(Log(N))
     *
     * @param      key        The key
     *
     * @throws     Exception  { when key is null }
     */
    public void delete(final Key key) throws Exception {
        if (key == null) {
            throw new Exception("argument to delete() is null");
        }
        if (isEmpty()) {
            return;
        }

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == size || keyArr[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < size - 1; j++)  {
            keyArr[j] = keyArr[j + 1];
            valueArr[j] = valueArr[j + 1];
        }
        size--;
        keyArr[size] = null;
        valueArr[size] = null;
        if (size > 0 && size == keyArr.length / 4) {
            resize();
        }
    }
    /**.
     * method to delete the min element
     * complexity is O(Log(N))
     * since we use delete method which has complexity of O(Log(N))
     *
     * @throws     Exception  { when tabe is empty }
     */
    public void deleteMin() throws Exception {
        delete(Min());
    }
    /**.
     * method to check weather the given key contains or not
     * complexity is O(Log(N))
     * because it uses get method
     * @param      key        The key
     *
     * @return     { Return the weather the element present or not as noolean }
     *
     *  @throws     Exception  { when key is null }
     */
    public boolean contains(final Key key) throws Exception {
        return get(key) != null;
    }
    /**.
     * method to find the floor value for the given key
     * complexity is O(LOg(N))
     * because rank here has O(Log(N))
     * @param      key        The key
     *
     * @return     { a Key for the given key }
     *
     * @throws     Exception  { when key is null }
     */
    public Key floor(final Key key) throws Exception {
        if (key == null) {
            throw new Exception("argument to floor() is null");
        }
        int i = rank(key);
        if (i < size && key.compareTo(keyArr[i]) == 0) {
            return keyArr[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keyArr[i - 1];
        }
    }
    /**.
     * method to print the table.
     * complexity is O(N), we have to iterate all over the elements
     */
    public void keys() {
        for (int i = 0; i < size; i++) {
            Key key = keyArr[i];
            Value val = valueArr[i];
            if (val != null) {
                System.out.println(key + " " + val);
            }
        }
    }
}