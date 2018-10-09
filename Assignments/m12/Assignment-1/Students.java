//import java.util.*;
class Students{
	private String name;
	private String dateOfBirth;
	private int marks1;
	private int marks2;
	private int marks3;
	private int total;
	private String reservation;
	Students(String n, String dob, int m1, int m2, int m3, int t, String resrv){
		this.name = n;
		this.dateOfBirth = dob;
		this.marks1 = m1;
		this.marks2 = m2;
		this.marks3 = m3;
		this.total = t;
		this.reservation = resrv;
	}

	public String getName(){
		return name;
	}
	public String getDOB(){
		return dateOfBirth;
	}
	public int getMarks1(){
		return marks1;
	}
	public int getMarks2(){
		return marks2;
	}
	public int getMarks3(){
		return marks3;
	}
	public int getTotal(){
		return total;
	}
	public String getReservation(){
		return reservation;
	}

	public int getYear(){
		return  Integer.parseInt(dateOfBirth.split("-")[2]);
	}
	public int getMonth(){
		return  Integer.parseInt(dateOfBirth.split("-")[1]);
	}

	public int getDay(){
		return  Integer.parseInt(dateOfBirth.split("-")[0]);
	}

	//public static Comparator<Students> comparator = new Comparator<Students>(){
	public int compareTo(Students s2){
		if(this.getTotal() - s2.getTotal() !=0){   
			return this.getTotal() - s2.getTotal();
		} else if(this.getMarks3() - s2.getMarks3()  != 0){
			return this.getMarks3() -s2.getMarks3() ;
		} else if(this.getMarks2()  - s2.getMarks2() != 0){
			return this.getMarks2()-s2.getMarks2();
		} else if(s2.getYear() - this.getYear() != 0){
			return s2.getYear()-this.getYear();
		} else if(s2.getMonth() - this.getMonth() != 0){
			return s2.getMonth()-this.getMonth();
		} else if(s2.getDay() - this.getDay() != 0){
			return s2.getDay()-this.getDay();
		} else {
			return 0;
		}
	}
	
}