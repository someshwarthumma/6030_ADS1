import java.util.Scanner;
/**.
 * solution class
 */
final class Solution {
    /**.
     * solution class constructor
     */
    private Solution() {
        //constructor
    }
    /**.
     * main method to handle the input testcasses
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        MinPQ<Float> minPQObj = new MinPQ<Float>(n);
        MaxPQ<Float> maxPQObj = new MaxPQ<Float>(n);
        float median = 0.0f;
        for (int i = 0; i < n; i++) {
            float k = scan.nextFloat();
            if (k > median) {
                minPQObj.insert(k);
            } else {
                maxPQObj.insert(k);
            }
            if (maxPQObj.size() - minPQObj.size() > 1) {
                float x = maxPQObj.delMax();
                minPQObj.insert(x);
            }
            if (minPQObj.size() - maxPQObj.size() > 1) {
                float y = minPQObj.delMin();
                maxPQObj.insert(y);
            }
            if (minPQObj.size() == maxPQObj.size()) {
                median = (minPQObj.min() + maxPQObj.max()) / 2;
                System.out.println(median);
            }
            if (maxPQObj.size() > minPQObj.size()) {
                median = maxPQObj.max();
                System.out.println(median);
            }
            if (minPQObj.size() > maxPQObj.size()) {
                median = minPQObj.min();
                System.out.println(median);
            }
        }
    }
}