//Get all subsets of a given array/

package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetGeneration {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans =   new ArrayList<>();
        recur(ans, arr, new ArrayList<>(), 0);
        for(List<Integer> x : ans) {
            for(int y : x) System.out.print(y + " ");
            System.out.println();
        }
    }

    private static void recur (List<List<Integer>> ans, int[] arr, ArrayList<Integer> curr, int ind) {
        if(curr.size() == 3) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        recur(ans, arr, curr, ind+1);
        curr.add(arr[ind]);
        recur(ans, arr, curr, ind+1);
    }
}
