public class Queue {
	int size;
	Node queue;
	Node head;
	class Node {
		int data;
		Node link;
		int size = 0;
		Node() {
			this.data = 0;
			this.link = null;
		}
		Node(int data) {
			this.data = data;
			this.link = null;
		}

		public Node getNode() {
			return this.link;
		}

		public int getdata() {
			return this.data;
		}

		public int getSize() {
			return this.size;
		}

		public void setLink(Node link) {
			this.link = link;
		}

		public void setData(int data) {
			this.data = data;
		}
		public void setSize(int size) {
			this.size = size;
		}
	}
	Queue() {
		queue = new Node();
		size = 0;
	}

	public void enQueue(int data) {
		if (size == 0) {
			head = new Node(data);
			size++;
			return;
		}
		Node start = new Node(data);
		start.link = head;
		head = start;
		size++;
		return;
	}

	public int deQueue()  {
		Node current = head;
		if (size == 1) {
			size--;
			int n = head.data;
			head = null;
			return current.data;
		}
		
		int counter = 1;
		while (counter<size-1) {
			counter++;
			current = current.link;
		}
		int data = current.link.data;
		current.link = null;
		size--;
		return data;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int getSize(){
		return size;
	}
}