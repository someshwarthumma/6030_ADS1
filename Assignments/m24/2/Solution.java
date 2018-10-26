import java.util.Scanner;
/**.
 * solution class
 */
final class Solution {
    /**.
     * solution constructor
     */
    private Solution() {
        //constructor
    }
    /**.
     * main method to handle the input testcases
     * complexity is O(NLogN) since in for loop we use BST
     * which has a complexity of O(log(N))
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        RedBlackBST bst = new RedBlackBST();
        Scanner scan = new Scanner(System.in);
        int totalStudents = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < totalStudents; i++) {
            String[] tokens = scan.nextLine().split(",");
            bst.put(Double.parseDouble(tokens[2]), new Student(Integer.parseInt(tokens[0]), (tokens[1])));
        }
        int totalTestsCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < totalTestsCases; i++) {
            String[] tokens2 = scan.nextLine().split(" ");
            switch (tokens2[0]) {
            case "BE":
                Student[] temp = bst.getRangeElements(Double.parseDouble(tokens2[1]), Double.parseDouble(tokens2[1]));
                for(int j=0;j<temp.length;j++){
                    System.out.println(temp[j].getName());
                }
                break;
            case "GE":
                temp = bst.getGreaterElements(Double.parseDouble(tokens2[1]));
                for(int k=0;k<temp.length;k++){
                    System.out.println(temp[k].getName());
                }
                break;
            case "LE":
                temp = bst.getLesserElements(Double.parseDouble(tokens2[1]));
                for(int l=0;l<temp.length;l++){
                    System.out.println(temp[l].getName());
                }
            default:
            }
        }
    }
}
/**.
 * student class
 */
class Student {
    /**.
     * name variable
     */
    private String name;
    /**.
     * rollNumber varible
     */
    private int rollNumber;
    /**.
     * student constructor
     *
     * @param      n     { variable for name of type string}
     * @param      m    variable for rollNumber of type int
     */
    Student(final int m, final String n) {
        this.rollNumber = m;
        this.name = n;
    }
    /**.
     * getter method for name
     *
     * @return     The name of type string
     */
    public String getName() {
        return this.name;
    }
    /**.
     * getter method for rollNumber
     *
     * @return     The rollNumber of type int
     */
    public int getrollNumber() {
        return this.rollNumber;
    }
}