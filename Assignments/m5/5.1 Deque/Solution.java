import java.util.Scanner;
/**.
 * Solution class
 */
public final class Solution {
    /**.
     * Constructor
     */
    private Solution() {
        //Constructor
    }
    /**.
     * Main method to handle the test cases
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Deque<Integer> d = new Deque<Integer>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "pushLeft":
                d.pushLeft(Integer.parseInt(tokens[1]));
                break;
            case "pushRight":
                d.pushRight(Integer.parseInt(tokens[1]));
                break;
            case "size":
                System.out.println(d.size());
                break;
            case "isEmpty":
                System.out.println(d.isEmpty());
                break;
            case "popLeft":
                d.popLeft();
                break;
            case "popRight":
                d.popRight();
                break;
            default:
                //This is light
                break;
            }
        }
    }
}
