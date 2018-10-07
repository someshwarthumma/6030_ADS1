import java.util.Scanner;
/**.
 * Solution class
 */
class Solution {
    /**.
     * Solution constructor
     */
    private Solution(){
        //constructor
    }
    /**.
     * Main method for hadling the iput testcases
     * Complexity : O(N)
     * since we need to read the output
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        while (s.hasNext()) {
            int num = Integer.parseInt(s.nextLine());
            QuickSort quickObj = new QuickSort(num);
            String[] tokens = s.nextLine().split(" ");
            if (tokens[0].length() == 0) {
                System.out.println("[]");
            } else {
                quickObj.sort(tokens);
                System.out.println(quickObj.toString(tokens));
            }
        }
    }
}
/**.
 * QuickSort class
 */
class QuickSort {
    /**.
     * CutOff variable to invoke insertion sort
     */
    private int cutOff;
    /**.
     * Insertion sort obj creation
     */
    private Insertion insertObj;
    /**.
     * Quick sort constructor
     * Complexity is O(N) since assignment of the given value
     * @param      num   The number of int type
     */
    QuickSort(final int num) {
        cutOff = num;
        insertObj = new Insertion();
    }
    /**.
     * Sort method to perform quick sort
     * Complexity is O(1) as it calling the sort method
     * @param      array  The array of Comprable type
     */
    public void sort(final Comparable[] array) {
        sort(array, 0, array.length - 1);
    }
    /**.
     * Sort method to perform quick sort recursively
     * Complexity is ( 1)
     * @param      array  The array of type Comparable
     * @param      lo     The lower Of type integer
     * @param      hi     The higher Of type integer
     */
    public void sort(final Comparable[] array, final int lo, final int hi) {
        int n = hi - lo + 1;
        if (n <= cutOff) {
            insertObj.sort(array, lo, hi);
            System.out.println("insertionSort called");
            return;
        }
        int j = partition(array, lo, hi);
        sort(array, lo, j - 1);
        sort(array, j + 1, hi);
    }
    /**.
     * Partitiion method to find the pivot  element
     * Complexity is O(N^2) if it is sorted
     * @param      array  The array of Comparable
     * @param      low    The low of type integer
     * @param      high   The high of type integer
     *
     * @return     { Integer }
     */
    public int partition(final Comparable[] array,
        final int low, final int high) {
        int i = low;
        int j = high + 1;
        Comparable v = array[low];
        while (true) {
            while (less(array[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            while (less(v, array[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(array, i, j);
        }
        exchange(array, low, j);
        System.out.println((toString(array)));
        return j;

    }
    /**.
     * method to compare the given two elements.
     * complexity is O(1)
     * @param      one   One of Comprable type
     * @param      two   Two of Comprable type
     *
     * @return     { boolean }
     */
    public static boolean less(final Comparable one,
        final Comparable two) {
        return one.compareTo(two) < 0;
    }
    /**.
     * exchange method to swap the elements in the given positions
     * Complexity is O(1)
     * @param      array  array of comparable type
     * @param      i      { integer }
     * @param      j      { integer }
     */
    public static void exchange(final Comparable[] array,
        final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**.
     * method to print the output in desired format
     * Complexity is O(N)
     * @param      array  array of Comparable type
     *
     * @return     String representation of the object.
     */
    public static String toString(final Comparable[] array) {
        String str = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        return str + array[i] + "]";
    }
}

/**.
 * Insertion class to Perform insertion sort
 */
class Insertion {
    /**.
     * Sort method for insertion sort
     * complexity is O(N^2)
     * @param      a     { array of type Comprable  }
     * @param      lo    The lower of tyoe int
     * @param      hi    The higher of type int
     */
    public void sort(final Comparable[] a, final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && lesser(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
    /**.
     * Method to exhange the elements
     * coplexity is O(1)
     * @param      a     { Comprable }
     * @param      i     { integer }
     * @param      j     { integer }
     */
    public void exchange(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /**.
     * Method to compare the given elements
     * complexity is O(1)
     * @param      one   One of Type Comparable
     * @param      two   Two of Type Comparable
     *
     * @return     { Boolean }
     */
    public boolean lesser(final Comparable one, final Comparable two) {
        return one.compareTo(two) < 0;
    }
}
