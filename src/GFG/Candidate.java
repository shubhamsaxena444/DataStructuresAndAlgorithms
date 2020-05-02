package GFG;

import java.io.*;
import java.util.*;
public class Candidate{

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
    public static void main(String args[] ) throws Exception {

        //Write code here
//        Scanner sc = new Scanner(System.in);
//        int test = sc.nextInt();

        Reader.init(System.in);
        int test= Reader.nextInt();
        int ans[] = new int[test];


        for(int t=0;t<test;t++){
            int n = Reader.nextInt();
            long g[] = new long[n];
            long o[] = new long[n];
            for(int i=0;i<n;i++){
                g[i] = Reader.nextLong();
            }
            for(int i=0;i<n;i++){
                o[i] = Reader.nextLong();
            }
            ans[t] = getAns(g,o,n);
        }
        for(int i =0;i<test;i++){
            System.out.println(ans[i]);
        }
    }
    static int getAns(long[] g,long[] o,int n){
        //sort g and o
        //Arrays.sort(o);
        TreeMap<Long,Integer> tm = new TreeMap<>();
        for(int i =0;i<n;i++){

            tm.put(g[i],tm.getOrDefault(g[i],0)+1);
        }
        int count =0;
        //for each player in o, find upper bound in tm , if fount increase counter and decrese freq, if freq ==0, remove entry
        for(int i =0;i<n;i++){
            long opp = o[i];
            Map.Entry<Long,Integer> entry =  tm.higherEntry(opp);
            if(entry!=null) {
                count++;
                tm.put(entry.getKey(),entry.getValue()-1);
                if(tm.get(entry.getKey())==0){
                    //remove entry
                    tm.remove(entry.getKey());
                }
            }
        }
        return count;
    }
}
