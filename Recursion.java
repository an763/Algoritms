
public class Recursion {
	
	public static void main(String args[])
	{
		int a [] = {0,1,2,3,4, 5,9};
		int sum  = findSumOfEvenIndices(a);
		System.out.println("The sum of even numbers :"+sum);
		
		String s = "Anurag";
		
		System.out.println("The revesed :"+reverseString(s));
		
		String s1 = "Anurag";
		
		System.out.println("The revesed swap :"+reverseStringSwap(s1));
	}
	
	public static int findSumOfEvenIndices(int [] a) {
		return sumEvenIndices(a,a.length - 1);
	}
	
	public static int sumEvenIndices(int [] a,int index) {
		if(index < 0) {
			return 0;
		}
		
		if(index %2==0) {
			return sumEvenIndices(a,index-1) + a[index];
		}else {
			return sumEvenIndices(a,index-1);
		}
	}
	
	public static String reverseString(String s) {
		String reversed = reverseRecurse(s, 0);
		return reversed;
	}
	
	public static String reverseStringSwap(String s) {		
		reverseRecurseSwap(s,0,s.length()-1);
		return s;
	}
	
	public static String reverseRecurse(String s, int i) {
		if(i==s.length()) {
			return "";
		}
		
		return reverseRecurse(s,i+1) + s.charAt(i);
	}
	
	public static void reverseRecurseSwap(String s, int i, int j) {
		if(i==j || i > j) {
			return ;
		}
		char arr [] = s.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		reverseRecurseSwap(arr.toString(), i+1,j-1);
	}
	
	
	

}
