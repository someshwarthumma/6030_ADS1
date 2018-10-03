import java.util.Scanner;
class Merge {
    
    private  int x = 7;
    public void merge(Comparable[] array, Comparable[] aux,
         int lo,  int mid,  int hi) {
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
    
    public void sort( Comparable[] array,  Comparable[] aux,
         int lo,  int hi) {
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
    public void sort( Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    public void insertionSort( Comparable[] a,
         int low,  int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    
    public void exch( Comparable[] a,
         int i,  int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public boolean less( Comparable item1,  Comparable item2) {
        return item1.compareTo(item2) < 0;
    }
    
    public boolean isSorted( Comparable[] array) {
        return isSorted(array, 0, array.length - 1);
    }
    
    public boolean isSorted( Comparable[] array,
         int lo,  int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
    public String show( Comparable[] array) {
        String str = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[i] + "]";
        return str;
    }
}
public  class Solution {
    public static void main( String[] args) {
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