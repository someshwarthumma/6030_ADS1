import java.util.Arrays;
public class Ranking {

	Students[] studentArray;
	Sorting sortObj;
	int size;
	Ranking(){
		studentArray = new Students[10];
		sortObj = new Sorting();
		size = 0;
	}

	public void add(Students s){
		if(size == studentArray.length){
			resize();
		}
		studentArray[size++] = s;
	}

	private void resize(){
		studentArray = Arrays.copyOf(studentArray, 2*studentArray.length);
	}


	public void printMerit(){
		sortObj.sort(studentArray);
		for(int i=0;i<size;i++){
			System.out.println(studentArray[i].getName()+","+studentArray[i].getTotal()+","+studentArray[i].getReservation());
		}

	}

	public void printResult(){

	}
}