package abstractteszt;

import java.util.Arrays;
import java.util.stream.IntStream;
import javax.xml.soap.Node;

public class CodeWars {
       
    public static void main(String[] args) {
        System.out.println("oddOrEven: " + oddOrEven(new int[] {2, 5, 34, 6}));
         
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
