

public class MoveZeros {
	
	public static void main(String args[]) {
		int a[] = {1,0,4,5,8,7,9,0,10,0,0};
		moveZerosTOEnd(a);
		for(int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void moveZerosTOEnd(int[] a) {
		int tracker = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i] != 0) {
				a[tracker] = a[i];
				tracker++;
			}
		}
		for(int j=tracker; j<a.length; j++) {
			a[j] =0;
		}
	}
	
	
	public static void moveZeros(int a[]) {
		int moving = a.length-1;
		int zeroCounter = a.length-1;
		while(moving >=0) {
			if(a[moving] == 0) {
				if(moving != a.length-1) {
					swap(a,moving,zeroCounter);
					swapTillZero(a,moving);
					zeroCounter--;
				}
			}
			moving--;
		}
	}
	
	private static void swapTillZero(int a[], int start) {
		while(a[start+1] != 0) {
			int temp = a[start];
			a[start] = a[start+1];
			a[start+1] = temp;
			start++;
		}
	}
	
	private static void swap(int a[], int i, int j) {	
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;		
	}

}
