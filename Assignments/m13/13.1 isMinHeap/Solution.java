import java.util.Scanner;
import java.util.Arrays;
import java.lang.Comparable;
class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String dataType = scan.nextLine();
		int noOfTestCases = Integer.parseInt(scan.nextLine());
		Check checkObj = new Check();
		switch(dataType){
			case "String":
				while(scan.hasNext()){
					String[] array = scan.nextLine().split(",");
					String[] strArr = new String[array.length+1];
					//System.out.println(Arrays.toString(stringArray));
					int j =0;
					for(int i=1;i<=array.length;i++){
						strArr[i] = array[j];
						j++;
					}
					//System.out.println(Arrays.toString(strArr));
					System.out.println(checkObj.check(strArr));
				}
				break;
			case "Integer":
				while(scan.hasNext()){
					String[] array = scan.nextLine().split(",");
					Integer[] intArr = new Integer[array.length+1];
					int j =0;
					for(int i=1;i<=array.length;i++){
						intArr[i] = Integer.parseInt(array[j]);
						j++;
					}
					System.out.println(checkObj.check(intArr));
				}
				break;
			case "Double":
				while(scan.hasNext()){
					String[] array = scan.nextLine().split(",");
					Double[] doubleArr = new Double[array.length+1];
					int j =0;
					for(int i=1;i<=array.length;i++){
						doubleArr[i] = Double.parseDouble(array[j]);
						j++;
					}
					System.out.println(checkObj.check(doubleArr));
				}
				break;
			case "Float":
				for(int k =0;k<noOfTestCases;k++){
					String array1 = scan.nextLine();
					if(array1.length()==0){
						System.out.println("false");
						break;
					}
					String[] array = array1.split(",");
					Float[] floatArr = new Float[array.length+1];
					int j =0;
					for(int i=1;i<=array.length;i++){
						floatArr[i] = Float.parseFloat(array[j]);
						j++;
					}
					System.out.println(checkObj.check(floatArr));
				}
				break;
		}
	}
}

class Check<E extends Comparable<E>>{ 

	public boolean check(E[] arr){
		int n=arr.length;
		for(int i=n-1;i>1;i--){
			if(arr[i].compareTo(arr[i/2]) < 0){
				return false;
			}
		}
		return true;
	}
}