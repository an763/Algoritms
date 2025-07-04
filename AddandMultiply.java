
public class AddandMultiply {
	
	// resize of smaller, result array size = larger +1 
	// carry = sum/10
	// result = sum % 10
	
	public static void main(String args[]) {
		int [] a = {9,9,3,4,5,6,7};
		int [] b = {9, 9,3,4,5,6,7};
		int [] result = add(a,b);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] +" , "); //  1, 9, 8,  6, 9 , 1 , 3, 4
		}
		System.out.println("----------");
		int [] a1 = {9,9,9};
		int [] b1 = {9,9,9};
		result = multiply(a1,b1);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] +" , ");
		}
		
	}
	
	public static int [] add(int a[], int b[]) {
		int [] larger = a.length > b.length ? a : b;
		int [] smaller = larger == a ? b : a;
		smaller = resize(smaller,larger.length);
		
		int [] result = new int[larger.length +1];
		int sum =0 , carry =0;
		for(int i=larger.length-1 ; i>=0; i--) {
			 sum = larger[i] + smaller[i] + carry;
			 carry = sum/10;
			 result[i+1] = sum % 10;
		}
		result[0] = carry;
		
		return result;
	}
	
	
	public static int [] resize(int [] a, int resize) {
		if(a.length == resize) return a;
		int [] resized = new int [resize];
		int index = resize-1;
		for(int i=a.length-1; i>=0; i--) {
			resized[index] = a[i];
			index--;
		}
		return resized;
	}
	
	public static int[] multiply(int [] a, int [] b) {		
		int [] result = {0};
		int zeroCount = 0;
		for(int i=a.length-1; i>=0; i--) {
			int [] p = new int[b.length +1 + zeroCount];
			int carry = 0;
			for(int j=b.length-1; j>=0; j--) {
				int prod = a[i] * b[j] + carry;
				carry = prod/10;
				p[j+1] = prod%10;
			}
			zeroCount++;
			p[0] = carry;
			result = add(p,result);
		}		
		return result;
	}
	

}
