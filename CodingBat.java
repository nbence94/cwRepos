/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractteszt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author BenZe
 */
public class CodingBat {
    public static void main(String[] args) {
        
        System.out.println("EveryNth: " + everyNth("abcdefg", 3));
        System.out.println("countXX: " + countXX("abcxx"));
        
        String test3 = "xaxx";
        System.out.println("DoubleX: " + test3 + " -> " + doubleX(test3));
        
        String test4 = "Hello";
        System.out.println("StringBits: " + test4 + " -> " + stringBits(test4));
        
         String test5 = "Code";
        System.out.println("stringSplosion: " + test5 + " -> " + stringSplosion(test5));       
        
         String test6 = "xaxxaxaxx";
        System.out.println("last2: " + test6 + " -> " + last2(test6));        
        
        String test7 = "xxcaazz", test8 = "xxbaaz";
        //String test7 = "abc", test8 = "abc";
        System.out.println("stringMatch: " + test7 + "/" + test8 + " -> " + stringMatch(test7, test8));         
 
        String test10 = "3,3,6,7,9";
        System.out.println("scoresClump: " + test10 + " -> " + scoresClump(new int[] {3,3,6,7,9}));
        
        System.out.println();
    }
    
    public static String everyNth(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i += n) {
            sb.append(String.valueOf(str.charAt(i)));
        }
        return sb.toString();
}
    
    public String startOz(String str) {
       String result = "";
       if(str.charAt(0) == 'o' && str.length() >= 1) result += "o";
       if(str.charAt(1) == 'z' && str.length() >= 2) result += "z";
       return result;
   }
   
   public String stringTimes(String str, int n) {
       String result = "";
       for(int i = 0; i < n; i++) {
           result += str;
       }
       return result;
    }
   
    public String frontTimes(String str, int n) {
        String result = "";
        if(str.length() >= 3)
            for(int i = 0; i < n; i++)
                result += str.substring(0,3);
        else 
            for(int i = 0; i < n; i++) result += str;
        return result;
    }  
    
    public static int countXX(String str) {
        int count = 0;
        for(int i = 0 ; i < str.length()-1; i++) {
            if(str.substring(i, i+2).equals("xx")) count++;
        }
        return count;
    }  
    
    public static boolean doubleX(String str) {
    for(int i = 0; i < str.length()-1; i++) {
        if(str.charAt(i) == 'x' && str.charAt(i+1) == 'x'){
            return true;
        }
        if(str.charAt(i) == 'x' && str.charAt(i+1) != 'x'){
            return false;
        }
    }
        return false;
    }
    
    public static String stringBits(String str) {
        String result = "";
        for(int i = 0; i < str.length(); i+=2){
            result += str.charAt(i);
        }
        return result;
    }

    public static String stringSplosion(String str) {
        String result = "";
        for(int i = 0; i <= str.length(); i++){
            result += str.substring(0,i);
        }    
        return result;
    }
    
    public static int last2(String str) {
        int count = 0;
        for(int i = 0; i < str.length()-2; i++){
            if(str.substring(i, i+2).equals(str.substring(str.length()-2, str.length()))) count++;
        }
        return count;
    }

    public static boolean arrayFront9(int[] nums) {
        int hossz = 0;
        if(nums.length >= 4) hossz = 4;
        else hossz = nums.length;
        
        for(int i = 0; i < hossz; i++) {
            if(nums[i] == 9) return true;
        }
        
        return false;
    }

    public static boolean array123(int[] nums) {
        String yes = "";
        for(int i = 0; i < nums.length; i++){
            yes += nums[i];
        }
        for(int i = 0; i < yes.length()-3; i++){
            if(yes.charAt(i) == '1')
            {
                if(yes.substring(i, i+3).equals("123")) return true;
            }
        }
        return false;
    }
    
    public static int stringMatch(String a, String b) {
        int hossz = (a.length() < b.length()) ? a.length()-1 : (a.length() == b.length()) ? a.length()-1 : b.length()-1;
        int count = 0;
        for(int i = 0; i < hossz; i++){
            if(a.substring(i, i+2).equals(b.substring(i, i+2))) count++;
        }
        return count;
}
   
    public static String stringX(String str) {
    if(str.length() > 2)
        return ((str.charAt(0) == 'x') ? "x" : "") + str.replaceAll("x","") + ((str.charAt(str.length()-1) == 'x') ? "x" : "");
    else return str;
    }
   
    public static String altPairs(String str) {
        if(str.length() < 3) return str;
        String result = "";

        for(int i = 0; i < str.length();i+=4) {
          result += str.substring(i, i+2);
        }
        return result;
    }
   
    public static boolean scoresClump(int[] scores) {
    for(int i = 0;i < scores.length-1; i++){
        if( scores[i]+1 == scores[i+1] && scores[i]+2 == scores[i+2] )
        {
            return true;
        }
        else if(scores[i] == scores[i+1])
        {
            return true;
        }
    }
    return false;
    }


}
