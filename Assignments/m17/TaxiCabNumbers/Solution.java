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

/**.
 * TaxiCabNumbers class.
 */
class TaxiCabNumbers {
    /**.
     * method to find the taxiNumber.
     *
     * @param      number        The number of type integer
     * @param      possibleWays  of type integer
     *
     * @return     { Integer type which is a taxiCabNumber }
     */
    public int findTaxiCabNumber(final int number, final int possibleWays) {
        int num = number;
        int ways = possibleWays;
        final int n = 600;

        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        int previous = -1;
        int numCounter = 0;
        int waysCounter = 1;
        // find smallest sum, print it out, and update

        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            //System.out.println("This is while: ");
            if (previous == s.sum) {
                waysCounter++;
            } else {
                waysCounter = 0;
            }

            if (waysCounter == ways - 1) {
                numCounter++;
                if (numCounter == num) {
                    return s.sum;
                }
            }
            previous = s.sum;
            //StdOut.println(s);
            if (s.j < n) {
                pq.insert(new CubeSum(s.i, s.j + 1));
            }
        }
        return -1;
    }
}