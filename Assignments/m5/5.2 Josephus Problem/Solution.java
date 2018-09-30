import java.util.Scanner;
public class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue queueObj = new Queue();
		int noOfInputs = Integer.parseInt(scan.nextLine());
		for (int j = 0; j < noOfInputs; j++) {
			String[] tokens = scan.nextLine().split(" ");
			int number = Integer.parseInt(tokens[0]);
			int position = Integer.parseInt(tokens[1]);
			for (int i = 0; i < number; i++) {
				queueObj.enQueue(i);
			}
			while (!queueObj.isEmpty() && number != 1) {
				/*System.out.println("Size: "+queueObj.getSize());
				System.out.println("while entered:");*/
					for (int i = 1 ; i < position ; i++) {
						queueObj.enQueue(queueObj.deQueue());
					}
					System.out.print(queueObj.deQueue()+" ");
					number--;
			}
			System.out.print(queueObj.deQueue());
			System.out.println();
			//System.out.println("while completed");
		}
	}
}