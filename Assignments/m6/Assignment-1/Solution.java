import java.util.Scanner;
/**.
 * implementaton of stack class.
 */
class Stack {
    /**.
     * creation of the linked list object for stack class.
     */
    LinkedList stack;
    /**.
     * Stack constructor
     */
    Stack() {
        stack = new LinkedList();
    }
    /**.
     * Push method to put the elements at the top of the stack.
     *
     * @param      item  item to pushed on the stack
     */
    public void push(final int item) {
        stack.addAtEnd(item);
    }
    /**.
     * pop method to takeout the element from the stack
     *
     * @return     { int }
     */
    public int pop() {
        int index = stack.getSize() - 1;
        int poped = stack.getObject(index);
        stack.removeAtEnd();
        return poped;
    }
}
/**.
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**.
     * constructor.
     */
    AddLargeNumbers(){
        //Constructor
    }
    /**.
     * This is addLargeNumbers
     *
     * @param      number  number
     *
     * @return     { linkedList Object }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList linkedlist = new LinkedList();
        for (int i = 0; i < number.length(); i++) {
            int num = Integer.parseInt(number.charAt(i) + "");
            linkedlist.addAtEnd(num);
        }
        return linkedlist;
    }
    /**.
     * method to convert the digits to numbers
     *
     * @param      list  list
     *
     * @return     { String }
     */
    public static String digitsToNumber(final LinkedList list) {
        int listSize = list.getSize();
        String str = "";
        for (int i = 0; i < listSize; i++) {
            str += list.getFirst();
            list.removeAtStart();
        }
        return str;
    }
    /**.
     * method for adding the larger numbers given two lists.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { linked list obj }
     */
    public static LinkedList addLargeNumbers(
        final LinkedList list1,
        final LinkedList list2) {

        /**.
         * Stack object for first list
         */
        Stack stack1 = new Stack();
        /**.
         * Stack obj for second list
         */
        Stack stack2 = new Stack();
        /**.
         * Carry flag
         */
        int carry = 0;
        /**.
         * size of first list
         */
        int size1 = list1.getSize();
        /**.
         * Size of secondlist.
         */
        int size2  = list2.getSize();
        /**
         * creation of addition object of type Linkedlist
         */
        LinkedList addition = new LinkedList();
        if (size1 > size2) {
            //System.out.println("first if");
            int diff = size1 - size2;
            for (int i = 0; i < diff; i++) {
                list2.addAtStart(0);
            }
        }
        if (size2 > size1) {
            //System.out.println("second if");
            int diff = size2 - size1;
            for (int i = 0; i < diff; i++) {
                list1.addAtStart(0);
            }
        }
        //System.out.println(list1.getSize() +"-"+ list2.getSize());
        size1 = list1.getSize();
        size2 = list1.getSize();
        if (size1 == size2) {
            for (int i = 0; i < size1; i++) {
                stack1.push(list1.getFirst());
                list1.removeAtStart();
                stack2.push(list2.getFirst());
                list2.removeAtStart();
            }
            for (int i = 0; i < size1; i++) {
                int one = stack1.pop();
                int two = stack2.pop();
                int sum = one + two;
                int temp = carry;
                final int ten = 10;
                carry = (carry + sum) / ten;
                int add = (sum + temp) % ten;
                addition.addAtStart(add);
            }
            if (carry != 0) {
                addition.addAtStart(carry);
            }

        }
        return addition;

    }
}
/**.
 * Solution class
 */
public class Solution {
    /**.
     * Solution constructor.
     */
    private Solution() {
        //Solution constructor
    }
    /**.
     * main to handle the input testcases
     *
     * @param      args  arguments from console
     */
    public static void main(final String[] args) {
        /**.
         * scanner class to read the input
         */
        Scanner sc = new Scanner(System.in);
        /**.
         * { operation tyoe }
         */
        String input = sc.nextLine();
        /**.
         * First number
         */
        String p = sc.nextLine();
        /**.
         * Second number
         */
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.
            addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.
                digitsToNumber(result));
            break;
        default:
        }
    }

}
