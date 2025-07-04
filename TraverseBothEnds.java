

public class TraverseBothEnds {
	
	// reverse : A = [1,2,3,4,5,6], Output = [6,5,4,3,2,1]
	
	public static void reverse(int a[]) {
		int i=0; int j=a.length-1;
		int temp = 0;
		while(i<j) {
			 temp = a[i];
			 a[i] = a[j];
			 a[j] = temp;
			 i++; j--;
		}
	}
	
	public static void main(String args[]) {
		int a[] = {1,2,4,5,6};
		reverse(a);
		for(int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		reverse(a);
		findIndices(a,9);
	}
	
	// Two Sum - Sorted Array
	public static void findIndices(int a[], int sum) {
		int i=0;
		int j=a.length-1;
		while(i<j) {
			if(a[i] + a[j] == sum) {
				System.out.println("The indices for sum "+sum +" are :: "+i +" and "+j);
				break;
			}else if(a[i] + a[j] < sum) {
				i++;
			}else {
				j--;
			}
		}
		if(i==j || i>j) {
			System.out.println("No elements found with sum "+sum);
		}
	}
	
}
