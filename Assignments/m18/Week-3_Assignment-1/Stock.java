/**
 * Stock class
 */
class Stock implements Comparable<Stock> {
    /**
     * variable for name
     */
    private String name;
    /**
     * variable for change in stock
     */
    private Float change;
    /**.
     * constructor of Stock class
     *
     * @param      s     { parameter_description }
     * @param      c     { parameter_description }
     */
    Stock(String s, Float c) {
        this.name = s;
        this.change = c;
    }
    /**
     * getter for name
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * getter for change
     *
     * @return     The change.
     */
    public Float getChange() {
        return this.change;
    }
    /**
     * compareTo method for comparision of objects.
     *
     * @param      that  The that
     *
     * @return     { Integer }
     */
    public int compareTo(final Stock that) {
        if (this.getChange() != that.getChange()) {
            return this.getChange().compareTo(that.getChange());
        }
        Integer s1 = this.getName().length();
        Integer s2 = that.getName().length();
        if (s1 != s2) {
            return s1.compareTo(s2);
        }
        return that.getName().compareTo(this.getName());
    }
}