//Given an unsorted array of N elements, and an elsement X
//We need to find if X is present in the array.


package recursion;

public class Xpresent {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 6, 3};
        int x = 10;
        boolean ans = recur(arr, 0, 5, x);
        System.out.println(ans);
    }

    public static boolean recur(int[] arr, int l, int r, int x) {
        if(arr[l]==x || arr[r]==x) return true;
        else if(l > r) return false;
        else return recur(arr, l+1, r-1, x);
    }
}
