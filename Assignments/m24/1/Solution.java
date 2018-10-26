import java.util.Scanner;
class Solution{
	public static void main(String[] args) {
		LinearProbingHashST<Integer, Student> hash = new LinearProbingHashST<Integer, Student>();
		Scanner scan = new Scanner(System.in);
		int totalStudents = Integer.parseInt(scan.nextLine());
		for(int i =0 ; i< totalStudents; i++){
			String[] tokens = scan.nextLine().split(",");
			hash.put(Integer.parseInt(tokens[0]), new Student(tokens[1], Double.parseDouble(tokens[2])));
		}
		int totalTestsCases = Integer.parseInt(scan.nextLine());
		while(scan.hasNext()){
			String[] tokens2 = scan.nextLine().split(" ");
			Student temp = hash.get(Integer.parseInt(tokens2[1]));
			if(temp == null){
				System.out.println("Student doesn't exists...");
			}
			switch(tokens2[2]){
				case "1":
					System.out.println(temp.getName());
					break;
				case "2":
					System.out.println(temp.getMarks());
					break;
			}
		}
	}
}
class Student{
	String name;
	Double marks;
	Student(String n, Double rN){
		this.marks = rN;
		this.name = n;
	}

	public String getName(){
		return this.name;
	}

	public Double getMarks(){
		return this.marks;
	} 
}