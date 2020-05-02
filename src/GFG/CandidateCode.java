package GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CandidateCode {
    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /**
         * call this method to initialize reader for InputStream
         */
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /**
         * get next word
         */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for of if necessary
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
    public static void main(String[] args)  throws Exception {
        Reader.init(System.in);
        int n = Reader.nextInt();
        long a[] = new long[n];
        long[] b= new long[n];
        for(int i =0;i<n;i++){
            a[i] = Reader.nextLong();
        }
        for(int i =0;i<n;i++){
            b[i] = Reader.nextLong();
        }
        long ans = Long.MAX_VALUE;
        for(int i =0;i<n;i++){
            ans = Math.min(ans,b[i]/a[i]);
        }
        System.out.println(ans);
    }
}
