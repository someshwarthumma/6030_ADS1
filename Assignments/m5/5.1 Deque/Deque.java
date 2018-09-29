public class Deque<E>{
	int size;
	LinkedList<E> linkedQueue;
	Deque(){
		linkedQueue = new LinkedList<E>();
		size =0;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int size(){
		return size;
	}

	public void pushLeft(E item){
		linkedQueue.addAtStart(item);
		size++;
		linkedQueue.print();
	}

	public void pushRight(E item){
		linkedQueue.addAtEnd(item);
		size++;
		linkedQueue.print();
	}
	public void popLeft(){
		if(size==0){
			System.out.println("Deck is empty");
			return;
		}
		size--;
		linkedQueue.removeAtStart();
		if(linkedQueue.getSize()==0) {
			System.out.println("[]");
			return;
		}
		linkedQueue.print();
	}
	public void popRight(){
		if(size==0){
			System.out.println("Deck is empty");
			return;
		}
		size--;
		linkedQueue.removeAtEnd();
		if(linkedQueue.getSize()==0) {
			System.out.println("[]");
			return;
		}
		linkedQueue.print();
	}



}