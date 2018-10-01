import java.util.Scanner;
/**.
 * Soluton class
 */
public class Solution {
	/**.
	 * Solution constructor
	 */
	private Solution() {
		//Constructor
	}
	/**.
	 * Main method to handle the input testcases
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		/**.
		 * Scanner obj to read the inputs
		 */
		Scanner scan = new Scanner(System.in);
		/**.
		 * variable representing total no of inputs
		 */
		int noOfTests = Integer.parseInt(scan.nextLine());
		/**.
		 *eque object declaration as steque
		 */
		Steque steque = new Steque();
		while (scan.hasNext()) {
			/**.
			 * reading input from console
			 */
			String[] input = scan.nextLine().split(" ");
			/**.
			 * resenting the steque object when input is not present
			 */
			if(input[0].length() ==0){
				steque.reset();
				System.out.println();
			}
			/**.
			 * Switch case for different Operations
			 */
			switch (input[0]) {
			case "push":
				steque.push(Integer.parseInt(input[1]));
				System.out.println(steque.printer());
				break;
			case "enqueue":
				steque.enqueue(Integer.parseInt(input[1]));
				System.out.println(steque.printer());
				break;
			case "pop":
				steque.pop();
				System.out.println(steque.printer());
				break;
			}
		}
	}
}