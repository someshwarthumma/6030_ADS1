/**.
 * LinkedList class implementation as ADT
 */
class LinkedList{
    /**.
     * Head pointer for first element
     */
    Node head;
    /**.
     * Size variable for size
     */
    int size;
    /**.
     * Class node for each cell containing data and link
     */
    class Node{
        /**.
         * Data variable
         */
        int data;
        /**.
         * link object belong to class
         */
        Node link;
        /**.
         * Node constructor
         */
        Node(){
            this.data = 0;
            this.link = null;
        }
        /**.
         * Node constructor
         *
         * @param      data  The data
         */
        Node(final int data){
            this.data = data;
            this.link = null;
        }
    }
    /**.
     * Linked list constructor
     */
	LinkedList(){
        //head = new Node();
        size = 0;
	}
    /**.
     * Add at End method to add at end of the linkedlist
     *
     * @param      data  The data
     */
    public void addAtEnd(final int data){
        Node newNode;
        if(size == 0) {
            head = new Node(data);
            //head = newNode;
            size++;
            return;
        }
        Node current;
        current = head;
        while(current.link != null){
            current = current.link;
        }
        newNode = new Node(data);
        current.link = newNode; 
        size++;
    }
    /**.
     * Add at start method to add at head
     *
     * @param      data  The data
     */
    public void addAtStart(final int data){
        Node newNode = new Node(data);
        newNode.link = head;
        head = newNode;
        size++;
    }
    /**.
     * Remove at end to remove the element at the end
     */
    public void removeAtEnd(){
        if(size == 0){
            System.out.println("No Element Found");
            return;
        }
        Node current = head;
        int counter = 1;
        while(counter < size-1){
            current = current.link;
            counter++;
        }
        current.link = null;
        size--;
    }
    /**.
     * to remove at start 
     */
    public void removeAtStart(){
        if(size == 0){
            System.out.println("No Element Found");
            return;
        }
        Node current = head;
        head = head.link;
        current.link = null;
        size--;
    }

    /**.
     * To get the size
     *
     * @return     The size.
     */
    public int getSize(){
        return this.size;
    }
    /**.
     * To return the data in the node.
     *
     * @param      index  The index
     *
     * @return     The object.
     */
    public int getObject(final int index){
        if(size==0){
            return (int)head.data;
        }
        Node current = head;
        int counter = 0;
        while(counter < index){
            current = current.link;
            counter++;
        }
        return (int)current.data;

    }
    /**.
     * To return the head data.
     *
     * @return     The first.
     */
    public int getFirst(){
        return (int)head.data;

    }


}
