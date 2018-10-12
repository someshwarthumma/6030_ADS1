import java.util.Scanner;

class Solution {
	/**
	 * solution constructor.
	 */
	private Solution(){
	//Solution constructor
	}
	/**
	 * method to handle the input testcases
	 *
	 * @param      args  argument
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split(" ");
		TaxiCabNumbers tcn = new TaxiCabNumbers();
		int result = tcn.findTaxiCabNumber(Integer.
			parseInt(tokens[0]), Integer.
			parseInt(tokens[1]));
		System.out.println(result);
	}
}