//import java.util.Arrays;

/**.
 * Sorting class for implemting the sort
 */
class Sorting{
	/**.
	 * Method to sort the fiven elements
	 * Complexity is O(N^2) in the worst case if the array is alredy sorted
	 *
	 * @param      teams  Team
	 * @param      size   int
	 *
	 * @return     { Teams[] }
	 */
	public Teams[] sort(Teams[] teams, final int size){
		int min =0;
		for(int i=0;i<size;i++){
			min = i;
			for(int j=i+1;j<size;j++){
				if(teams[min].compareTo(teams[j])){
					min = j;
				}
			}
			teams = exchange(teams, i, min);
		}
		return teams;
	}
	/**.
	 * Exchange method to swap the provided elements in a given array
	 * complexity is O(1) since it performs exchange
	 *
	 * @param      teams  Teams[]
	 * @param      i      { int }
	 * @param      j      { int j }
	 *
	 * @return     { Teams[] }
	 */
	public Teams[] exchange(final Teams[] teams, final int i, final int j){
		Teams temp = teams[i];
		teams[i] = teams[j];
		teams[j] = temp;
		return teams;
	}
}