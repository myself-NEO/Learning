import java.io.*;
import java.util.*;

public class CFSol {
    static FastReader in;
    static PrintWriter out;
    public static void main(String[] args) throws IOException{
        in = new FastReader();
        out = new PrintWriter(System.out);

        int t = 1;
        t = in.nextInt();
        while(t-- > 0) {
            solve();
        }
        out.flush();
    }

    static void solve() throws IOException {
        // Implement the solution
    }



    //------------------------    FastReader implementation ------------------------
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st==null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        double nextDouble() throws IOException { return Double.parseDouble(next()); }
        String nextLine() throws IOException { return br.readLine(); }

        char nextChar() throws IOException {
            String s = next();
            return s.charAt(0);
        }

        int[] readArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}
