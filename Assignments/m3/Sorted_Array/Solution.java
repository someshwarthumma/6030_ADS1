import java.util.Scanner;
import java.util.Arrays;
/**.
 * Solution class
 */
public class Solution {
    /**.
     * Constructor for solution class
     */
    Solution(){
        //constructor for solution class
    }
    /**.
     * main method to handle the input test cases to find the sort
     *
     * @param      args  arguments
     */
    public static void main(String[] args) {
        /**.
         * Scanner objet to read the input;
         */
        Scanner scan = new Scanner(System.in);
        /**.
         * length of first array
         */
        int oneLen = Integer.parseInt(scan.nextLine());
        /**.
         * Length of the second array
         */
        int secLen = Integer.parseInt(scan.nextLine());
        /**.
         * reading of the given first array in String
         */
        String[] arrOne = scan.nextLine().split(",");
        /**.
         * Reading of the given second array in string
         */
        String[] arrSec = scan.nextLine().split(",");
        /**.
         * converting the first array of type String to int
         */
        int[] firstArray = new int[oneLen];
        for (int i = 0; i < oneLen; i++) {
            firstArray[i] = Integer.parseInt(arrOne[i]);
        }
        /**.
         * convertng the second array of type string to int
         */
        int[] secondArray = new int[secLen];
        for (int i = 0; i < secLen; i++) {
            secondArray[i] = Integer.parseInt(arrSec[i]);
        }
        /**.
         * sortedarray to store the elements in a sorted order
         */
        int[] sortedArray = new int[oneLen + secLen];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < oneLen && j < secLen) {
            if (firstArray[i] < secondArray[j]) {
                sortedArray[index] = firstArray[i];
                i++;
            } else {
                sortedArray[index] = secondArray[j];
                j++;
            }
            index++;
        }
        while (i < oneLen) {
            sortedArray[index++] = firstArray[i];
            i++;
        }
        while (j < secLen) {
            sortedArray[index++] = secondArray[j];
            j++;
        }
        print(sortedArray);
    }
    /**.
     * Print method to print the sorted Array in sorted fashion.
     *
     * @param      sortedArray sorted array
     */
    public static void print(int[] sortedArray) {
        /**.
         * temporary string variable to print the output
         */
        String temp = "";
        for (int i = 0; i < sortedArray.length - 1; i++) {
            temp += sortedArray[i] + ",";
        }
        temp += sortedArray[sortedArray.length - 1];
        System.out.println(temp);
    }
}