import java.util.Scanner;
import java.util.Arrays;
/**.
 * Stack class to implement as stack
 */
class Stack {
	/**.
	 * data array
	 */
	private char[] data;
	/**.
	 * Size variable
	 */
	private int size;
	/**.
	 * Stack class constructor
	 */
	Stack() {
		data = new char[20];
		size = 0;
	}
	/**.
	 * Push method to put the elements into the stack
	 *
	 * @param      s     { parameter_description }
	 */
	public void push(final char s) {
		if (size == data.length) {
			resize();
		}
		if (s == '(') {
			data[size++] = ')';
		} else if (s == '[') {
			data[size++] = ']';
		} else {
			data[size++] = '}';
		}
	}
	/**.
	 * Pop method to get the top of the stack
	 *
	 * @return     { description_of_the_return_value }
	 */
	public char pop() {
		if (size == 0) {
			return '0';
		}
		size--;
		return data[size];
	}
	/**.
	 * method to find wether the stack empty or not
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**.
	 * Resize array to resize the array 
	 */
	private void resize() {
		data = Arrays.copyOf(data , 2 * data.length);
	}
	/**.
	 * 
	 * to set size of the stack to zero.
	 */
	public void setSize() {
		this.size = 0;
	}
}

/**.
 * solution class
 */
public class Solution {
	/**.
	 * Solution constructor
	 */
	private Solution() {
	 	//Constructor
	 }
	/**.
	 * Main method to handle the input
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		/**.
		 * stack object to perform push and pop
		 */
		Stack stackObj = new Stack();
		/**.
		 * Scanner object to read the input
		 */
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			char[] s = scan.nextLine().toCharArray();
			if (s.length % 2 == 1) {
				flag = false;
				System.out.println("NO");
				break;
			}
			for (char each : s) {
				if (s[s.length - 1] == '[' || s[s.length - 1] == '{' || s[s.length - 1] == '(' ) {
					System.out.println("NO");
					flag = false;
					break;
				}
				if (each == '(' || each == '{' || each == '[') {
					stackObj.push(each);
				} else {
					if (each != stackObj.pop()) {
						stackObj.setSize();
						System.out.println("NO");
						flag = false;
						break;
					}
				}


			}
			if (flag) {
				System.out.println("YES");
			}
		}
	}
}