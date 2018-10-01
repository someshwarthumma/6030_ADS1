/**.
 * Steque class object implimentaion
 */
class Steque{
	/**.
	 * Head variable
	 */
	Node head;
	/**.
	 * Size variable
	 */
	int size;
	/**.
	 * Variable last of type Node to point the last item
	 */
	Node last;
	/**.
	 * Node class
	 */
	class Node{
		/**.
		 * link of type Node to point to Next item
		 */
		Node link;
		/**.
		 * Data variable to store data
		 */
		int data;
		/**.
		 * Node constructor 
		 */
		Node(){
			this.data = 0;
			this.link = null;
		}
		/**.
		 * Node constructor with arguments of type int
		 *
		 * @param      data  int
		 */
		Node(int data){
			this.data = data;
			this.link = null;
		}
	}
	/**.
	 * Stequeue constructor to initialise the size;
	 */
	Steque(){
		size =0;
	}
	/**.
	 * method to push the data into stequeue at start
	 *complexity: O(1)
	 *because here element is put in first position
	 * @param      data  int
	 */
	public void push(int data){
		if(size==0){
			head = new Node(data);
			last = head;
			size++;
			return;
		}
		Node newNode = new Node(data);
		newNode.link = head;
		head = newNode;
		size++;
		return;
	}
	/**.
	 * method to put the element into the linked list at the end of the list
	 *complexity: O(1)
	 *since here, last and first node are refereneced with head and last
	 * @param      data  int
	 */
	public void enqueue(int data){
		if(size==0){
			head = new Node(data);
			last = head;
			size++;
			return;
		}
		Node newNode = new Node(data);
		last.link = newNode;
		last = newNode;		
		/*Node newNode = new Node(data);
		Node current = head;
		int counter =1;
		while(counter < size){
			current = current.link;
			counter++;
		}
		current.link = newNode;*/
		size++;
		return;
	}
	/**.
	 * method to remove the first element
	 * complexity: O(1)
	 * since the first element is popped out
	 */
	public void pop(){
		if(size==0){
			return;
		}
		if(size == 1){
			head.link = null;
			size--;
			return;
		}
		Node temp = head;
		head = head.link;
		temp.link = null;
		size--;
		return;
	}
	/**.
	 * method to return the element in stequeue
	 *complexity: O(N)
	 *because of usage of while loop
	 * @return     { String }
	 */
	public String printer(){
		if(size == 0){
			return "Steque is empty.";
		}
		String str = "";
		Node current = head;
		int counter = 1; 
		while(current.link != null){
			str += current.data + ", ";
			current = current.link;
			counter++;
		}
		str += current.data;
		return str;
	}
	/**.
	 * method to reset the elemenets in the stequeue.
	 * complexity: O(1)
	 * beacause here only size is made to zero
	 */
	public void reset(){
		size=0;
		return;
	}

}