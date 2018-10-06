import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Ranking rankObj = new Ranking();
		Scanner scan = new Scanner(System.in);
		int noOfStudents = Integer.parseInt(scan.nextLine());
		int totalVacancies = Integer.parseInt(scan.nextLine());
		int noOfUnreserved = Integer.parseInt(scan.nextLine());
		int noOfBC = Integer.parseInt(scan.nextLine());
		int noOfSC = Integer.parseInt(scan.nextLine());
		int noOfST = Integer.parseInt(scan.nextLine());
		for(int i=0; i<noOfStudents;i++){
			String[] tokens = scan.nextLine().split(",");
			rankObj.add(new Students(tokens[0],tokens[1],
				Integer.parseInt(tokens[2]),
				Integer.parseInt(tokens[3]),
				Integer.parseInt(tokens[4]),
				Integer.parseInt(tokens[5]),
				tokens[5]));
		}
		rankObj.printMerit();
		System.out.println();
		rankObj.printResult();
	}
}