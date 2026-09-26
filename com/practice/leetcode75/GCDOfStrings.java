package com.practice.leetcode75;

public class GCDOfStrings {

    public String gcdOfStrings(String str1, String str2) {
       if(!(str1+str2).equals(str2+str1)) return "";
       int gcdLength = gcd(str1.length(), str2.length());
       return str2.substring(0,gcdLength);
    }

    private int gcd(int len1, int len2){
        while(len2 != 0){
            int temp = len1 % len2;
            len1 = len2;
            len2 = temp;
        }
        return len1;
    }


    /**
     *  even = if length > 2 => break into two and check if they are equal => this is the common
     *         if length = 2 => check if both are same character => and then concatenate and compare
     *         if not same , just concatenate and chekc if two are equal
     */


}
