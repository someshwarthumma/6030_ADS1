import java.util.Scanner;
import java.util.Arrays;
class ThreeSum {
    int[] givenArray;
    int size = 0;
    int counter = 0;
    ThreeSum(int size) {
        givenArray = new int[size];
    }
    public void add(int element) {
        givenArray[size++] = element;
    }

    public void threesum() {
        Arrays.sort(givenArray);
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                int k = Arrays.binarySearch(givenArray, -(givenArray[i] + givenArray[j]));
                if (k > j) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = scan.nextInt();
        ThreeSum threeSumObj = new ThreeSum(inputs);
        for (int i = 0; i < inputs; i++) {
            threeSumObj.add(scan.nextInt());
        }
        threeSumObj.threesum();
    }
}


