/**.
 * Class for Teams object
 */
class Teams {
    /**.
     * team name variable
     */
    private String teamName;
    /**.
     * Variable for wins
     */
    private int  wins;
    /**.
     * variable for no of loses
     */
    private int lose;
    /**.
     * Variable for no of draw
     */
    private int draw;
    /**.
     * Teams constructor
     *
     * @param      s     { String for team Name }
     * @param      w     {Wins of type int }
     * @param      l     { lose of type int }
     * @param      d     { draw of type int }
     */
    Teams(final String s, final int w, final int l, final int d) {
        this.teamName = s;
        this.wins = w;
        this.lose = l;
        this.draw = d;
    }
    /**.
     * Getter Method for team name
     * Complexity is O(1) since it return the name
     *
     * @return     String
     */
    public String getTeamName() {
        return this.teamName;
    }
    /**.
     * Getter method for wins
     * Complexity is O(1)
     * @return     int
     */
    public int getWins() {
        return this.wins;
    }
    /**.
     * Getter method for loses
     * Complexity is O(1)
     * @return     int
     */
    public int  getLose() {
        return this.lose;
    }
    /**.
     * Getter method for draw
     * Complexity is O(1)
     * @return    int
     */
    public int getDraw() {
        return this.draw;
    }
    /**.
     * Method to compare the given elements
     * Complexity is O(1) since it compare the given elements
     * @param      that  The that
     *
     * @return     { Boolean }
     */
    public boolean compareTo(final Teams that) {
        if (this.wins < that.wins) {
            return true;
        } else if (this.wins > that.wins) {
            return false;
        } else {
            if (this.lose < that.lose) {
                return false;
            } else if (this.lose > that.lose) {
                return true;
            } else {
                if (this.draw >= that.draw) {
                    return false;
                }
                return true;
            }
        }
    }
}