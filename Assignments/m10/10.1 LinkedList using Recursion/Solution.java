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


	public void insertAt(int index, int data) {
		if (index > size || index < 0) {
			System.out.println("Can't insert at this position.");
			return;
		}
		if (size == 0) {
			head = new Node(data);
			size++;
			return;
		}
		Node current = head;
		int counter = 0;
		insert(current, counter, index, data);
		/*f (counter < index - 1) {
			if (counter = index - 1) {
				Node newNode = new Node(data);
				newNode.link = current.link;
				current.link = newNode;
				return;
			}

			current = current.link;
			counter++;
			insertAt(index , data);

		}*/

	}

	public void insert(Node current, int counter, int index, int data){
		if(index ==0){
			Node newNode = new Node(data);
			newNode.link = head;
			head = newNode;
			size++;
			return;
		}
		if (counter < index - 1) {
			if (counter == index - 1) {
				Node newNode = new Node(data);
				newNode.link = current.link;
				current.link = newNode;
				size++;
				return;
			}

			current = current.link;
			counter++;
			insertAt(index , data);

		}
	}

	public String print(){
		Node current = head;
		int counter = 1;
		return current.data +", "+ print(current, counter);
	}

	public String print(Node current, int counter){
		if(counter== size-1){
			return current.data+"";
		}
		current = current.link;
		counter++;
		return current.data + print(current , counter);
	}




}
class Solution {
	public static void main(String[] args) {
		LinkedList linkedlistObj = new LinkedList();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "insertAt":
				linkedlistObj.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
				System.out.println(linkedlistObj.print());
				break;
			case "reverse":
				//linkedlistObj.reverse();
				break;
			}
		}
	}
}