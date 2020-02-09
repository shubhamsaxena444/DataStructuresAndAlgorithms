package CompetitiveProgrammingQuestions.Trie;

/*SUBXOR
Send Feedback
A straightforward question. Given an array of positive integers you have to print the number of subarrays whose XOR is less than K. Subarrays are defined as a sequence of continuous elements Ai, Ai+1, ..., Aj . XOR of a subarray is defined as Ai ^ Ai+1 ^ ... ^ Aj. Symbol ^ is Exclusive Or.
Input Format
First line contains T, the number of test cases.
Each of the test case consists of N and K in one line, followed by N space separated integers in next line.
Output Format
For each test case, print the required answer.
Constraints:
1 ≤ T ≤ 5
1 ≤ N ≤ 10^5
1 ≤ A[i] ≤ 10^5
1 ≤ K ≤ 10^6
Sample Input
1
5 2
4 1 3 2 7
Sample Output
3*/
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.util.HashMap;
        import java.util.StringTokenizer;


// Java implementation of search and insert operations
class TrieNode {
    char c;
    TrieNode zero;
    TrieNode one;
    boolean isLeaf;
    int count = 0;
    TrieNode() {
        //constructor
    }
    TrieNode(char c){
        this.c = c;
    }
}



class Main {

    public static void main(String[] args) throws IOException  {
        Reader.init(System.in);
        int Test=Reader.nextInt();
        for(int j=0;j<Test;j++){
            int n=Reader.nextInt();
            int k=Reader.nextInt();
            int t[]=new int[n];
            for(int i=0;i<n;i++){
                t[i]=Reader.nextInt();
            }
            Main a=new Main();
            if(n==5){
                a.calculate(n, k, t);
            }
            else {
                a.calculate(n, k, t);
            }

        }

    }

    static TrieNode root ;

    public static void Insert(TrieNode t,int  s,int index) {


        if(index == -1) {
            t.isLeaf = true;
            return;
        }



        char cur = (s & (1<<index)) == 0 ? '0':'1' ;
        if(cur == '0') {
            if(t.zero == null) {
                TrieNode temp = new TrieNode('0');
                t.zero = temp;

            }
            t.zero.count++;
            Insert(t.zero,s,index-1);

        } else if(cur == '1'){

            if(t.one == null) {
                TrieNode temp = new TrieNode('1');
                t.one = temp;

            }
            t.one.count++;
            Insert(t.one,s,index-1);

        }
    }

    public static long Search(TrieNode t,int s,int k,int index) {

        if(index == -1 || t == null) return 0;

        long answer = 0;

        char curS = (s & (1<<index)) == 0 ? '0':'1' ;
        char curk = (k & (1<<index)) == 0 ? '0':'1' ;



        if(curS == '0') {

            if( curk =='1')
                answer+= ((t.zero==null)? 0:t.zero.count)+Search(t.one,s,k,index-1);


            if(curk =='0')
                answer+= Search(t.zero,s,k,index-1);


        }  else {
            if(curk =='1')
                answer+= ((t.one==null)? 0:t.one.count)+Search(t.zero,s,k,index-1);



            if(curk =='0')
                answer+= Search(t.one,s,k,index-1);
        }

        return answer;
    }

    /**method to find subarray count equal to k START**/
    static int findSubarrCntEqualToK(int arr[], int n,int k)
    {
        int ans = 0;

        int prefix[] = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i)
        {
            int tmp = k ^ prefix[i] ;
            if(map.containsKey(tmp))
            {
                ans += map.get(tmp);

            }

            if(map.containsKey(prefix[i])) {
                map.put(prefix[i],map.get(prefix[i]) + 1);
            }else {
                map.put(prefix[i], 1);
            }

            if(prefix[i]==k) {
                ans +=1;
            }
        }

        return ans;
    }

    /**method to find subarray count equal to k END**/

    public static void printSorted(TrieNode node, String s) {

        TrieNode z = node.zero;
        TrieNode o = node.one;

        if (z != null)
            printSorted(z, s + '0');

        if (o != null)
            printSorted(o, s + '1');

        if (node.isLeaf) {
            System.out.println(s);
        }
    }

    public void calculate(int n,int k,int[] arr){
        long answer = 0 ;

        int XoR = 0;

        root = new TrieNode();

        Insert(root,0,20);

        for(int i=0;i<n;i++) {
            int rakam = arr[i];
            XoR^= rakam;
            answer+=(Search(root,XoR,k,20));
            Insert(root,XoR,20);
        }
        //System.out.println(answer);
        long equalCount=findSubarrCntEqualToK(arr,n,k);
        long greaterCount=(int) (Math.pow(2, arr.length)-(equalCount+answer));

        long m=1000000007;

		/*answer=answer%m;
		equalCount=equalCount%m;
		greaterCount=greaterCount%m;

		long val=(long) (Math.pow((answer+equalCount), 2)+Math.pow((equalCount+greaterCount), 2)+Math.pow((equalCount+greaterCount+answer), 2)
		-(Math.pow(answer,2)+Math.pow(equalCount,2)+Math.pow(greaterCount,2)));*/

        long val=(int) ((answer%m*answer%m)%m+(equalCount%m*equalCount%m)%m+(greaterCount%m*greaterCount%m)%m+(2%m*((answer%m*equalCount%m)%m+(answer%m*greaterCount%m)%m+(equalCount%m*greaterCount%m)%m)%m)%m);

        System.out.println(answer);

    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for of if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}