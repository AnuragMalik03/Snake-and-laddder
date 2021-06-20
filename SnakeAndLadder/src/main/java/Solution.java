package main.java;

import java.util.ArrayList;

//optimise this...
public class Solution{
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args){
        generateSubSeq("ABEDEEEF" ,"");
        System.out.println(longestPalindrome(list));
    }

    public static void generateSubSeq(String s, String ans){

        if(s.length() == 0){
            list.add(ans);
            return;
        }
        
        generateSubSeq(s.substring(1), ans+s.charAt(0));

        generateSubSeq(s.substring(1), ans);
    }

    public static String longestPalindrome(ArrayList<String> list){
        String ans = "";
        for(int i =0; i < list.size() ; i++){
            //System.out.println(list.get(i));
            if(isPalindrome(list.get(i)) && ans.length() < list.get(i).length()){
                ans = list.get(i);
            }
        }

        return ans;
    }

    public static boolean isPalindrome(String str){
        int i =0;
        int j = str.length()-1;

        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}
