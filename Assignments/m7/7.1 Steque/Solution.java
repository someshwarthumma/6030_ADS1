import java.util.Scanner;
/**.
 * Soluton class
 */
public final class Solution {
    /**.
     * Solution constructor
     */
    private Solution() {
        //Constructor
    }
    /**.
     * Main method to handle the input testcases
     * complexity: O(N)
     * because of the usage of while loop
     *
     * @param      args  String
     */
    public static void main(final String[] args) {
        /**.
         * Scanner obj to read the inputs
         */
        Scanner scan = new Scanner(System.in);
        /**.
         * variable representing total no of inputs
         */
        int noOfTests = Integer.parseInt(scan.nextLine());
        /**.
         *eque object declaration as steque
         */
        Steque steque = new Steque();
        /**
         * While loop to handle the inputs
         * complexity: O(N)
         */
        while (scan.hasNext()) {
            /**.
             * reading input from console
             */
            String[] input = scan.nextLine().split(" ");
            /**.
             * resenting the steque object when input is not present
             */
            if (input[0].length() == 0) {
                steque.reset();
                System.out.println();
            }
            /**.
             * Switch case for different Operations
             */
            switch (input[0]) {
            case "push":
                steque.push(Integer.parseInt(input[1]));
                System.out.println(steque.printer());
                break;
            case "enqueue":
                steque.enqueue(Integer.parseInt(input[1]));
                System.out.println(steque.printer());
                break;
            case "pop":
                steque.pop();
                System.out.println(steque.printer());
                break;
            default:
            }
        }
    }
}
