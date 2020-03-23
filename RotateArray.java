
public class RotateArray {
	
	static int[][]  rotateArray(int [][] matrix){
		
		int N = matrix.length;
		int temp=0;
		for(int i=0; i < N; i++ ) {
			for(int j=i; j < N; j++) {
				 temp = matrix[i][j];
				 matrix[i][j] = matrix[j][i];
				 matrix[j][i] = temp;
			}
		}
		
		int left =0;
		int right = N;
		for(int i=0; i<N; i++) {
			left =0;
			right = N-1;
			while(left < right) {
				temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left++;
				right--;
			}
		}
		
		return matrix;
	}
	
	public static void main(String args[]) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("-----------------");
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		arr = rotateArray(arr);
		System.out.println("-------After Rotation----------");
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		
	}

}
