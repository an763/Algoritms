import java.util.*;

public class AnagramChecker {
    public boolean areAnagrams(String first , String second){
        if(first == null || second == null) return false;
         first = first.toLowerCase().replaceAll("[^a-z]", "");
         second = second.toLowerCase().replaceAll("[^a-z]", "");
        if(first.length() != second.length()){
            return false;
        }

        char[] arrFirst = first.toCharArray();
        Arrays.sort(arrFirst);
        char[] arrSecond = second.toCharArray();
        Arrays.sort(arrSecond);

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };


        return Arrays.equals(arrFirst,arrSecond);

    }


    public boolean areAnagramsSecond(String first, String second){
        if(first == null || second == null) return false;
        first = first.toLowerCase().replaceAll("[^a-z]","");
        second = second.toLowerCase().replaceAll("[^a-z]","");

        int count[] = new int[26];
        for (int i= 0; i<first.length(); i++){
            count[first.charAt(i) - 'a']++;
            count[second.charAt(i) - 'a']--;
        }

        for (int i= 0; i<count.length; i++){
            if(count[i] != 0);
            return false;
        }
        return true;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for (int count : map.values()) {
            if (count != 0) return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
