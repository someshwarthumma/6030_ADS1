import java.util.Scanner;
import java.util.Arrays;
class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SymbolTable<String, Integer> st = new SymbolTable<String, Integer>();
        String[] input = scan.nextLine().split(" ");
        try {
            for (int i = 0; i < input.length; i++) {
                st.put(input[i], i);
            }
        } catch(Exception e){
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

class SymbolTable <Key extends Comparable<Key>, Value> {
    private Key[] keyArr;
    private Value[] valueArr;
    private int size;
    SymbolTable() {
        keyArr = (Key[]) new Comparable[5];
        valueArr = (Value[]) new Object[5];
        size = 0;
    }

    private void resize() {
        keyArr = Arrays.copyOf(keyArr, 2 * keyArr.length);
        valueArr = Arrays.copyOf(valueArr, 2 * valueArr.length);
    }

    public void put(Key key, Value val) throws Exception {
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
        if (size == keyArr.length) resize();

        for (int j = size; j > i; j--)  {
            keyArr[j] = keyArr[j - 1];
            valueArr[j] = valueArr[j - 1];
        }
        keyArr[i] = key;
        valueArr[i] = val;
        size++;
    }

    public int rank(Key key) throws Exception {
        if (key == null) {
            throw new Exception("Key cannot be null");
        }
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keyArr[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public Key Min() throws Exception {
        if (isEmpty()) {
            throw new Exception("Table is empty ");
        }
        return keyArr[0];
    }

    public Key Max() throws Exception {
        if (isEmpty()) {
            throw new Exception("Table is empty ");
        }
        return keyArr[size - 1];
    }

    public Value get(Key key) throws Exception {
        if (key == null) throw new Exception("argument to get() is null");
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < size && keyArr[i].compareTo(key) == 0) return valueArr[i];
        return null;
    }

    public void delete(Key key) throws Exception {
        if (key == null) throw new Exception("argument to delete() is null");
        if (isEmpty()) return;

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
        keyArr[size] = null;  // to avoid loitering
        valueArr[size] = null;

        // resize if 1/4 full
        if (size > 0 && size == keyArr.length / 4) resize();
    }

    public void deleteMin() throws Exception{
        delete(Min());
    }

    public boolean contains(Key key) throws Exception{
        return get(key) != null;
    }

    public Key floor(Key key) throws Exception {
        if (key == null) throw new Exception("argument to floor() is null");
        int i = rank(key);
        if (i < size && key.compareTo(keyArr[i]) == 0) return keyArr[i];
        if (i == 0) return null;
        else return keyArr[i - 1];
    }

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