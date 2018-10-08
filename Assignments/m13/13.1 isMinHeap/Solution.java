import java.util.Scanner;
/**.
 * Solution class
 */
final class Solution {
    /**.
     * This is private constructor
     */
    private Solution() {
        //constructor
    }
    /**.
     * main method to handle input testcases
     * complexity is O(N)
     * since we use two loops to read the input and check simultaneosly
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**.
         * Scanner object reading
         */
        Scanner scan = new Scanner(System.in);
        String dataType = scan.nextLine();
        int noOfTestCases = Integer.parseInt(scan.nextLine());
        MinPQ checkObj = new MinPQ();
        /**
         * input reading depending on the type of input
         * complexity: O(N)
         * string format is converted to respective dataType while reading
         */
        switch (dataType) {
        case "String":
            while (scan.hasNext()) {
                String[] array = scan.nextLine().split(",");
                String[] strArr = new String[array.length + 1];
                int j = 0;
                for (int i = 1; i <= array.length; i++) {
                    strArr[i] = array[j];
                    j++;
                }
                System.out.println(checkObj.check(strArr));
            }
            break;
        case "Integer":
            while (scan.hasNext()) {
                String[] array = scan.nextLine().split(",");
                Integer[] intArr = new Integer[array.length + 1];
                int j = 0;
                for (int i = 1; i <= array.length; i++) {
                    intArr[i] = Integer.parseInt(array[j]);
                    j++;
                }
                System.out.println(checkObj.check(intArr));
            }
            break;
        case "Double":
            while (scan.hasNext()) {
                String[] array = scan.nextLine().split(",");
                Double[] doubleArr = new Double[array.length + 1];
                int j = 0;
                for (int i = 1; i <= array.length; i++) {
                    doubleArr[i] = Double.parseDouble(array[j]);
                    j++;
                }
                System.out.println(checkObj.check(doubleArr));
            }
            break;
        case "Float":
            for (int k = 0; k < noOfTestCases; k++) {
                String array1 = scan.nextLine();
                if (array1.length() == 0) {
                    System.out.println("false");
                    break;
                }
                String[] array = array1.split(",");
                Float[] floatArr = new Float[array.length + 1];
                int j = 0;
                for (int i = 1; i <= array.length; i++) {
                    floatArr[i] = Float.parseFloat(array[j]);
                    j++;
                }
                System.out.println(checkObj.check(floatArr));
            }
            break;
        default:
        }
    }
}

/**.
 * MinPQ class.
 *
 * @param      <E>   { Type generic argument }
 */
class MinPQ<E extends Comparable<E>> {
    /**
     * MinPQ constructor
     */
    //private MinPQ(){
        //constructor
    //}
    /**.
     * Check method to check weather it is minPQ or not
     * Complexity is O(N)
     * since we use For loop to check
     *
     * @param      arr  array of generic type
     *
     * @return     { Boolean flag }
     */
    public boolean check(final E[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 1; i--) {
            if (arr[i].compareTo(arr[i / 2]) < 0) {
                return false;
            }
        }
        return true;
    }
}
