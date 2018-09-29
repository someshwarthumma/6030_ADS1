class LinkedList<E>{
    Node head;
    int size;
    class Node{
        E data;
        Node link;
        Node(){
            this.data = null;
            this.link = null;
        }

        Node(E data){
            this.data = data;
            this.link = null;
        }
    }

	LinkedList(){
        //head = new Node();
        size = 0;
	}

    public void addAtEnd(E data){
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

    public void addAtStart(E data){
        Node newNode = new Node(data);
        newNode.link = head;
        head = newNode;
        size++;
    }

    /*public void addAtLocation(int location, E data){
        if(location >size){
            System.out.println("Invalid position Exception in add at location.");
            return;
        }
        Node newNode = new Node(data);
        int counter = 1;
        Node current = head;

        while(counter < location-1){
            current = current.link;
            counter++;
        }
        newNode.link = current.link;
        current.link = newNode;
        size++;

    }*/

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

    /*public void removeAtLocation(int location){
        if(size == 0){
            System.out.println("No Element Found");
        }
        if(location == size){
            removeAtEnd();
            size--;
            return;
        }
        if(location > size){
            System.out.println("Invalid location ");
            return;
        }
        Node current = head;
        int counter = 1;
        while(counter < location-1){
            current = current.link;
            counter++;
        }
        Node temp = current.link;
        current.link = temp.link;
        temp.link = null;
        size--;

    }*/
    /*public void removeElement(E element){
        try{Node current = head;
        int counter = 1;
        while(current.data != element){
            current = current.link;
        }
        removeAtLocation(counter);
        } catch(Exception e){
            System.out.println("No element found for removeElement");
        }
    }*/
    /*public void print(){
        if(size == 0){
            System.out.println("[]");
            return;
        }
        Node current = head;
        System.out.print("[");
        while(current.link != null){
            System.out.print(current.data +", ");
            current = current.link;
        }
        System.out.print(current.data+ "]");
        System.out.println();
    }*/

    /*public String getList(){
        if(size == 0){
            return "[]";
        }
        Node current = head;
        String str = "[";
        while(current.link != null){
            str += current.data +", ";
            current = current.link;
        }
        str += current.data+ "]";
        return str;
    }*/
    public int getSize(){
        return this.size;
    }

    public E getObject(int index){
        if(size==0){
            return head.data;
        }
        Node current = head;
        int counter = 0;
        while(counter < index){
            current = current.link;
            counter++;
        }
        return current.data;

    }

    public E getFirst(){
        return head.data;

    }


}
