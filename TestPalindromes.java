/*
*This program uses recursion to check if a string supplied by the user is a palindrome or not.		
*/
import java.util.*;

public class TestPalindromes {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str;
        
        while (sc.hasNextLine()) {
            
            str = sc.nextLine();
            System.out.print("\"" + str + "\"");
            
            // To remove characters that are not letters in the alphabet,
            // represented by the regular expression [^a-zA-Z] in the
            // replaceAll() method below
            str = str.replaceAll("[^a-zA-Z]", "");//including spaces. so it compacts all the alphabets
            if (isPalindrome(0,str)) 
                System.out.println(" is a palindrome.");
            else
                System.out.println(" is not a palindrome.");
            
        }
    }
    
    // Returns true if str is a palindrome; otherwise, returns false.
    public static boolean isPalindrome(int idx, String str) {
        // Fill in the code 
        if(str.equals("")){
            return true;
        }
        if(idx>str.length()-1-idx){// successfully checked all characters in both halves of the string, hence the whole string is a palindrome
            return true;
        }   
        if(Character.toLowerCase(str.charAt(idx)) != Character.toLowerCase(str.charAt(str.length()-1-idx))){
            return false;
        }            
        return isPalindrome(idx+1,str);
    }
}

