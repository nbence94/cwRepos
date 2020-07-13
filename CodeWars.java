package abstractteszt;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodeWars {
       
    public static void main(String[] args) {
        System.out.println("oddOrEven: " + oddOrEven(new int[] {2, 5, 34, 6}));
        System.out.println("scramble: " + scramble("rkqodlw","world"));
        System.out.println("longestConsec: " + longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));       
        System.out.println("toCamelCase: " + toCamelCase("the-stealth-warrior"));
        
        String szoveg = "Sajt";
        szoveg.chars().sorted().mapToObj(x->String.valueOf((char)x)).forEach(System.out::print);
    }  
    


    
    
    public static String toCamelCase(String s){
        if(s.length() == 0) return "";
        String tmp;
        String[] sentence = s.split("-|_");
        s = sentence[0];
        for(int i = 1; i < sentence.length; i++) {
            tmp = sentence[i].substring(0, 1).toUpperCase();
            s += tmp + sentence[i].substring(1);    
        }
        return s;        
    }    
    static String toCamelCase_alternate(String str){
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length).map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
               .reduce(words[0], String::concat);
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
        //IntStream list = Arrays.stream(array);       
        return (Arrays.stream(array, 1, array.length).sum() % 2 == 0) ? "even" : "odd";
        //return (list.sum() % 2 == 0)? "even" : "odd";
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
