

public class ReverseSentence {
	
	// e.g => My name is Anurag
	// output => Anurag is name My
	
	public static String reverseSentence(String sentence) {		
		StringBuilder builder = new StringBuilder();
		int endIndex = sentence.length();
		for(int i= sentence.length() -1 ; i>0; i--) {			
			if(sentence.charAt(i) == ' ') {
				builder.append(sentence.substring(i+1, endIndex));
				endIndex = i;
				builder.append(' ');
			}
		}
		
		builder.append(sentence.substring(0, endIndex));
		return builder.toString();
	}
	
	public static void main(String args[]) {
		String sentence = reverseSentence("My name is Anurag");
		System.out.println("Length after reverseSentence :"+sentence.length());
		System.out.println(sentence);
		
		sentence = reverseDifferent("My name is Anurag");
		System.out.println("Length after reverseSentence :"+sentence.length());
		System.out.println(sentence);
	}
	
	
	public static String reverseDifferent(String sentence) {		
		char [] arr = sentence.toCharArray();
		int start = 0; int end = arr.length-1;
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
		start = 0;  end =0;
		for(int i= 0; i< arr.length;i++) {
			if(arr[i] == ' ' || i== arr.length-1) {				
				end = i-1;
				if(i== arr.length-1) end =i;
				while(start < end) {
					swap(arr, start,end);
					start++;
					end--;
				}
				start = i+1;
			}
			
		}
		String s = new String(arr);
		return s;
	}
	
	private static void swap(char [] arr , int i, int j) {
		char temp = arr[i] ;
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
