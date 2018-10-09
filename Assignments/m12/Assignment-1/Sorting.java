import java.util.*;
  class Sorting{
	public static void sort(Students[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }


    private static  boolean less(Students v, Students w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Students[] a, int i, int j) {
        Students swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}