import java.util.Scanner;
/**.
 * Percolation class for find weather percolation occurs or not
 */
class Percolation {
    /**.
     * { Size variable for gridSize  }
     */
    private int size;
    /**.
     * { Bottom Virtual node as size ,for avoiding the time complexity }
     */
    private int end;
    /**.
     * Top node as Start, for avoiding the time complexity
     */
    private int start;
    /**.
     * This is grid matrix for represating the open and close nodes
     */
    private boolean[][] grid;
    /**.
     * Creation of Weighted Quick Union object to find the connection
     * between start and end node.
     */
    private WeightedQuickUnionUF unionObj;
    /**.
     * percolation constructor
     *
     * @param      n     { Size of the grid defined }
     */
    Percolation(final int n) {
        end = n * n + 1;
        start = n * n;
        size = n;
        grid = new boolean[n][n];
        unionObj = new WeightedQuickUnionUF(n * n + 2);
    }
    /**.
     *Open method to Open the node in grid matrix,
     *and to establish te connecction
     *
     * @param      row   row
     * @param      col   column
     */
    public void open(final int row, final int col) {
        if (grid[row][col]) {
            return;
        }
        grid[row][col] = true;

        if (row == 0) {
            unionObj.union(start, getIndex(row, col));
        }
        if (row == size - 1) {
            unionObj.union(end, getIndex(row, col));
        }
        if (row - 1 >= 0 && isOpen(row - 1, col)) {
            unionObj.union(getIndex(row, col), getIndex(row - 1, col));
        }
        if (row + 1 < size && isOpen(row + 1, col)) {
            unionObj.union(getIndex(row, col), getIndex(row + 1, col));
        }
        if (col - 1 >= 0 && isOpen(row, col - 1)) {
            unionObj.union(getIndex(row, col), getIndex(row, col - 1));
        }
        if (col + 1 < size && isOpen(row, col + 1)) {
            unionObj.union(getIndex(row, col), getIndex(row, col + 1));
        }

    }
    /**.
     * GetIndex method to convert 2D cordinate into a 1D cordinate
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     The index.
     */
    private int getIndex(final int row, final int col) {
        return row * size + col;
    }
    /**.
     * Open method to check weather it is open or not
     *
     * @param      row   row
     * @param      col   column
     *
     * @return     True if open, False otherwise.
     */
    private boolean isOpen(final int row, final int col) {
        return grid[row][col];
    }
    /**.
     * percolates method to check weather for percolation
     *
     * @return     { Return true if percolation occurs,else false }
     */
    public boolean percolates() {
        return unionObj.connected(end, start);
    }
}
/**.
 * Solution class to handle the input testcases
 */
public final class Solution {
    /**.
     * Solution class constructor
     */
    private Solution() {
        //Private constructor
    }
    /**.
     * Scanner object for reading the inputs
     */
    private static Scanner scan = new Scanner(System.in);
    /**.
     * main class for input.
     *
     * @param      args  arguments
     */
    public static void main(final String[] args) {
        Percolation percolationObj = new Percolation(Integer.
            parseInt(scan.nextLine()));
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(" ");
            //System.out.println(Arrays.toString(input));
            percolationObj.open(Integer.
                parseInt(input[0]) - 1, Integer.
                parseInt(input[1]) - 1);
        }
        System.out.println(percolationObj.percolates());
    }
}
