import java.util.Scanner; 
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		while(s.hasNext()){
			int num = Integer.parseInt(s.nextLine());
			QuickSort quickObj = new QuickSort(num);
			String[] tokens = s.nextLine().split(" ");
			if(tokens[0].length()==0){
				System.out.println("[]");
			} else {
				quickObj.sort(tokens);
				System.out.println(quickObj.toString(tokens));
			}
		}
	}
}

class QuickSort {
	private int cutOff;
	private Insertion insertObj;
	QuickSort(int num){
		cutOff = num;
		insertObj = new Insertion();
	}

	public void sort(Comparable[] array){
		sort(array, 0, array.length-1);
	}

	public void sort(Comparable[] array , int lo, int hi){
			int n = hi-lo+1;
			if(n<=cutOff){
				insertObj.sort(array , lo, hi);
				System.out.println("insertionSort called");
				return;
			}
			int j = partition(array, lo, hi);
			sort(array, lo, j-1);
			sort(array, j+1, hi);
	}

	public int partition( Comparable[] array, int low, int high){
		int i = low;
		int j = high+1;
		Comparable v = array[low];
		while(true){
			while(less(array[++i], v)){
				if(i==high){
					break;
				}
			}
			while(less(v, array[--j])){
				if(j == low){
					break;
				}
			}
			if(i>=j){
				break;
			}
			exchange(array, i, j);
		}
		exchange(array, low, j);
		System.out.println((toString(array)));
		return j;

	}

	public static boolean less(Comparable one,Comparable two){
		return one.compareTo(two)<0;
	}

	public static void exchange(Comparable[] array, int i, int j){
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static String toString(Comparable[] array){
		String str = "[";
		int i;
		for(i =0;i<array.length-1;i++){
			str += array[i]+ ", ";	
		}
		return str + array[i] +"]";
	}
}

class Insertion{
	public void sort( Comparable[] a, int lo, int hi){
		for(int i=lo;i<=hi;i++){
			for(int j=i; j>lo && lesser(a[j],a[j-1]);j--){
				exchange(a,j,j-1);
			}
		}
	}

	public void exchange(Comparable[] a, int i,int j){
		Comparable temp = a[i];
		a[i]=a[j];
		a[j] = temp;
	}

	public boolean lesser(Comparable one, Comparable two){
		return one.compareTo(two)<0;
	}
}