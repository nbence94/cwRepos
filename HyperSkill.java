/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexces;

import java.util.Scanner;

/**
 *
 * @author BenZe
 */
public class HyperSkill {
    
    public static void main(String[] args) {
        System.out.println(Factorial(6188989133L));
    }
    
    public static int Factorial(long m){
        boolean found = false;
        long n = 1;
        int o = 2;
        int count = 0;
        while(!found){
            n = factor(n);
            count++;
            if(n > m) found = true;
            else n = o++;
        }                   
        return count;
    }
    
    public static long factor(long n){
        long m = 1L;
        for(int i = 0; i < n; i++){
            m *= n - i;
        }
        return m;
    }
    
    
    
    public static void FizzBuzz(int start, int end){
        for(int i = start; i <= end; i++){
            if(i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
            else if(i % 3 == 0) System.out.println("Fizz");
            else if(i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }              
    }
    
    public static void numsOfGrades(int number){
        Scanner sc = new Scanner(System.in);
        int num = number;
        int A = 0, B = 0, C = 0, D = 0;
        for(int i = 0; i < num; i++){
            System.out.print("Adj meg egy számot: ");
            int n = sc.nextInt();
            if(n == 2) D++;
            if(n == 3) C++;
            if(n == 4) B++;
            if(n == 5) A++;            
        }
        System.out.println(D + " " + C + " " + B + " " + A);
    }
    
    public static void utmostDivisible(int number){
        Scanner sc = new Scanner(System.in);
        int max = 0;
        for(int i = 0; i < number; i++){
            int n = sc.nextInt();
            if(n % 4 == 0 && n > max) max = n;
        }
        System.out.println(max);
    }
    
}
