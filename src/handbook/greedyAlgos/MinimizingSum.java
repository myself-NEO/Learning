package handbook.greedyAlgos;

/*
You are given n numbers, a1, a2, ... an.
You have to find x, such that the sum:
|a1-x|^c + |a2-x|^c + ... |an-x|^c is minimized.

We will take 2 cases, when c=1 and when c=2.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        solveForC1(arr);
        solveForC2(arr);
    }

    static void solveForC1(int[] arr) {
        // sum will be minimum when x is median ///////////////////////////////////////////////////////////////////////
        Arrays.sort(arr);
        int n = arr.length;
        int median = 0;

        // n is odd
        if(n%2 != 0) {
            median = arr[n/2];
        } else {
            // both medians and anything in between those 2, is possible.
//            median = arr[n/2 - 1]; // this is correct
            median = arr[n/2]; // this is also correct
            // any number between these 2 is also correct.
//            median = arr[n/2] - (arr[n/2] + arr[n/2 - 1])/2; // this is also correct
        }

        int ans = 0;
        for(int x : arr) {
            ans += Math.abs(x - median);
        }

        System.out.println("The value of x is " + median + " and the minimized sum is " + ans);
    }

    static void solveForC2(int[] arr) {
        // sum will be minimum when x is average //////////////////////////////////////////////////////////////////////
        int median = Arrays.stream(arr).sum() / arr.length;

        double ans = 0;
        for(int x : arr) {
            ans += Math.pow(x - median, 2);
        }

        System.out.println("The value of x is " + median + " and the minimized sum is " + ans);
    }
}
