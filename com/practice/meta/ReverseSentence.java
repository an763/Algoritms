package com.practice.meta;

public class ReverseSentence {


    public static String reverseSentenceWithSpacesTrimmed(String s){
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int endPointer = s.length();

        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                if(s.charAt(i+1) != ' '){
                    sb.append(s.substring(i+1,endPointer));
                    sb.append(' ');
                }
                endPointer = i;
            }
        }
        sb.append(s.substring(0,endPointer));
        return sb.toString();


    }



    public static void main(String args[]) {
        String sentence = reverseSentenceWithSpacesTrimmed("My name    is Anurag");
        System.out.println("Length after reverseSentence :"+sentence.length());
        System.out.println(sentence);

        sentence = reverseSentenceWithSpacesTrimmed("My name is Anurag");
        System.out.println("Length after reverseSentence :"+sentence.length());
        System.out.println(sentence);
    }

}
