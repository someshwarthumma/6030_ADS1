import java.util.Scanner;

class Stack{
	LinkedList stack;
	Stack(){
		stack = new LinkedList();
	}
	public void push(int item){
		stack.addAtEnd(item);
	}
	public int pop(){
		int index = stack.getSize()-1;
		int poped = stack.getObject(index);
		stack.removeAtEnd();
		return poped;
	}
}
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
    	LinkedList linkedlist = new LinkedList();
    	for(int i=0;i<number.length();i++){
    		int num = Integer.parseInt(number.charAt(i)+"");
    		linkedlist.addAtEnd(num);
    	}
    	return linkedlist;
    }
    public static String digitsToNumber(LinkedList list) {
    	int listSize = list.getSize();
    	String str = "";
    	for(int i=0;i<listSize;i++){
    		str += list.getFirst();
    		list.removeAtStart();
    	}
    	return str;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	Stack stack1 = new Stack();
    	Stack stack2 = new Stack();
    	int carry = 0;
    	int size1 = list1.getSize();

    	int size2  = list2.getSize();
    	//System.out.println(size1 +"-"+ size2 );
    	LinkedList addition = new LinkedList();
    	if(size1 > size2){
    		//System.out.println("first if");
    		int diff = size1 - size2;
    		for(int i=0; i<diff;i++){
    			list2.addAtStart(0);
    		}
    	}
    	if(size2 > size1){
    		//System.out.println("second if");
    		int diff = size2 - size1;
    		for(int i=0; i<diff;i++){
    			list1.addAtStart(0);
    		}
    	}
    	System.out.println(list1.getSize() +"-"+ list2.getSize());
    	if(size1==size2){
    		for(int i=0;i<size1;i++){
    			stack1.push(list1.getFirst());
    			list1.removeAtStart();
    			stack2.push(list2.getFirst());
    			list2.removeAtStart();
    		}
    		for(int i =0;i<size1;i++){
    			int one = stack1.pop();
    			int two = stack2.pop();
    			int sum = one+two;
    			int temp = carry;
    			carry = (carry+sum)/10;
    			int add = (sum+temp)%10;
    			addition.addAtStart(add);
    		}
    		if(carry != 0){
    			addition.addAtStart(carry);
    		}

    	}
    	return addition;

    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
