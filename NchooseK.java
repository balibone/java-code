// This program reads in a string of N distinct letters, assumed to be in alphabetical order.
// and prints all K-letter string combinations from it.
// Recursion is used.

import java.util.*;

public class NchooseK {
    
    public static void main(String[] args) {
        
        // Read input data
        Scanner sc = new Scanner(System.in);
        int numOfLetters = sc.nextInt();
        String str = sc.next();
        
        generate(numOfLetters,"", str, 0);
    }
    
    // Driver (auxiliary) method to call recursive method 
    public static void generate(int k, String selected, String str, int index) {
        if(selected.length()==k){//selected string has satisfied length of K chars
            System.out.println(selected);
            return;
        }
        if(index==str.length()){//"index" pointer has reached beyond last index of string
            return;
        }
        generate(k,selected+str.charAt(index),str,index+1);//concatonate character into selection
        generate(k,selected,str,index+1);//do not concatonate, move on to next character        
    }
    
}

