package handbook.completeSearch;

/*
You are given an n*n grid. You are at top left.
You need to get to bottom right.
Without stepping on any tile twice. And visiting all the tiles.
Find the number of ways to do this.
 */

// This solution is brute force using recursion and backtracking.
// This is also called Hamilton paths.

import java.util.Scanner;

public class CountPathsGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean[][] visited = new boolean[n][n];
        int[] ans = {0};
        visited[0][0] = true;

        recur(0, 0, visited, ans, n, 1);

        System.out.println(ans[0]);
    }

    static void recur(int x, int y, boolean[][] visited, int[] ans, int n, int vcount) {
        if(x==n-1 && y==n-1) {
            if(vcount == n*n) ans[0] += 1;
            return;
        }

        // right
        if(isValid(x+1, y, n, visited)) {
            visited[x+1][y] = true;
            recur(x+1, y, visited, ans, n, vcount+1);
            visited[x+1][y] = false;
        }

        // down
        if(isValid(x, y+1, n, visited)) {
            visited[x][y+1] = true;
            recur(x, y+1, visited, ans, n, vcount+1);
            visited[x][y+1] = false;
        }

        // left
        if(isValid(x-1, y, n, visited)) {
            visited[x-1][y] = true;
            recur(x-1, y, visited, ans, n, vcount+1);
            visited[x-1][y] = false;
        }

        // up
        if(isValid(x, y-1, n, visited)) {
            visited[x][y-1] = true;
            recur(x, y-1, visited, ans, n, vcount+1);
            visited[x][y-1] = false;
        }

    }

    static boolean isValid(int r, int c, int n, boolean[][] visited) {
        // out of bound
        if(r<0 || c<0 || r>=n || c>=n || visited[r][c]) return false;

        // if no match
        return true;

    }
}
