import java.util.Scanner;
/**.
 * solution class 
 */
public class Solution{
	/**.
	 * This is constructor.
	 */
	private Solution(){
		//Solution constructor
	}
	/**.
	 * Main method to handle the tescases
	 *
	 * @param      args  arguments
	 */
	public static void main(final String[] args) {
		/**.
		 * Creating the Deque class object for deque operations.
		 */
		Deque<Integer> d = new Deque<Integer>();
		/**.
		 * Scanner object to read the inputs.
		 */
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			/**.
			 * reading inputs into the string array tokens
			 */
			String[] tokens = scan.nextLine().split(" ");
			switch(tokens[0]){
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
			}
		}
	}
}