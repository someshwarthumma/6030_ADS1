import java.util.Scanner;
import java.util.*;
// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
class Percolation {
	int size;
	int end;
	int start;
	boolean[][] grid;
	WeightedQuickUnionUF unionObj;
	public Percolation(int n){
		end = n*n+1;
		start = n*n;
		size = n;
		grid = new boolean[n][n];
		unionObj = new WeightedQuickUnionUF(n*n+2);
		for(int i =0;i<n;i++){
			for(int j=0;j<n;j++){
				grid[i][j]=false;
			} 
		}
	}                
	public void open(int row, int col){
		if(grid[row][col]){
			return;
		}
		grid[row][col] = false;

		if(row == 0){
			unionObj.union(start, getIndex(row,col));
		}
		if(row == size-1){
			unionObj.union(end, getIndex(row,col));
		}
		if(row-1 >= 0 && isOpen(row-1,col)){
			unionObj.union(getIndex(row-1,col), getIndex(row, col));
		}
		if(row + 1 < size && isOpen(row+1 , col)){
			unionObj.union(getIndex(row+1, col), getIndex(row , col));
		}
		if(col-1 >=0 && isOpen(row , col-1)){
			unionObj.union(getIndex(row, col-1), getIndex(row, col));
		}
		if(col +1 < size && isOpen(row , col+1)){
			unionObj.union(getIndex(row , col+1), getIndex(row , col));
		}
		
	}
	private int getIndex(int row,int col){
		return row*size+col;
	}

	public boolean isOpen(int row, int col){
		return grid[row][col];
	}

	//public boolean isFull(int row, int col)  
	//public int numberOfOpenSites()       
	public boolean percolates(){
		return unionObj.connected(end , start);
	}              
}
public class Solution {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Percolation percolationObj = new Percolation(Integer.parseInt(scan.nextLine()));
		while(scan.hasNext()){
			String[] input = scan.nextLine().split(" ");
			//System.out.println(Arrays.toString(input));
			percolationObj.open(Integer.parseInt(input[0])-1,Integer.parseInt(input[1])-1);
		}
		System.out.println(percolationObj.percolates());
		 
	}
}