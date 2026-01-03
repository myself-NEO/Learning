package handbook.completeSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneratePurmutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[n];

        List<List<Integer>> ans = new ArrayList<>();
        recur(ans, new ArrayList<>(), arr, visited);

        ans.forEach(x -> {
            x.forEach(y -> System.out.print(y + " "));
            System.out.println();
        });
    }

    static void recur(List<List<Integer>> ans, List<Integer> curr, int[] arr, boolean[] visited) {
        if(curr.size() == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            curr.add(arr[i]);
            recur(ans, curr, arr, visited);
            visited[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}
