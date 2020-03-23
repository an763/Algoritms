
public class Search2DMatrix {
	
	 public static boolean searchMatrix(int[][] matrix, int target) {
		  if(matrix==null || matrix.length==0) return false;
	        int l=matrix.length;
	        int j=matrix[0].length-1;
	        int i= 0;
	        while(i< l && j>=0){
	            while( (i< l && j>=0) && matrix[i][j] >= target){
	                if(matrix[i][j] == target) return true;
	                j--;
	            }
	            while( (i< l && j>=0) && matrix[i][j] <= target ){
	                if(matrix[i][j] == target) return true;
	                i++;
	            }
	        }
	        return false;
	    }
	 
	 public static void main(String args[]) {
		 int [][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		 int [][] sec = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		 int[][] third = {{-5}};
		 boolean ans = searchMatrix(arr,21);
		 System.out.println("The Ans is :: "+ans);
		 
	 }

}
