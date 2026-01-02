import java.util.*;

public class CheckerboardPattern {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 2};
        int ans = longestSubarray(nums);
        System.out.println(ans);
    }

    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] preAnd = new int[n];
        preAnd[0] = nums[0];
        for(int i=1; i<n; i++) preAnd[i] = preAnd[i-1] & nums[i];
        int ans = 1;
        int maxAnd = preAnd[0];
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int temp = preAnd[i] & preAnd[j];
                if(temp > maxAnd) {
                    maxAnd = temp;
                    ans = j-i;
                }
            }
        }
        return ans==0 ? 1 : ans;
    }
}
