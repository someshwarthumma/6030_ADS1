import java.util.Scanner;
import java.util.Arrays;
class Stack{
	char[] data;
	int size;
	Stack(){
		data = new char[20];
		size = 0;
	}
	public void push(char s){
		if(size == data.length){
			resize();
		}
		if(s == '('){
			data[size++] = ')';
		} else if(s == '['){
			data[size++] = ']';
		} else {
			data[size++] = '}';
		}
	}
	public char pop(){
		if(size == 0){
			return '0';
		}
		size--;
		return data[size];
	}
	public boolean isEmpty(){
		return size==0;
	}
	private void resize(){
		data = Arrays.copyOf(data , 2*data.length);
	}
	public void setSize(){
		this.size = 0; 
	}
}


public class Solution{
	public static void main(String[] args) {
		Stack stackObj = new Stack();
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for(int i=0;i<n;i++){
			boolean flag = true;
			char[] s = scan.nextLine().toCharArray();
			for(char each: s){
				if(stackObj.isEmpty()){
					if(each == ')' || each == '}' || each == ']'){
						System.out.println("NO");
						flag = false;
						break;
					}
				}
			if(each == '(' || each == '{' || each == '['){
				stackObj.push(each);
			}else{
				char ch = stackObj.pop();
				if(ch == '0'){
					System.out.println("NO");
					flag = false;
					break;
				}
				if(each != ch){
					stackObj.setSize();
					System.out.println("NO");
					flag = false;
					break;
				}
			}
			

		}
		if(flag){
			System.out.println("YES");
		}
			
		}
	}
}