import java.util.Scanner;
import java.util.Arrays;
public class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int oneLen = Integer.parseInt(scan.nextLine());
		int secLen = Integer.parseInt(scan.nextLine());
		String[] arrOne = scan.nextLine().split(",");
		String[] arrSec = scan.nextLine().split(",");
		int[] firstArray = new int[oneLen];
		int[] secondArray = new int[secLen];
		for(int i=0;i<oneLen;i++){
			firstArray[i] = Integer.parseInt(arrOne[i]);
		}
		for(int i=0;i<secLen;i++){
			secondArray[i] = Integer.parseInt(arrSec[i]);
		}
		int[] sortedArray = new int[oneLen+secLen];
		int i = 0;
		int j = 0;
		int index = 0;
		while(i<oneLen && j< secLen){
			if(firstArray[i]<secondArray[j]){
				sortedArray[index] = firstArray[i];
				i++;
			} else {
				sortedArray[index] = secondArray[j];
				j++;
			}
			index++;
		}
		while(i<oneLen){
			sortedArray[index++] = firstArray[i];
			i++;
		}
		while(j<secLen){
			sortedArray[index++] = secondArray[j];
			j++;
		}
	}

public void print(int[] sortedArray){
	String temp = "";
	for(int i=0;i<sortedArray.length-1;i++){
		temp += sortedArray[i];
	}
	temp += sortedArray[sortedArray.length-1];
	System.out.println(temp);

}
}