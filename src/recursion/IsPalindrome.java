//You are given a string, you need to check if that string is a palindrome.

package recursion;

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(recur(s, 0, 6));
    }

    public static boolean recur(String s, int l, int r){
        if(l > r) return true;
        else if (s.charAt(l) != s.charAt(r)) return false;
        else return recur(s, l+1, r-1);
    }
}
