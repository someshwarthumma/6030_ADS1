import java.util.Scanner;
public class Solution {
	private Solution() {
		//Constructor
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfTests = Integer.parseInt(scan.nextLine());
		Steque steque = new Steque();
		
		while (scan.hasNext()) {
			String[] input = scan.nextLine().split(" ");
			if(input[0].length() <2){
				System.out.println("Its reset: ");
				steque.reset();
				System.out.println();
			}
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