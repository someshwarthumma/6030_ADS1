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
     * complexity is O(N^2) since in for loop we use hashTable
     * which has a complexity of O(N)
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinearProbingHashST<
        Integer, Student> hash = new LinearProbingHashST<
        Integer, Student>();
        Scanner scan = new Scanner(System.in);
        int totalStudents = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < totalStudents; i++) {
            String[] tokens = scan.nextLine().split(",");
            hash.put(Integer.parseInt(tokens[0]), new Student(
                tokens[1], Double.parseDouble(tokens[2])));
        }
        int totalTestsCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < totalTestsCases; i++) {
            try {
                String[] tokens2 = scan.nextLine().split(" ");
                Student temp = hash.get(Integer.parseInt(tokens2[1]));
                if (temp == null) {
                    throw new Exception("Student doesn't exists...");
                }
                switch (tokens2[2]) {
                case "1":
                    System.out.println(temp.getName());
                    break;
                case "2":
                    System.out.println(temp.getMarks());
                    break;
                default:
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
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
     * marks varible
     */
    private Double marks;
    /**.
     * student constructor
     *
     * @param      n     { variable for name of type string}
     * @param      m    variable for marks of type double
     */
    Student(final String n, final Double m) {
        this.marks = m;
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
     * getter method for marks
     *
     * @return     The marks of type double
     */
    public Double getMarks() {
        return this.marks;
    }
}
