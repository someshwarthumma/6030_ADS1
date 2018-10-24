import java.util.Scanner;
/**.
 * This solution class for input testcases
 */
class Solution {
    /**.
     * Main method
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
            case "delete":
                bst.delete(new BookInfo(tokens[1], tokens[2],
                                        tokens[2 + 1]));
                break;
            case "deleteMin":
                bst.deleteMin();
                break;
            case "deleteMax":
                bst.deleteMax();
                break;
            default:
                break;
            }
        }
    }
}
/**.
 * Class to represent the properties of a book
 */
class BookInfo implements Comparable<BookInfo> {
    /**.
     * variable for bookName
     */
    String bookName;
    /**.
     * variable for author name
     */
    String bookAuthor;
    /**.
     * variable for price
     */
    String bookPrice;
    /**.
     * BookInfo constructor
     *
     * @param      n     { as name }
     * @param      a     { as Author }
     * @param      p     { as price }
     */
    BookInfo(final String n, final String a, final String p) {
        this.bookName = n;
        this.bookAuthor = a;
        this.bookPrice = p;
    }
    /**.
     * method to get the name of the book
     *
     * @return     The name of type string
     */
    public String getName() {
        return this.bookName;
    }
    /**.
     * method to get Author  of the book
     *
     * @return     The author of type string
     */
    public String getAuthor() {
        return this.bookAuthor;
    }
    /**.
     * method to get the price of the book
     *
     * @return     The price of type string
     */
    public String getPrice() {
        return this.bookPrice;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getName() + ", "
               + this.getAuthor() + ", "
               + Float.parseFloat(this.getPrice());
    }
    /**.
     * method to compare the given two books
     *
     * @param      that  object
     *
     * @return     { int }
     */
    public int compareTo(final BookInfo that) {
        return this.getName().compareTo(that.getName());
    }
}

