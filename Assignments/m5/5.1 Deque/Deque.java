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
		return this.size;
	}

	public void pushLeft(E item){
		linkedQueue.addAtStart(item);
	}

	public void pushRight(E item){
		linkedQueue.addAtEnd(item);
	}
	public void popLeft(){
		linkedQueue.removeAtStart();
		linkedQueue.print();
	}
	public void popRight(){
		linkedQueue.removeAtEnd();
		linkedQueue.print();
	}



}