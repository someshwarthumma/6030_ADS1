import java.util.Scanner;
/**.
 * solution class
 */
class Solution {
    /**.
     * a
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfStocks = Integer.parseInt(scan.nextLine());

        for (int j = 0; j < 6; j++) {
            //for (int j = 0; j < noOfStocks; j++) {

            MinPQ<Stock> maxST = new MinPQ<Stock>();
            MaxPQ<Stock> minST = new MaxPQ<Stock>();
            float median = 0.0f;

            for (int i = 0; i < noOfStocks; i++) {

                String[] stockData = scan.nextLine().split(",");
                Stock stockObj = new Stock(stockData[0], Float.parseFloat(stockData[1]));
                float k = stockObj.getChange();
                if (k > median) {
                    maxST.insert(stockObj);
                } else {
                    minST.insert(stockObj);
                }
                if (minST.size() - maxST.size() > 1) {
                    Stock x = minST.delMax();
                    maxST.insert(x);
                }
                if (maxST.size() - minST.size() > 1) {
                    Stock y = maxST.delMin();
                    minST.insert(y);
                }
                if (maxST.size() == minST.size()) {
                    median = (maxST.min().getChange() + minST.max().getChange()) / 2;
                    //System.out.println(median);
                }
                if (minST.size() > maxST.size()) {
                    median = minST.max().getChange();
                    //System.out.println(median);
                }
                if (maxST.size() > minST.size()) {
                    median = maxST.min().getChange();
                    //System.out.println(median);
                }
            }

            Stock[] maxStocks = new Stock[maxST.size()];
            Stock[] minStocks = new Stock[minST.size()];
            for (int i = 0; i < maxStocks.length; i++) {
                maxStocks[i] = maxST.delMin();
            }
            for (int i = 0; i < minStocks.length; i++) {
                minStocks[i] = minST.delMax();
            }
            printer(maxStocks);
            printer(minStocks);
        }
    }
    /**.
     * method to print the output.
     *
     * @param      s     { parameter_description }
     */
    public static void printer(final Stock[] s) {
        int counter = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.println(s[i].getName() + " " + s[i].getChange());
            Stock st = s[i];

            counter++;
            if (counter == 5) {
                break;
            }
        }
        System.out.println();
    }
}


