//################################################
//SUBSET SUM - BOTTOM UP DP METHOD
//################################################

import java.util.*;

public class Testing {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(minMaxSums(arr, 2));
    }

    public static int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] powerOfTwo = new int[n + 1];
        powerOfTwo[0] = 1;
        for (int i = 1; i <= n; i++) {
            powerOfTwo[i] = (2 * powerOfTwo[i - 1]) % MOD;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long maxContribution = (long) nums[i] * (powerOfTwo[i]) % MOD;

            long minContribution = (long) nums[i] * (powerOfTwo[n - i - 1] - 1) % MOD;

            ans = (ans + maxContribution + minContribution) % MOD;
        }

        return (int) ans;

    }
}