import java.util.Scanner;
/**.
 * Solution class
 */
final class Solution {
    /**.
     * private constructor.
     */
    private Solution() {
        //This is Constructor
    }
    /**.
     * Main method to handle the input testacases
     * Complexity O(N) because we read the all the inputs
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Leaderboard leaderboardObj = new Leaderboard();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            final int three = 3;
            leaderboardObj.add(new Teams(tokens[0], Integer.
                parseInt(tokens[1]), Integer.
                parseInt(tokens[2]), Integer.
                parseInt(tokens[three])));
        }
        leaderboardObj.print();
    }
}

