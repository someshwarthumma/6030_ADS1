import java.util.Scanner;
public class Solution {
	private Solution() {
		//Constructor
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfTests = Integer.parseInt(scan.nextLine());
		Steque steque = new Steque();
		for (int i = 0; i < noOfTests; i++) {
			while (scan.hasNext()) {
				String[] input = scan.nextLine().split(" ");
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
			steque.reset();
		}
	}
}