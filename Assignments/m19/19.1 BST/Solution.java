import java.util.Scanner;
/**
 * solution class
 */
final class Solution {
    /**.
     * Private constructor
     */
    private Solution() {
        //private constructor
    }
    /**.
     * main method for handling the input testcases
     * Complexity is O(N) as it reads the input
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BST bst = new BST();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                bst.put(new BookInfo(tokens[1], tokens[2],
                    tokens[2 + 1]), Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                int output = bst.get(new BookInfo(tokens[1],
                                                  tokens[2],
                                                  tokens[2 + 1]));
                if (output == 0) {
                    System.out.println("null");
                } else {
                    System.out.println(output);
                }
                break;
            case "max":
                Comparable maxbook = bst.max();
                System.out.println(maxbook.toString());
                break;
            case "min":
                Comparable minbook = bst.min();
                System.out.println(minbook.toString());
                break;
            case "select":
                Comparable select = bst.select(Integer.
                    parseInt(tokens[1]));
                System.out.println(select.toString());
                break;
            case "floor":
                Comparable floor = bst.floor(new BookInfo(
                    tokens[1], tokens[2], tokens[2 + 1]));
                if (floor == null) {
                    System.out.println("null");
                } else {
                    System.out.println(floor.toString());
                }
                break;
            case "ceiling":
                Comparable ceiling = bst.ceiling(new BookInfo(
                    tokens[1], tokens[2], tokens[2 + 1]));
                if (ceiling == null) {
                    System.out.println("null");
                } else {
                    System.out.println(ceiling.toString());
                }
                break;
            default:
                break;
            }
        }
    }
}
/**.
 * Class to representthe book properties
 */
class BookInfo implements Comparable<BookInfo> {
    /**.
     * variable for BookName
     */
    private String bookName;
    /**.
     * variable for bookAuthor
     */
    private String bookAuthor;
    /**.
     * variable for book price
     */
    private String bookPrice;
    /**.
     * bookInfo constructor
     *
     * @param      n     { as name }
     * @param      a     { as author }
     * @param      p     { as price }
     */
    BookInfo(final String n, final String a, final String p) {
        this.bookName = n;
        this.bookAuthor = a;
        this.bookPrice = p;
    }
    /**.
     * method to get the name
     * Complexity is O(1)
     *
     * @return     The name of type string
     */
    public String getName() {
        return this.bookName;
    }
    /**.
     * method to get author name
     * Complexity is O(1)
     *
     * @return     The author of type string
     */
    public String getAuthor() {
        return this.bookAuthor;
    }
    /**.
     * method to get the price
     * Complexity is O(1)
     *
     * @return     The price.
     */
    public String getPrice() {
        return this.bookPrice;
    }
    /**.
     * method to  print the object
     * Complexity is O(1)
     *
     * @return     object as String
     */
    public String toString() {
        return this.getName() + ", "
               + this.getAuthor() + ", "
               + Float.parseFloat(this.getPrice());
    }
    /**.
     * method to compare the two objects
     * Complexity is O(1)
     *
     * @param      that  The that
     *
     * @return     { int }
     */
    public int compareTo(final BookInfo that) {
        return this.getName().compareTo(that.getName());
    }
}

