class Steque{
	Node head;
	int size;
	class Node{
		Node link;
		//Node last;
		int data;
		Node(){
			this.data = 0;
			this.link = null;
		}
		Node(int data){
			this.data = data;
			this.link = null;
		}
	}
	Steque(){
		size =0;
	}

	public void push(int data){
		if(size==0){
			head = new Node(data);
			size++;
			return;
		}
		Node newNode = new Node(data);
		newNode.link = head;
		head = newNode;
		size++;
		return;
	}

	public void enqueue(int data){
		if(size==0){
			head = new Node(data);
			size++;
			return;
		}
		/*
		 *last
		 *last.link = newNode;
		 *last = newNode;
		*/
		Node newNode = new Node(data);
		Node current = head;
		int counter =1;
		while(counter < size){
			current = current.link;
			counter++;
		}

		current.link = newNode;
		size++;
		return;
	}

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

	public void reset(){
		size = 0;
		head = null;
		return;
	}

}