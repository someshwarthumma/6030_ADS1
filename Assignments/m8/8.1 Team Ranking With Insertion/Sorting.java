//import java.util.Arrays;

/**.
 * Sorting class for implemting the sort
 */
class Sorting{
	/**.
	 * Method to sort the fiven elements
	 *
	 * @param      teams  Team
	 * @param      size   int
	 *
	 * @return     { Teams[] }
	 */
	public Teams[] sort(Teams[] teams, final int size){
		/*int min =0;
		for(int i=0;i<size;i++){
			min = i;
			for(int j=i+1;j<size;j++){
				if(teams[min].compareTo(teams[j])){
					min = j;
				}
			}
			teams = exchange(teams, i, min);
		}
		return teams;*/

		for(int i=1;i<size;i++){
			Teams key = teams[i];
			int j =i-1;
			while(j>=0 && key.compareTo(teams[j])){
				teams[j+1] = teams[j];
				j= j-1;
			}
			teams[j+1] = key;
		}
		return teams;
	}
	/**.
	 * Exchange method to swap the provided elements in a given array
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