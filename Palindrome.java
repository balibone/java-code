public class Palindrome {
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int left = 0;
        int right = word.length()-1;
        while(left<right){
            if(word.charAt(left) != word.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}
