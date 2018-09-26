import java.util.Scanner;
import java.util.Arrays;
/**.
 * Threesum class for gfinding he sum of the three numbers equals to zero
 */
class ThreeSum {
    /**.
     * Array to store the given elements
     */
    private int[] givenArray;
    /**.
     * size variable to index the array elements
     */
    private int size = 0;
    /**.
     * Counter variable to count the threesum count
     */
    private int counter = 0;
    /**.
     * ThreeSum constructor to find the threesum of a number
     *
     * @param      size  The size
     */
    ThreeSum(final int sizeOfArray) {
        givenArray = new int[sizeOfArray];
    }
    /**.
     * add method to add the element to into the given array
     *
     * @param      element  The element
     */
    public void add(final int element) {
        givenArray[size++] = element;
    }
    /**.
     * method to find the threesum count
     */
    public void getThreesum() {
        Arrays.sort(givenArray);
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                int k = Arrays.binarySearch(
                    givenArray, -(givenArray[i] + givenArray[j]));
                if (k > j) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
/**.
 * Solution class 
 */
final class Solution {
    /**.
     * Solution class constructor
     */
    private Solution() {
        //Solution constructor
    }
    /**.
     * main method to handle the input tescases
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = scan.nextInt();
        ThreeSum threeSumObj = new ThreeSum(inputs);
        for (int i = 0; i < inputs; i++) {
            threeSumObj.add(scan.nextInt());
        }
        threeSumObj.getThreesum();
    }
}


