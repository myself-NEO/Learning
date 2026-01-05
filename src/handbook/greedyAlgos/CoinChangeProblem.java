package handbook.greedyAlgos;

/*
You have a set of denominations and a number x.
You need to find the minimum number of coins needed so that sum of them is x.
You can choose any coin any number of times.

With the greedy algo, it does not always work.
We can use DP.
 */

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] deno = new int[n];
        for(int i=0; i<n; i++) deno[i] = sc.nextInt();

        int x = sc.nextInt();

        int ans = solve(deno, x);
        System.out.println(ans);
    }

    static int solve(int[] deno, int x) {
        Arrays.sort(deno);
        int ans = 0;
        int ind = deno.length-1;
        while (ind >= 0 && x >= 0) {
            while(deno[ind] <= x) {
                ans++;
                x -= deno[ind];
            }
            ind--;
        }
        return ans;
    }
}
