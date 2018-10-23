import java.util.Scanner;
/**.
 * LinkedList class
 */
class LinkedList {
    /**.
     * variable for head node
     */
    private Node head;
    /**.
     * Size variable.
     */
    private int size;
    /**.
     * Class node to represent the data and link to next node
     */
    class Node {
        /**.
         * variable for data
         */
        private int data;
        /**.
         * Varianble for pointing to next node
         */
        private Node link;
        /**.
         * Node constructor
         */
        Node() {
            this.data = 0;
            this.link = null;
        }
        /**.
         * Node constructor with data as parameter
         *
         * @param      data1  data of int type
         */
        Node(final int data1) {
            this.data = data1;
            this.link = null;
        }
    }
    /**.
     * Linkedlist class constructor
     */
    LinkedList() {
        head = new Node();
        size = 0;
    }
    /**.
     * InserAt method to insert the element at the given index
     * complexity O(N):
     * beacuse it traverse all along the last element in worst case
     *
     * @param      index      index of type int
     * @param      data       data of type int
     *
     * @throws     Exception  { throw error if index in invalid}
     */
    public void insertAt(final int index, final int data) throws Exception {
        if (index > size || index < 0) {
            throw new Exception("Can't insert at this position.");
        }
        if (size == 0) {
            head = new Node(data);
            size++;
            return;
        }
        Node current = head;
        int counter = 0;
        insert(current, counter, index, data);
    }
    /**.
     * insert method to insert the elements at given index
     * complexity O(N):
     * beacuse it traverse all along the last element in worst case
     * @param      current1  current of type Node
     * @param      counter1  counter of type Node
     * @param      index    index of type int
     * @param      data     data of type int
     */
    public void insert(final Node current1,
        final int counter1,
        final int index,
        final int data) {
        Node current = current1;
        int counter = counter1;
        if (index == 0) {
            Node newNode = new Node(data);
            newNode.link = head;
            head = newNode;
            size++;
            return;
        }
        if (counter < index) {
            if (counter == index - 1) {
                Node newNode = new Node(data);
                newNode.link = current.link;
                current.link = newNode;
                size++;
                return;
            }

            current = current.link;
            counter++;
            insert(current, counter, index, data);

        }
    }
    /**.
     * method to print the output
     * Complexity is O(N) because it print all elements in the list
     */
    public void print() {
        Node current = head;
        while (current.link != null) {
            System.out.print(current.data + ", ");
            current = current.link;
        }
        System.out.println(current.data);
    }
    /**.
     * public method to reverse the linkedlist
     * complexity O(N):
     * beacuse it traverse all along the last element in worst case
     * @throws     Exception  { if linked list is Empty }
     */
    public void reverse() throws Exception {
        if (size == 0) {
            throw new Exception("No elements to reverse.");
        }
        reverse(head, null);

    }
    /**.
     * Reverse method with two arguments
     * complexity O(N):
     * beacuse it traverse all along the last element in worst case
     * @param      current  The current
     * @param      prev     The previous
     */
    private void reverse(final Node current, final Node prev) {
        if (current.link == null) {
            current.link = prev;
            head = current;
            return;
        }
        Node temp = current.link;
        current.link = prev;
        reverse(temp, current);
    }
}
/**.
 * Solution class
 */
final class Solution {
    /**.
     * Solution constructor
     */
    private Solution() {
        //Solution constructor
    }
    /**.
     * Main method to handle the input testcases
     * Complexity is O(N) since it reads all the elements
     * @param      args  arguments
     */
    public static void main(final String[] args) {
        /**.
         * linkelist object creation
         */
        LinkedList linkedlistObj = new LinkedList();
        /**.
         * scanner object
         */
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            try {
                String[] tokens = scan.nextLine().split(" ");
                switch (tokens[0]) {
                case "insertAt":
                    linkedlistObj.insertAt(Integer.
                        parseInt(tokens[1]), Integer.
                        parseInt(tokens[2]));
                    linkedlistObj.print();
                    break;
                case "reverse":
                    linkedlistObj.reverse();
                    linkedlistObj.print();
                    break;
                default:
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
