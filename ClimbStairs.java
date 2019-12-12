import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
	
	
	Map<Integer, Integer> cache = new HashMap<>();
    
	public int climbStairs(int n) {
        if(cache.containsKey(n)) {
			return cache.get(n);
		}
		if(n < 4) {
			cache.put(n, n);
			return n;
		}else {
			int fibVal = climbStairs(n-1) + climbStairs(n-2);
			cache.put(n, fibVal);
			return fibVal;
		}
            
    }
	
	public int climbStairsOpt(int n) {
		int [] steps = new int[n+1];
		
		if(n<4) return n;
		
		steps[0] = 1;
		steps[1] = 1;
		steps[2] = 2;
		steps[3] = 3;
		
		for(int i=4; i<=n; i++) {
			steps[i] =steps[i-1] + steps[i-2];
		}
		return steps[n];
	}

}
