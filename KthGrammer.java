
public class KthGrammer {
	
	 public static int kthGrammar(int N, int K) {
	        if(Math.pow(2,N) < K){return 0;}
	        int count = 0;
	        K--;
	        while(K!=0){
	            count += K%2;
	            K/=2;
	        }
	        return (count%2 == 0)?0:1;
	    }
	 
	 public static int kthGrammarSecond(int N, int K) {
	        if(Math.pow(2,N) < K){return 0;}
	        
	        int rowSize = (int)Math.pow(2, N-1);
	        int flips = 0;
	        
	        while(rowSize > 2) {
	        	if(K>rowSize/2) {
	        		K = K - rowSize/2;
	        		flips++;
	        	}
	        	rowSize = rowSize/2;	        	
	        }
	        K--;
	        
	       return (flips%2 == 0) ?K : (1-K);        
	      
	    }
	
	public static String getRow(int n) {
		
		if(n==1) return "0";		
		String arr = getRow(n-1);
		StringBuffer s = new StringBuffer();
		for(int i=0; i<arr.length(); i++) {
			if(arr.charAt(i) == '0') {
				s.append("01");
			}else {
				s.append("10");
			}
		}		
		return s.toString();
	}
	
	public static void main(String args[]) {
		//0
		//01
		//0110
		//01101001
		
		System.out.println("The nth row .... "+getRow(10).charAt(6));
		
		System.out.println("The nth row .... "+kthGrammar(10,7));
		
		System.out.println("The nth row second .... "+kthGrammarSecond(10, 7));
		
	}

}
