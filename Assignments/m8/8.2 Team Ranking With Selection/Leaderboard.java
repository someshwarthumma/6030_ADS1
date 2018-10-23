import java.util.Arrays;

/**.
 * Leaderboad class for implementaion of lead team in given teams
 */
class Leaderboard{
	/**.
	 * array of type Team.
	 */
	private Teams[] teamsObj;
	/**.
	 * Size variable
	 */
	private int size;
	/**.
	 * Sorting object declaration
	 */
	Sorting sortObj;
	/**.
	 * Leaderboard constructor
	 */
	Leaderboard(){
		teamsObj = new Teams[10];
		size = 0;
		sortObj = new Sorting();
	}
	/**.
	 * Add method to add the team objects into the array
	 *
	 * @param      item   Team
	 */
	public void add(final Teams item){
		if(size == teamsObj.length){
			resize();
		}
		teamsObj[size++] = item;
	}
	/**.
	 * method to resize the array teamObj.
	 */
	private void resize(){
		teamsObj = Arrays.copyOf(teamsObj, 2*teamsObj.length);
	}
	/**.
	 * Getter  method for size
	 *
	 * @return     The size.
	 */
	public int getSize(){
		return this.size;
	}
	/**.
	 * Print method to print the output in the required fashion.
	 */
	public void print(){
		teamsObj = sortObj.sort(teamsObj , size);
		for(int i=size-1; i>0;i++){
			System.out.print(teamsObj[i].getTeamName()+",");
		}
		System.out.println(teamsObj[0].getTeamName());
	}
}