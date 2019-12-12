
public class FactorialAndPower {
	
	
	
	public static int fact(int n) {
		if(n==0) return 1;
		
		return n * fact(n-1);
	}
	
	public static void main(String args[]) {
		System.out.println("The factorial of 5 :: "+fact(5));
		System.out.println("The factorial of 6 :: "+fact(6));
		
		System.out.println("The tail factorial of 5 :: "+tailFact(5,1));
		System.out.println("The factorial of 6 :: "+tailFact(6,1));
		
		
		System.out.println("The pow 2 of 10 :: "+pow(2,10));
		System.out.println("The pow 2 of -2 :: "+pow(2,-2));
		
		System.out.println("The tail pow 2 of 10  :: "+tailPow(2,10,1));
		System.out.println("The tail pow 2 of -2 :: "+tailPow(2,-2,1));
		
		
		float x = 2; 
        int y = 3; 
        System.out.printf("%f", power(x, y));
	}
	
	public static int tailFact(int n, int a) {
		if(n==0) return a;
		
		return tailFact(n-1, n*a);
	}
	
	public static double pow(double x, int n) {
		if(n==0) return 1;
		
		if(n < 0) {
			return (1/x) * pow(x,n+1)  ;
		}else {
			return  (x)* pow(x,n-1) ;
		}
	}
	
	
	public static double tailPow(double x, int n, double inter) {
		if(n==0) return inter;
		
		if(n < 0) {
			return tailPow(x,n+1, (inter/(x)));
		}else {
			return tailPow(x,n-1, x*inter);
		}
	}
	
	static float power(float x, int y) 
    { 
        float temp; 
        if( y == 0) 
            return 1; 
        temp = power(x, y/2);  
          
        if (y%2 == 0) 
            return temp*temp; 
        else
        { 
            if(y > 0) 
                return x * temp * temp; 
            else
                return (temp * temp) / x; 
        } 
    }  

}
