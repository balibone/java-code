/*
 * CS1010J Programming Methodology
 * Problem Set 2 Exercise #15: PS2_Ex15_Prime.java
 * 
 * This program tests whether a given positive number is a prime number.
 */

import java.util.*;

class Prime {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        
        if ( isPrime(num) )
            System.out.println(num + " is a prime");
        else
            System.out.println(num + " is not a prime");
    }
    
    // Boolean method that returns true if num is a prime, false otherwise.
    public static boolean isPrime(int num) {
        
        if (num < 2)  // not a prime (0,1 are not primes)
            return false;
        
        for (int divisor = 2; divisor < num; divisor++) {
            if ( num%divisor == 0 ) // num can be divided by prime
                return false;  // not a prime, return false immediately
        }
        
        // tested [2, num-1] and none can divide num,
        // so num should be a prime number
        return true;
    }
}