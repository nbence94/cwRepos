package abstractteszt;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CodeWars {
       
    public static void main(String[] args) {
        System.out.println("oddOrEven: " + oddOrEven(new int[] {2, 5, 34, 6}));
        System.out.println("scramble: " + scramble("rkqodlw","world"));
        System.out.println("longestConsec: " + longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));       
    }  
    
    public static String longestConsec(String[] strarr, int k) {
        if(k > strarr.length) return "";
        String result = "";
        String tmp = strarr[0];
        for(int i = 0; i < k; i++){
            for(int x = 0; x < strarr.length; x++){
                if(strarr[x].length() > tmp.length() && !result.contains(strarr[x])){
                    tmp = strarr[x];
                } 
            }
            result += tmp;
            tmp = strarr[0];
        }           
        return result;        
    }    
    
    
    
    
    public static boolean scramble(String str1, String str2) {    
        int count = 0;
        for(int i = 0; i < str2.length(); i++){
            if(str1.contains(String.valueOf(str2.charAt(i)))) {
                count++;
                str1 = str1.replaceFirst(String.valueOf(str2.charAt(i)),"");
            }
        }
        return (count == str2.length());
    }    
    
     
    
    
    public static String oddOrEven (int[] array)    {
        IntStream list = Arrays.stream(array);       
        return (list.sum() % 2 == 0)? "even" : "odd";
  }
    
    public static int decToBin(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){//1234 - 10011010010
            if(num % 2 == 0) sb.append("0");
            else sb.append("1");
            
            num = num / 2;                     
        } 
        int count = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '1') count++;
        }
        return count;
    }
    
    public static boolean  isIsogram(String str) {
        boolean result = true;
        for(int i = 0;i < str.length(); i++){
          for(int j = 0; j < str.length(); j++) {
            if(str.charAt(i) == str.charAt(j) && i != j){
              result = false;
              break;
            }
          }
          if(result == false) break;
        }
        return result;
    } 
}
