package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AliceBob {
    static FastReader in;
    static PrintWriter out;
    public static void main(String[] args) throws IOException {
        in = new FastReader();
        out = new PrintWriter(System.out);

        int t = 1;
        t = in.nextInt();

        while(t-- > 0) {
            int n = in.nextInt();
            long a = in.nextLong();

            long[] pebbles = new long[n];
            for(int i=0; i<n; i++) pebbles[i] = in.nextLong();
            out.println(solve(n, a, pebbles));
        }
        out.flush();
    }

    static long solve(int n, long a, long[] arr) throws IOException {
        // The closest number would be the number +-1, whichever side has more numbers.

        int less = 0;
        int more = 0;

        for(long x : arr) {
            if(x > a) more++;
            if(x < a) less++;
        }

        return (less >= more) ? a-1 : a+1;

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
