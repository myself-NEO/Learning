import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> ans = findPermutation("ABC");
        for(String str : ans) {
            System.out.println(str);
        }
    }

    public static ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> ans = new ArrayList<>();
        char[] x = s.toCharArray();
        Arrays.sort(x);
        boolean[] visited = new boolean[s.length()];
        backtrack(x, ans, new StringBuilder(), visited);
        return ans;
    }

    public static void backtrack(char[] s, ArrayList<String> ans, StringBuilder curr, boolean[] visited) {
        if(curr.length() == s.length) {
            ans.add(curr.toString());
            return;
        }

        for(int i=0; i<s.length; i++) {
            if(visited[i]) continue;
            if(i>0 && s[i]==s[i-1] && !visited[i-1]) continue;
            char x = s[i];
            visited[i] = true;
            curr.append(x);
            backtrack(s, ans, curr, visited);
            visited[i] = false;
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
