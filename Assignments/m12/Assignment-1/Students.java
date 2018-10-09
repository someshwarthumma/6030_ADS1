import java.util.*;
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

	public static Comparator<Students> comparator = new Comparator<Students>(){
		public int compare(Students s1, Students s2){
			if(s1.getTotal() - s2.getTotal() !=0){
				return s1.getTotal() - s2.getTotal();
			} else if(s1.getMarks1() - s2.getMarks1()  != 0){
				return s1.getMarks1() -s2.getMarks1() ;
			} else if(s1.getMarks2()  - s2.getMarks2() != 0){
				return s1.getMarks2()-s2.getMarks2();
			} else if(s1.getMarks3() - s2.getMarks3() != 0){
				return s1.getMarks3()-s2.getMarks3();
			} else if(s2.getYear() - s1.getYear() != 0){
				return s2.getYear()-s1.getYear();
			} else if(s2.getMonth() - s1.getMonth() != 0){
				return s2.getMonth()-s1.getMonth();
			} else if(s2.getDay() - s1.getDay() != 0){
				return s2.getDay()-s1.getDay();
			} else {
				return 0;
			}
		}
	};
}