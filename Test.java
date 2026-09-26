import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String args[]){
        isPalindrome(121);
        System.out.println("==> "+findSum(-9));
     //   int sum = calculate("1-1-1");
     //   System.out.println("Going to print "+sum);

   /*         for(int i = 2; i< 100; i++){
              //  System.out.println("Going to print");
                if(isPrime(i)){
                    if(i<=9){
                        System.out.println("The mirror number and mirror image is "+i);
                    }else{
                        int mirror = 10 * (i %10) + (i/10);
                        if(isPrime(mirror)){
                            System.out.println("The mirror number and mirror image is "+i +" mirror "+mirror);
                        }
                    }
                }
            }*/
    }

    private static int calculate(String str) {

        if (str.contains("+")) {
            String[] strsub = str.split("\\+", 2);
            return calculate(strsub[0]) + calculate(strsub[1]);
        } else if (str.contains("-")){
            String[] strsub = str.split("\\-", 2);
            return calculate(strsub[0]) - calculate(strsub[1]);
        } else if (str.contains("/")){
            String[] strsub = str.split("\\/", 2);
            return calculate(strsub[0])/calculate(strsub[1]);
        } else if (str.contains("*")){
            String[] strsub = str.split("\\*", 2);
            return calculate(strsub[0])*calculate(strsub[1]);
        }else{
            if(str == null || str.equals("")) return 0;
            return Integer.parseInt(str);
        }

    }
    // 1+2+3

    private static boolean isPrime(long number){
        long sqrt = Math.round(Math.sqrt(number));
        for(long i=2; i<=sqrt; i++){
            if(number % i == 0) return false;
        }

        return true;
    }

    public static boolean isPalindrome(int x) {
        int result = 0;
        if(x<0) return false;
        int y = x;
        int med= 0;
        while(y != 0){
            result = 10*result + y%10;
            y = y/10;
        }

        System.out.println("the resylt is "+result);
        if(x == result){
            return true;
        }
        return false;
    }

    public static int findSum(int n){
        if(n<0) return 0;
        if(n == 1) return 1;
        return n + findSum(n-1);
    }



}
