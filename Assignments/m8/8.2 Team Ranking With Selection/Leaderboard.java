import java.util.Arrays;

/**.
 * Leaderboad class for implementaion of lead team in given teams
 */
class Leaderboard {
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
	Leaderboard() {
		teamsObj = new Teams[10];
		size = 0;
		sortObj = new Sorting();
	}
	/**.
	 * Add method to add the team objects into the array
	 * complexity is O(1) since simply add the element into the array
	 * @param      item   Team
	 */
	public void add(final Teams item) {
		if (size == teamsObj.length) {
			resize();
		}
		teamsObj[size++] = item;
	}
	/**.
	 * method to resize the array teamObj.
	 * complexity is O(N) in worst case
	 */
	private void resize() {
		teamsObj = Arrays.copyOf(teamsObj, 2 * teamsObj.length);
	}
	/**.
	 * Getter  method for size
	 * Complexity is O(1)
	 *
	 * @return     The size.
	 */
	public int getSize() {
		return this.size;
	}
	/**.
	 * Print method to print the output in the required fashion.
	 * Complexity is O(N) because we need to print the all the elements
	 */
	public void print() {
		teamsObj = sortObj.sort(teamsObj , size);
		for (int i = 0; i < size - 1; i++) {
			System.out.print(teamsObj[i].getTeamName() + ",");
		}
		System.out.println(teamsObj[size - 1].getTeamName());
	}
}