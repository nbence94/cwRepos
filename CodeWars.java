package onlineexces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodeWars {
       
    public static void main(String[] args) {
        System.out.println("oddOrEven: " + oddOrEven(new int[] {2, 5, 34, 6}));
        System.out.println("scramble: " + scramble("rkqodlw","world"));
        System.out.println("longestConsec: " + longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));       
        System.out.println("toCamelCase: " + toCamelCase("the-stealth-warrior"));
        System.out.println("pigIt: " + pigIt2("Hello world !"));
        System.out.println("validate: " + validate("1230"));
        
    }  
        public static String firstEnd(String str){
        String mid = str.substring(1, str.length()-1);
        return str.charAt(str.length()-1) + mid + str.charAt(0);
    }
    
    public static String delAt(String str, int n){
        return str.replace(String.valueOf(str.charAt(n)), "");
    }
    
    public static int getCount(String str) {
    int vowelsCount = 0;   
    if(str.contains("[aeiou]")) {
        vowelsCount++;
    }

    return vowelsCount;
  }
    

    public static String giveBack(String str){
        return str.charAt(0) + str + str.charAt(str.length()-1);
    }
    
    public boolean startHi(String str) {
      String[] words = str.split(" ");
        return "hi".equals(words[0].toLowerCase());
    }

     
   public static boolean validate(String n){
       String[] nums = n.split("");
       int sum = 0;
       int count = 1;
       for(int i = nums.length-1; i >= 0; i--){
           if(count % 2 == 0){
               nums[i] = "" + (Integer.parseInt(nums[i]) * 2); 
           }
           if(Integer.parseInt(nums[i]) > 9){
               nums[i] = "" + (Integer.parseInt(nums[i]) - 9);
           }
           sum += Integer.parseInt(nums[i]);
           count++;
       }
       return (sum % 10 == 0);
  }   
    
    
    //for megoldás
    public static String pigIt(String str) {
        String[] words = str.split("\\s+");
        String result = "";
        for(int i = 0; i < words.length;i++){
            if(words[i].length() > 1){
                result += words[i].substring(1, words[i].length()) + words[i].charAt(0) + "ay";
                if(i < words.length-1) result += " ";
            }
            else {
                result += words[i];
                if(i < words.length-1) result += " ";
            }
        }
                
        return result;
    }
    //Streames megoldás
    public static String pigIt2(String str) {
        String[] words = str.split("\\s+");
        List<String> newWords = new ArrayList<>();
        newWords = Arrays.asList(words);                
        return newWords.stream()
                .map(y -> y.matches("[a-zA-Z]+")? y.substring(1, y.length()) + y.charAt(0) + "ay": y)
                .collect(Collectors.joining(" "));
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
