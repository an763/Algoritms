import java.util.*;

public class BackTrackMemoization {


    public static void main(String args[]) {


        System.out.println(findPower(2, 10));
        List<String> dictionary = new ArrayList<>();
        dictionary.add("i");
        dictionary.add("like");
   //     dictionary.add("man");
 //       dictionary.add("go");
  //      dictionary.add("tan");

     //   dictionary.add("sss");
    //    dictionary.add("ss");



        System.out.println(wordBreakCamp("ilikeman", dictionary));
     //   System.out.println(wordBreakCamp("sss", dictionary));


    }

    // find x^n using recursion and memoization
    public static int findPower(int x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        Map map = new HashMap();
        int result = findPowerMemoization(x, Math.abs(n), map);
        if (n < 0) {
            return 1 / result;
        }
        return result;
    }


    public static int findPowerMemoization(int x, int n, Map map) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (map.containsKey(n)) {
            return (int) map.get(n);
        }
        int result = 0;
        if (n % 2 == 0) {
            result = findPowerMemoization(x, n / 2, map) * findPowerMemoization(x, n / 2, map);
        } else {
            result = x * findPowerMemoization(x, n / 2, map) * findPowerMemoization(x, n / 2, map);
        }
        map.put(n, result);
        return result;
    }



    public static List<String> wordBreakCamp(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return null;
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        return wordBreakCamp(s, set);
    }



    public static List<String> wordBreakCamp(String s, HashSet<String> dictionary) {
        if (s == null || s.isEmpty()) return null;
        State[] memo = new State[s.length()];
        Arrays.fill(memo, State.UNVISITED);
        List<String> result = new ArrayList<String>();
        if (wordBreak(s, 0, memo, result, dictionary)) {
            return result;
        }
        return null;
    }

    public static boolean wordBreak(String s, int start, State[] memo, List<String> result, HashSet<String> dictionary) {
        if (start == s.length()) return true;
        if (memo[start] == State.NOT_FOUND) return false;
        for (int i = start; i < s.length(); i++) {
            String candidate = s.substring(start, i + 1);
            if (dictionary.contains(candidate)) {
                result.add(candidate);
                if (wordBreak(s, i + 1, memo, result, dictionary)) {
                    return true;
                } else {
                    result.remove(result.size() - 1); // remove candidate
                    memo[i + 1] = State.NOT_FOUND;
                }
            }
        }
        return false;
    }

    public enum State {UNVISITED, NOT_FOUND}



}



