import java.util.Scanner;
/**.
 * Solution class
 */
class Solution {
    /**.
     * { main method to handle the input testcases }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scan = new Scanner(System.in);
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int nul = 10101;
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                bst.put(new Book(tokens[one], tokens[two], tokens[three]), Integer.parseInt(tokens[four]));
                break;
            case "get":
                int temp = bst.get(new Book(tokens[one], tokens[two], tokens[three]));
                if (temp == nul) {
                    System.out.println("null");
                    break;
                }
                System.out.println(temp);
                break;
            default:
            }
        }
    }
}
/**.
 * Book class to store the propersties of a book
 */
class Book implements Comparable<Book> {
    /**.
     * variable for Book name
     */
    private String name;
    /**.
     * variable for name of the author
     */
    private String author;
    /**.
     * variable for storing the price of the book
     */
    private double price;
    /**.
     * Book class constructor
     *
     * @param      n     { name of type String }
     * @param      a     { Author of type  String }
     * @param      p     { Price of integer type }
     */
    Book(final String n, final String a, final String p) {
        this.name = n;
        this.author = a;
        this.price = Double.parseDouble(p);
    }
    /**.
     * method to get the name of the book
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /*public String getAuthor() {
        return author;
    }*/
    /*public double getPrice() {
        return price;
    }*/
    /*public void setName(String n) {
        this.name = n;
    }
    public void setAuthor(String a) {
        this.author = a;
    }
    public void setPrice(String p) {
        this.price = Double.parseDouble(p);
    }*/

    /**.
     * method to compare the given two books
     *
     * @param      that  book as Type Book
     *
     * @return     { Integer value for comparision }
     */
    public int compareTo(final Book that) {
        return this.getName().compareTo(that.getName());
    }
}
/**.
 * BinarySearchTree class
 *
 * @param      <Book>     The book as Key
 * @param      <Integer>  value of type Integer
 */
class BinarySearchTree<Book extends Comparable<Book>, Integer> {
    /**.
     * variable to deneote the root of the bst
     */
    private Node root;
    /**.
     * Node class to denote the the BST structure which contains key, value
     */
    class Node {
        /**.
         * variable for key of type book
         */
        private Book key;
        /**.
         * variable for Value of type int
         */
        private int value;
        /**.
         * variable left leaf as Left of type Node
         */
        private Node left;
        /**.
         * Varaible for right leaf as Right of type Node
         */
        public Node right;
        /**.
         * Node constructor
         *
         * @param      k     { of tyoe Book }
         * @param      v     { of type integer }
         */
        Node(Book k, int v) {
            this.key = k;
            this.value = v;
            this.right = null;
            this.left = null;
        }
        /**.
         * Method to return the key
         *
         * @return     The key.
         */
        public Book getKey() {
            return this.key;
        }
        /**.
         * method to return value
         *
         * @return     The value.
         */
        public int getValue() {
            return this.value;
        }
        /**.
         * Getter method for left
         *
         * @return     The left.
         */
        private Node getLeft(){
            return this.left;
        }
        /**.
         * getter method for right
         *
         * @return     The right.
         */
        public Node getRight(){
            return this.right;
        }
        /**.
         * setter method for left
         *
         * @param      l     { left node }
         */
        public void setLeft(Node l){
            this.left = l;
        }
        /**.
         * setter method for right
         *
         * @param      r     { right node }
         */
        public void setRight(Node r){
            this.right = r;
        }
        /**
         * Sets the value.
         *
         * @param      v     { parameter_description }
         */
        public void setValue(int v){
            this.value = v;
        }

    }
    /**.
     * constructor for BinarySearchTree
     */
    BinarySearchTree() {
        this.root = null;
    }
    /**.
     * method for putting a key into the bst
     *
     * @param      key    of type book
     * @param      value  of type Integer
     */
    public void put(final Book key, final int value) {
        root = put(root, key, value);
    }
    /**.
     * method to put the given key into the BST recursively.
     *
     *
     * @param      curr   of type Node
     * @param      key    of type Book
     * @param      value  of type integer
     *
     * @return     { Current node of type Node }
     */
    public Node put(final Node curr, final Book key, final int value) {
        Node current = curr;

        if (current == null) {
            return new Node(key, value);
        }
        int c = key.compareTo(current.getKey());
        if (c < 0) {
            current.setLeft(put(current.getLeft(), key, value));
        } else if (c > 0) {
            current.setRight(put(current.right, key, value));
        } else if ( c == 0) {
            current.value = value;
        }
        return current;

    }
    /**.
     * { method to get the value for the searched element }
     *
     * @param      key   of type key
     *
     * @return     { the value of type integer }
     */
    public int get(final Book key) {
        Node current = root;
        while (current != null) {
            int c = key.compareTo(current.key);
            if (c > 0) {
                current = current.right;
            } else if (c < 0) {
                current = current.left;
            } else if ( c == 0) {
                return current.value;
            }
        }
        final int nul = 10101;
        return nul;
    }


}