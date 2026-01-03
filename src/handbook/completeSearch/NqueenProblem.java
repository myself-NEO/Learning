package handbook.completeSearch;

import java.util.Scanner;

public class NqueenProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ans = {0};

        for(int i=0; i<n; i++) {
            boolean[][] visited = new boolean[n][n];
            visited[0][i] = true;
            recur(n, ans, visited, 1);
        }

        System.out.println(ans[0]);
    }

    static void recur(int n, int[] ans, boolean[][] visited, int row) {
        if(row == n) {
            ans[0] += 1;
            return;
        }

        for(int j=0; j<n; j++) {
            if(!isValid(row, j, n, visited)) continue;

            visited[row][j] = true;
            recur(n, ans, visited, row+1);

            visited[row][j] = false;
        }
    }

    static boolean isValid(int r, int c, int n, boolean[][] visited) {
        // out of bound
        if(r<0 || c<0 || r>=n || c>=n) return false;

        // row match
        for(int j=0; j<n; j++) if(visited[r][j]) return false;

        // column match
        for(int i=0; i<n; i++) if(visited[i][c]) return false;

        // diagonals
        int i, j;

        i = r; j = c;
        while (i >= 0 && j >= 0) if (visited[i--][j--]) return false;

        i = r; j = c;
        while (i >= 0 && j < n) if (visited[i--][j++]) return false;

        i = r; j = c;
        while (i < n && j >= 0) if (visited[i++][j--]) return false;

        i = r; j = c;
        while (i < n && j < n) if (visited[i++][j++]) return false;

        // if no match
        return true;

    }
}
