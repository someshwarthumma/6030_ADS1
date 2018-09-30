import java.util.Scanner;
/**.
 * Solution class
 */
public final class Solution {
    /**.
     * Sollution constructor
     */
    private Solution() {
        //Solution constructor
    }
    /**.
     * main method to handle the testcases
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**.
         * scanner object to read the data
         */
        Scanner scan = new Scanner(System.in);
        /**.
         * Queue object to store the given data
         */
        Queue queueObj = new Queue();
        /**.
         * Variable to define the no of inputs
         */
        int noOfInputs = Integer.parseInt(scan.nextLine());
        for (int index1 = 0; index1 < noOfInputs; index1++) {
            String[] tokens = scan.nextLine().split(" ");
            int number = Integer.parseInt(tokens[0]);
            int position = Integer.parseInt(tokens[1]);
            /**.
             * adding given elements into the Queue.
             */
            for (int index = 0; index < number; index++) {
                queueObj.enQueue(index);
            }
            /**.
             * Checking of mth position person and poping the same
             */
            while (!queueObj.isEmpty() && number != 1) {
                for (int i = 1 ; i < position ; i++) {
                    queueObj.enQueue(queueObj.deQueue());
                }
                System.out.print(queueObj.deQueue() + " ");
                number--;
            }
            System.out.print(queueObj.deQueue());
            System.out.println();
            //System.out.println("while completed");
        }
    }
}