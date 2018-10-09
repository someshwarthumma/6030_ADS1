/**.
 * student class which contains the information of the students
 */
public class Student implements Comparable<Student> {
    private String studentName;
    private Date db;
    private int m1;
    private int m2;
    private int m3;
    private int tm;
    private String rc;
    private boolean alloted;
    
    /**.
     * returns true, if the student is already alloted,
     * otherwise false.
     * 
     * @return true if alloted, otherwise false.
     */
    public boolean getAlloted() {
        return alloted;
    }

    /**.
     * Changes the alloted status to true once the allotment is done.
     *
     * @param      allot  should be either true or false.
     */
    public void setAlloted(final boolean allot) {
        this.alloted = allot;
    }

    /**.
     * Gets the data of birth.
     * @return date of birth.
     */
    public Date getDb() {
        return db;
    }

    /**.
     * sets the student's date of birth.
     *
     * @param      b     [description]
     */
    public void setDb(final Date b) {
        this.db = b;
    }

    /**.
     * gets the date of birth.
     *
     * @return     the student's date of birth.
     */
    public String getRc() {
        return rc;
    }

    /**.
     * Sets the student's reservation category.
     *
     * @param      r     { parameter_description }
     */
    public void setRc(final String r) {
        this.rc = r;
    }

    /**.
     * gets the total marks.
     * @return returns the total marks of the student.
     */
    public int getTm() {
        return tm;
    }

    /**.
     * sets the student's total marks.
     *
     * @param      m     { parameter_description }
     */
    public void setTm(final int m) {
        this.tm = m;
    }

    /**.
     * Constructs the object based on the parameters.
     *
     * @param      studentName  Student Name
     * @param      dateOfBirth  Date of Birth
     * @param      m1           Marks in first subject.
     * @param      m2           Marks in second subject.
     * @param      m3           Marks in third subject.
     * @param      tm           Total Marks.
     * @param      rc           Reservation Category.
     */
    Student(String studentName, String dateOfBirth,
                   int m1, int m2, int m3, int tm,
                   String rc) {
        this.studentName = studentName;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.db = sdf.parse(dateOfBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.tm = tm;
        this.rc = rc;
        this.alloted = false;
    }

    /**.
     * Gets the marks in subject 3.
     *
     * @return     m3 Marks in subject 3.
     */
    public int getM3() {
        return m3;
    }

    /**.
     * Sets the m3 to the 3rd subject.
     *
     * @param      m     { parameter_description }
     */
    public void setM3(final int m) {
        this.m3 = m;
    }

    /**.
     * Gets the marks in subject 2.
     *
     * @return     marks in subject 2.
     */
    public int getM2() {
        return m2;
    }

    /**.
     * Sets marks in subject 2.
     *
     * @param      m     { parameter_description }
     */
    public void setM2(final int m) {
        this.m2 = m;
    }

    /**.
     * Gets the marks in subject 1.
     * @return marks in subject 1.
     */
    public int getM1() {
        return m1;
    }

    /**.
     * Sets the marks to subject 1.
     *
     * @param      m     { parameter_description }
     */
    public void setM1(final int m) {
        this.m1 = m;
    }

    /**.
     * Gets the student name.
     * @return the student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**.
     * When required the student's name can be updated.
     * @param student student
     */
    public void setStudentName(final String student) {
        this.studentName = student;
    }

    /**.
     * Compares two objects of types students.
     * complexity is O(1)
     * @param  that second Student.
     * @return integer based on the requirements.
     */
    public int compareTo(final Student that) {
        if (this.getTm() > that.getTm()) {
            return -1;
        }
        if (this.getTm() < that.getTm()) {
            return 1;
        }
        if (this.getM3() > that.getM3()) {
            return -1;
        }
        if (this.getM3() < that.getM3()) {
            return 1;
        }
        if (this.getM2() > that.getM2()) {
            return -1;
        }
        if (this.getM2() < that.getM2()) {
            return 1;
        }
        if (this.getDb().compareTo(that.getDb()) < 0) {
            return 1;
        }
        if (this.getDb().compareTo(that.getDb()) > 0) {
            return -1;
        }
        return 0;
    }

    /**.
     * Gets the String version of the Students.
     * complexity is O(1)
     * @return String version of object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getStudentName() + ",");
        sb.append(this.getTm() + ",");
        sb.append(this.getRc());
        return sb.toString();
    }
}