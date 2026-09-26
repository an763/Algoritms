package com.practice.leetcode75;

public class StringCompression {

    public int compress(char[] chars) {
        char currentChar = ' ';
        int count = 0;
        int write = 0;
        for(char c : chars){
            if(c == currentChar){
                count++;
            }else{
                if(currentChar == ' '){
                    chars[write++]=c;
                    currentChar = c;
                    count++;
                }else{
                    if (count > 1) {
                        for (char c1 : String.valueOf(count).toCharArray()) {
                            chars[write++] = c1;
                        }
                    }
                    chars[write++] = c;
                    currentChar = c;
                    count=1;
                }
            }
        }
        if (count > 1) {
            for (char c1 : String.valueOf(count).toCharArray()) {
                chars[write++] = c1;
            }
        }
        return write;
    }
}
