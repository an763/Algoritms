import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Test 
public class Anagrams {
    static boolean isAnagram(String a, String b) {
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> sec = new HashMap<>();
      
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] firstArr = a.toCharArray();
        char[] secArr = b.toCharArray();
        
        for(int i=0; i< firstArr.length; i++){
        int val =  (first.get(firstArr[i]) != null) ? (first.get(firstArr[i]) +1) : 1; 
            first.put(firstArr[i], val );            
        }
        for(int i=0; i< secArr.length; i++){
        int val =  (sec.get(secArr[i]) != null) ? (sec.get(secArr[i]) +1) : 1; 
            sec.put(secArr[i], val );            
        }
        if(first.size() == sec.size()){
            for(Map.Entry<Character, Integer> entry : first.entrySet() ){
                if(sec.get(entry.getKey()) != entry.getValue()){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
     }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        
        String s = "anurag";
        
        for(int i=0; i<s.length(); i++) {
        	int j = s.charAt(i) - 'a';
        	System.out.println("he val of s.charAt(i) - 'a' " + j );
        }
        
        String s1 = "ANURAG";
        
        for(int i=0; i<s1.length(); i++) {
        	int j = s1.charAt(i) - 'a';
        	System.out.println("he val of s1.charAt(i) - 'a' " + j );
        }
    }
}