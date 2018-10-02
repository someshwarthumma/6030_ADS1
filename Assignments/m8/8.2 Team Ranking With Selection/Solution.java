import java.util.Scanner;
/**.
 * Solution class
 */
class Solution {
    /**.
     * private constructor.
     */
    private Solution() {
        //This is Constructor
    }
    /**.
     * Main method to handle the input testacases
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Leaderboard leaderboardObj = new Leaderboard();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            leaderboardObj.add(new Teams(tokens[0], Integer.
                parseInt(tokens[1]), Integer.
                parseInt(tokens[2]), Integer.
                parseInt(tokens[3])));
        }
        leaderboardObj.print();
    }
}