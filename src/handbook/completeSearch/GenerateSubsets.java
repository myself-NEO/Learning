//You are given an integer n, generate all subsets from 0 to n.

package handbook.completeSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateSubsets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> ans = new ArrayList<>();

//        Here we took ind=-1 because we have to generate from 0 to n (0 inclusive)
        generateSubsets(n, -1, new ArrayList<>(), ans);
        ans.forEach(x ->
                {
                    x.forEach(y -> System.out.print(y + " "));
                    System.out.println();
                }
        );
    }

    static void generateSubsets(int n, int ind, ArrayList<Integer> curr, List<List<Integer>> ans) {
        if(ind == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        generateSubsets(n, ind+1, curr, ans);

        curr.add(ind+1);
        generateSubsets(n, ind+1, curr, ans);

        curr.remove(curr.size()-1);
    }
}
