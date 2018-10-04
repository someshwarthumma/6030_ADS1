import java.util.Scanner;
class LinkedList {
	Node head;
	Node tail;
	int size;

	class Node {
		int data;
		Node link;
		Node() {
			this.data = 0;
			this.link = null;
		}
		Node(int data) {
			this.data = data;
			this.link = null;
		}
	}


	LinkedList() {
		head = new Node();
		size = 0;
	}


	public void insertAt(int index, int data) throws Exception{
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

	public void insert(Node current, int counter, int index, int data){
		if(index ==0){
			Node newNode = new Node(data);
			newNode.link = head;
			head = newNode;
			size++;
			return;
		}
		if (counter < index ) {
			if (counter == index - 1) {
				Node newNode = new Node(data);
				newNode.link = current.link;
				current.link = newNode;
				size++;
				return;
			}

			current = current.link;
			counter++;
			insert(current, counter, index , data);

		}
	}

	public void print(){
		Node current = head;
		while(current.link != null){
			System.out.print(current.data+", ");
			current = current.link;
		}
		System.out.println(current.data);
	}

	public void reverse(){
		if(size==0){
			System.out.println("No elements to reverse.");
			return;
		}
		reverse(head , null);

	}

	private void reverse(Node current, Node prev){
		if(current.link == null){
			current.link = prev;
			head = current;
			return;
		}
		Node temp = current.link;
		current.link = prev;
		reverse(temp, current);
	}
}
class Solution {
	public static void main(String[] args) {
		LinkedList linkedlistObj = new LinkedList();
		Scanner scan = new Scanner(System.in);
		try {
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "insertAt":
				linkedlistObj.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
				linkedlistObj.print(); 
				break;
			case "reverse":
				linkedlistObj.reverse();
				linkedlistObj.print();
				break;
			}
		}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}