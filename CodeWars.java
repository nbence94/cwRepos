package onlineexces;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeWars {
       
    public static void main(String[] args) {
        System.out.println("oddOrEven: " + oddOrEven(new int[] {2, 5, 34, 6}));
        System.out.println("scramble: " + scramble("rkqodlw","world"));
        System.out.println("longestConsec: " + longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));       
        System.out.println("toCamelCase: " + toCamelCase("the-stealth-warrior"));
        System.out.println("pigIt: " + pigIt2("Hello world !"));
        System.out.println("validate: " + validate("1230"));

        //System.out.println(parseInt("three thousand forty-six"));
        //System.out.println(parseInt_2("three thousand and three"));
        
        System.out.println("Eredmény: " + greedyRefactor(new int[] {1,1,1,3,1}));//Várt 1100
        
                int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                    /*{5, 3, 4, 6, 7, 8, 9, 1, 2}, 
                    {6, 7, 2, 1, 9, 0, 3, 4, 8},
                    {1, 0, 0, 3, 4, 2, 5, 6, 0},
                    {8, 5, 9, 7, 6, 1, 0, 2, 0},
                    {4, 2, 6, 8, 5, 3, 7, 9, 1},
                    {7, 1, 3, 9, 2, 4, 8, 5, 6},
                    {9, 0, 1, 5, 3, 7, 2, 1, 4},
                    {2, 8, 7, 4, 1, 9, 6, 3, 5},
                    {3, 0, 0, 4, 8, 1, 1, 7, 9}*/
        };
        System.out.println("Sudoku: " + check(sudoku));
        System.out.println("Faktoriális: " + zeros(18));
        
    }  
    
    
    
    
    
    public static int zeros(int n) {
      if(n == 0) return 0;
      //long factorial = 1;
      java.math.BigInteger factorial = BigInteger.ONE;
      for(int i = n; i > 0; i--){
          factorial = factorial.multiply(new BigInteger(i + ""));
      }
      String tmp = String.valueOf(factorial);
      int result  = 0;
      for(char a : tmp.toCharArray()){
          if(a == '0') result++;
      }
      return result;
    }   
    
    
    public static boolean check2(int[][] sudoku) {
        Map<Integer, Integer> sNums = new HashMap<>();
        for(int i = 0; i < sudoku.length; i++){
            for(int j = 0; j < sudoku.length; j++){
                if(sNums.containsKey(sudoku[i][j])){
                    sNums.put(sudoku[i][j], sNums.get(sudoku[i][j])+1);
                } else sNums.put(sudoku[i][j], 1);
            }
        }    
        return (sNums.get(1) == 9 && sNums.get(2) == 9 && sNums.get(3) == 9 && sNums.get(4) == 9 && sNums.get(5) == 9 && sNums.get(6) == 9 && sNums.get(7) == 9 && sNums.get(8) == 9 && sNums.get(9) == 9);
    }

    
    
    public static boolean check(int[][] sudoku) {
        for(int i = 0; i < sudoku.length; i++){
            for(int j = 0; j < sudoku.length; j++){
                if(sudoku[i][j] == 0) return false;
                //sor ellenőrzés
                for(int r = 0; r < sudoku.length; r++){
                    if(sudoku[i][r] == sudoku[i][j] && j != r){
                        return false;
                    }
                }
                //oszlop ellenőrzés
                for(int c = 0; c < sudoku.length; c++){
                    if(sudoku[c][j] == sudoku[i][j] && i != c){                    
                        return false;
                    } 
                } 
            }
        }
        return true;
    }
    
    
    
    
  public static int greedy(int[] dice){
    int result = 0;
    int forOne = 0, forSix = 0, forThree = 0, forFour = 0, forFive = 0, forTwo = 0;
    for(int i = 0; i < dice.length; i++){
        if(dice[i] == 1) forOne++;
        if(dice[i] == 1 && forOne == 3){
            result += 1000;
            forOne = 0;
        }
        
        if(dice[i] == 6) forSix++;
        if(dice[i] == 6 && forSix == 3){
            result += 600;
            forSix = 0;
        }
        
        if(dice[i] == 5) forFive++;
        if(dice[i] == 5 && forFive == 3){
            result += 500;
            forFive = 0;
        } 
        
        if(dice[i] == 4) forFour++; 
        if(dice[i] == 4 && forFour == 3){
            result += 400;          
            forFour = 0;
        } 
        
        if(dice[i] == 3) forThree++;
        if(dice[i] == 3 && forThree == 3){
            result += 300;
            forThree = 0;
        }  
        
        if(dice[i] == 2) forTwo++;
        if(dice[i] == 2 && forTwo == 3){
            result += 200;
            forTwo = 0;
        }  
    }
    if(forOne > 0) result += forOne * 100;
    if(forFive> 0) result += forFive * 50;
    
    
    
    return result;
  }    
  
  
  public static int greedyRefactor(int[] Dice) {
      int result = 0;
      Map<Integer, Integer> nums = new HashMap<>();
      for(int i = 0; i < Dice.length; i++){
          if(nums.containsKey(Dice[i]))
          nums.put(Dice[i], nums.get(Dice[i])+1);
          else
          nums.put(Dice[i], 1);
      }    
      System.out.println(nums);
      if(nums.containsKey(1)) result += nums.get(1)%3 * 100;
      if(nums.containsKey(1)) result += nums.get(1)/3 * 1000;
      if(nums.containsKey(2)) result += nums.get(2)/3 * 200;
      if(nums.containsKey(3)) result += nums.get(3)/3 * 300;
      if(nums.containsKey(4)) result += nums.get(4)/3 * 400;
      if(nums.containsKey(5)) result += nums.get(5)/3 * 500; 
      if(nums.containsKey(5)) result += nums.get(5)%3 * 50;
      if(nums.containsKey(6)) result += nums.get(6)/3 * 600;
      
      
      return result;
  }
    
    
    
    
    
    public static int parseInt_2(String numStr) {
        if(numStr.equals("")) return -1;
        String[] numbers = numStr.split("[ ]");
        String tmpNum = "";
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i] + " : " + i);
            if ("thousand".equals(numbers[i]) && i == numbers.length-1) tmpNum += "000"; 
            else if("thousand".equals(numbers[i]) && !numStr.contains("hundred")) tmpNum += "0";
            
            if(numbers[i].contains("-")){
                
            }
            else
            {
                if("and".equals(numbers[i-1])) tmpNum += "0";
                if("three".equals(numbers[i])) tmpNum += "3";
            }
        
        }
        int result = Integer.parseInt(tmpNum);
        return result;
    }
    
    public static int parseInt(String numStr) {
        if(numStr.equals("")) return -1;
        String[] numbers = numStr.split("[ ]");
        String tmpNum = "";
        for(int i = 0; i < numbers.length; i++){
            //if("thousand".equals(numbers[i]) || "hundred".equals(numbers[i]) || "and".equals(numbers[i]) ) continue;
            if(!numbers[i].contains("teen")) {
                if("eleven".equals(numbers[i])) tmpNum += "11";
                else if("twelve".equals(numbers[i])) tmpNum += "12";               
                else if("one".equals(numbers[i])) tmpNum += "1";
                else if(numbers[i].startsWith("tw")) tmpNum += "2";     
                else if(numbers[i].startsWith("th") && !"thousand".equals(numbers[i])) tmpNum += "3";
                else if(numbers[i].startsWith("fo")) tmpNum += "4";
                else if(numbers[i].startsWith("fi")) tmpNum += "5";
                else if(numbers[i].startsWith("six")) tmpNum += "6";
                else if(numbers[i].startsWith("seven")) tmpNum += "7";
                else if(numbers[i].startsWith("eight")) tmpNum += "8";
                else if(numbers[i].startsWith("nin")) tmpNum += "9";
                if(numbers[i].contains("-")){
                    String tmp = numbers[i].substring(numbers[i].indexOf("-")+1, numbers[i].length());
                    if("one".equals(tmp)) tmpNum += "1";
                    if("two".equals(tmp)) tmpNum += "2";
                    if("three".equals(tmp)) tmpNum += "3";
                    if("four".equals(tmp)) tmpNum += "4";
                    if("five".equals(tmp)) tmpNum += "5";
                    if("six".equals(tmp)) tmpNum += "6";
                    if("seven".equals(tmp)) tmpNum += "7";
                    if("eight".equals(tmp)) tmpNum += "8";
                    if("nine".equals(tmp)) tmpNum += "9";
                }
                else if(numbers[i].endsWith("y")) tmpNum += "0";
                if("thousand".equals(numbers[i]) && !numStr.contains("hundred")) tmpNum += "0";
                //if("hundred".equals(numbers[i]) && !numStr.contains("y")) tmpNum += "0";
            }
            else {
                if("thirteen".equals(numbers[i])) tmpNum += "13";
                if("fourteen".equals(numbers[i])) tmpNum += "14";
                if("fifteen".equals(numbers[i])) tmpNum += "15";
                if("sixteen".equals(numbers[i])) tmpNum += "16";
                if("seventeen".equals(numbers[i])) tmpNum += "17";
                if("eighteen".equals(numbers[i])) tmpNum += "18";
                if("nineteen".equals(numbers[i])) tmpNum += "19";    
            }
        }
        int result = Integer.parseInt(tmpNum);
        return result;
    }
    
    public static int[] snail(int[][] array) {
        int[] result = new int[array.length * array.length];
        int index = 0; //új tömb indexe
        int m = array.length;//sor
        int n = m;//oszlop
        int i, k = 0, l = 0; 
        while (k < m && l < n){
            for(i = l; i < n; ++i) {
                result[index] = array[k][i];
                index++;
            }
            k++;//Következő körre ez lesz az első sor.
            for(i = k; i < m; ++i) {//K-tól kezdjük, mert az most pont az a sor, ami kell
                result[index] = array[i][n-1];//Az n az fix, mert csak az utolsó sort szeretnénk megszerezni
                index++;
            }
            n--;//A következő körben egyel korábban lesz az utolsó oszlop.
            if(k < m) {
                for(i = n-1; i >= l; --i) {
                  result[index] = array[m-1][i];
                  index++;
                }
                m--;
            }
            if(l < n) {
                for(i = m-1; i >= k; --i) {
                  result[index] = array[i][l];
                  index++;
                }
                l++;
            }
        }
        return result;
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
    
     public static String firstEnd(String str){
        String mid = str.substring(1, str.length()-1);
        return str.charAt(str.length()-1) + mid + str.charAt(0);
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
