import java.util.ArrayList;
import java.util.List;

public class BrailToEng {
	
	
	private static int [][] arr= {{1,1,1,0,0,1},{0,0,0,0,1,1},{0,0,0,0,1,0}};
	
	public static void main(String args[]) {
		System.out.println("The size of row :: "+arr.length);
		System.out.println("The size of column :: "+arr[0].length);
		int [] arr2= {1,2,3,4};
		int index=0;
		System.out.println("The index:: "+arr2[index++] +"   "+index);
		System.out.println("The index:: "+"   "+ ++index);
		int colsize = arr[0].length;
		List<int[][]> lst = new ArrayList<>();
		for(int k=0; k< colsize; k=k+2) {
			int[][] arr1 = new int[3][2];
			int row =0; 
			for(int i=0; i<=2; i++) {				
				int col=0;
				for(int j=k; j<k+2; j++) {
					arr1[row][col++] = arr[i][j];
				}
				row++;
			}
			lst.add(arr1);
		}

		System.out.print(lst);
	}
	
							
	

}
