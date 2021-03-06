import java.util.Scanner;

/**.
 * Merge class
 */
class Merge {
    /**.
     * int variable
     */
    private final int x = 7;
    /**.
     * merge method to sort the elements in the array
     * Time complexity of this method is O(N).
     * @param      array  array
     * @param      aux    auxiliary array
     * @param      lo     lower of type int
     * @param      mid    middle of type int
     * @param      hi     higher of type int
     */
    public void merge(final Comparable[] array, final Comparable[] aux,
        final int lo, final int mid, final int hi) {
        assert isSorted(array, lo, mid);
        assert isSorted(array, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > hi) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        assert isSorted(aux, lo, hi);
    }
    /**.
     * sort method to implement the sort algorithm of Merge
     *Time complexity of this method is O(log(N)).
     * @param      array  array
     * @param      aux    auxiliary array
     * @param      lo     lower of type int
     * @param      hi     higher of type int
     */
    public void sort(final Comparable[] array, final Comparable[] aux,
        final int lo, final int hi) {
        if (hi <= lo + x) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, array, lo, mid);
        sort(aux, array, mid + 1, hi);
        if (!less(array[mid + 1], array[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, aux, lo, mid, hi);
    }
    /**.
     * Sort method with one argument
     *Time complexity of sorting is O(N).
     * @param      a     { array }
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**.
     * method to implement insertion sort
     *Time complexity of insertion sort is O(N^2).
     * @param      a     { array }
     * @param      low   low of type int
     * @param      high  high of type int
     */
    public void insertionSort(final Comparable[] a,
        final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**.
     * method to swap the elements in a given array
     * Time complexity of this method is O(N).
     * @param      a     { Comparable array }
     * @param      i     { i as  index }
     * @param      j     { j as  index }
     */
    public void exch(final Comparable[] a,
        final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**.
     * Method to check weather the given numbers are less or not
     * Time complextiy of this method is O(1).
     * @param      item1  item 1
     * @param      item2  item 2
     *
     * @return     { boolean }
     */
    public boolean less(final Comparable item1, final Comparable item2) {
        return item1.compareTo(item2) < 0;
    }
    /**.
     * method to check weather array is sorted or not
     * Time complexity of this method is O(1).
     * @param      array  array
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] array) {
        return isSorted(array, 0, array.length - 1);
    }
    /**.
     * method to check weather given array is sorted or not
     * Time complexity of this method is O(N).
     * @param      array  The array
     * @param      lo     The lower
     * @param      hi     The higher
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] array,
        final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**.
     * Show method to print the output
     * Time complexity of this method is O(N).
     * @param      array  The array
     *
     * @return     { String }
     */
    public String show(final Comparable[] array) {
        String str = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[i] + "]";
        return str;
    }
}
/**.
 * Solution class
 */
public final class Solution {
    /**.
     * solution concstructor
     */
    private Solution() {
        //solution constructor
    }
    /**.
     * Main method to handle the testcases
     * Complexity is O(N) since it reads inputs
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Merge mergeObj = new Merge();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            mergeObj.sort(tokens);
            System.out.println(mergeObj.show(tokens));
            System.out.println();
        }
    }
}
