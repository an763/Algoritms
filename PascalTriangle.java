import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
	
	
	public static void main(String args[]) {
		System.out.println("The 5,3 element of Pascal's Triangle is ::"+getPascalIJthElement(5,3));
		
		
		
			System.out.println("The Nth Row of Pascal's Triangle is :: "+getNthRowOfPascalTriangle(4));
			
			System.out.println("The Nth Row of Pascal's Triangle Optimized is :: "+getNthRowOfPascalTriangleOptimized(4));
		
		List<List<Integer>> nthRow = generate(5);
		
		for(int i=0; i<5; i++)
		System.out.println("The Nth Row of Pascal's Triangle is :: "+nthRow.get(i));
		
		int [][] pascalTriangle = getFirstNRowsPascalTriangle(5);
		// to get nth row of Pascal's triangle 
		for(int line=0; line<5; line++) {
			for(int col =0; col<=line; col++) {
				System.out.print(pascalTriangle[line][col] +",");
			}
			System.out.println("-----");
		}
		
		nthRow = getFirstNRowsPascalTrianglewITHIST(5);
		
		for(int i=0; i<5; i++)
		System.out.println("The Nth Row of Pascal's Triangle is :: "+nthRow.get(i));
		
			
	}
	
	
	public static int getPascalIJthElement(int i, int j) {		
		if((i==j) || (j==1)) return 1;		
		return getPascalIJthElement(i-1,j-1) + getPascalIJthElement(i-1,j);
	}
	
	public static List<List<Integer>>  generate(int numRows){
		List<List<Integer>> pascalTriangleRows = new ArrayList<List<Integer>>();		
		for(int i=1; i<numRows+1; i++) {
			pascalTriangleRows.add(getNthRowOfPascalTriangle(i));
		}
		return pascalTriangleRows;
	}
	
	public static List<Integer> getNthRowOfPascalTriangle(int n){
		List<Integer> list = new ArrayList<>();		
		for(int i=1; i<n+1; i++) {
			list.add(getPascalIJthElement(n,i));
		}		
		return list;
	}
	
	
	
	public static int[][] getFirstNRowsPascalTriangle(int numRows){
		int [][] pascalTriangle = new int[numRows][numRows];
		
		for(int line=0; line < numRows  ; line++) {
			for(int col =0 ; col<= line ; col++) {
				if(col == 0 || col == line ) {
					pascalTriangle[line][col] = 1;
				}else {
					pascalTriangle[line][col]= pascalTriangle[line-1][col-1] + pascalTriangle[line-1][col];
				}
				
			}
		}
		
		return pascalTriangle;
	}
	
	public static List<List<Integer>> getFirstNRowsPascalTrianglewITHIST(int numRows){
		List<List<Integer>> pascalTriangleRowsList = new ArrayList<List<Integer>>(numRows);
		
		for(int line=0; line < numRows  ; line++) {
			List<Integer> traiangleRow = new ArrayList<>(line+1);	
			for(int col =0 ; col<= line ; col++) {
				if(col == 0 || col == line ) {
					traiangleRow.add(1);
				}else {
					traiangleRow.add(pascalTriangleRowsList.get(line-1).get(col-1) + pascalTriangleRowsList.get(line-1).get(col));
				}
				
			}
			pascalTriangleRowsList.add(traiangleRow);
		}
		
		return pascalTriangleRowsList;
	}
	
	
public static List<Integer> getNthRowOfPascalTriangleOptimized(int n){
		
		if(n==0){
			return new LinkedList<Integer>(Arrays.asList(1));
		}else{
			List<Integer> prev = getNthRowOfPascalTriangleOptimized(n-1);
			List<Integer> curr = new LinkedList<>();
			
			for(int i=0; i<=prev.size(); i++) {
				if(i == 0 || i==prev.size()) {
					curr.add(1);
				}else {
					curr.add(prev.get(i) + prev.get(i-1));
				}
			}
			return curr;
		}				
		
	}
	
	

}
