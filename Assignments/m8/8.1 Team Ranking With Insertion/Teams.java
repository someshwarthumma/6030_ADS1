/**.
 * Class for Teams object
 */
class Teams{
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
	 * complexity(1)
	 * @param      s     { String for team Name }
	 * @param      w     {Wins of type int }
	 * @param      l     { lose of type int }
	 * @param      d     { draw of type int }
	 */
	Teams(String s, int w, int l, int d){
		this.teamName = s;
		this.wins = w;
		this.lose = l;
		this.draw = d;
	}
	/**.
	 * Getter Method for team name
	 * complexity: O(1)
	 * @return     String
	 */
	public String getTeamName(){
		return this.teamName;
	}
	/**.
	 * Getter method for wins
	 * complexity O(1)
	 * @return     int
	 */
	public int getWins(){
		return this.wins;
	}
	/**.
	 * Getter method for loses
	 * complexity O(1)
	 * @return     int
	 */
	public int  getLose(){
		return this.lose;
	}
	/**.
	 * Getter method for draw
	 * complexity O(1)
	 * @return    int
	 */
	public int getDraw(){
		return this.draw;
	}
	/**.
	 * Method to compare the given elements
	 * complexity O(1)
	 * @param      that  The that
	 *
	 * @return     { Boolean }
	 */
	public boolean compareTo(Teams that){
		if(this.wins < that.wins){
			return true;
		} else if (this.wins > that.wins){
			return false;
		} else {
			if(this.lose < that.lose){
				return false;
			} else if( this.lose > that.lose){
				return true;
			} else {
				if(this.draw >= that.draw){
					return false;
				} else {
					return true;
				}
			}
		}
	}
}