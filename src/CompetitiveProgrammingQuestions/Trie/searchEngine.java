package CompetitiveProgrammingQuestions.Trie;

import java.util.Scanner;
/*Search Engine
Send Feedback
Let us see how search engines work. Consider the following simple auto complete feature. When you type some characters in the text bar, the engine automatically gives best matching options among it's database. Your job is simple. Given an incomplete search text, output the best search result.
Each entry in engine's database has a priority factor attached to it. We consider a result / search suggestion best if it has maximum weight and completes the given incomplete search query. For each query in the input, print the maximum weight of the string in the database, that completes the given incomplete search string. In case no such string exists, print -1.
INPUT
First line contains two integers n and q, which represent number of database entries and number of search queries need to be completed. Next n lines contain a string s and an integer weight, which are the database entry and it's corresponding priority.

Next q lines follow, each line having a string t, which needs to be completed.
OUTPUT
Output q lines, each line containing the maximum possible weight of the match for given query, else -1, in case no valid result is obtained.
CONSTRAINTS
1 ≤ n, weight, len(s), len(t) ≤ 10^6
1 ≤ q ≤ 10^5
total length of all strings in database entries ≤ 10^6
total length of all query strings ≤ 10^6
SAMPLE INPUT
2 1
hackerearth 10
hackerrank 9
hacker
SAMPLE OUTPUT
10*/
public class searchEngine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        String word[] = new String[n];
        int priority[] = new int[n];
        for(int i =0;i<n;i++){
            String[] input = sc.nextLine().split(" ");
             word[i] = input[0];
             priority[i] = Integer.parseInt(input[1]);
             insert(word[i],priority[i]);
        }
        String queries[] = new String[q];
        for(int i =0;i<q;i++){
            queries[i] = sc.nextLine();
         System.out.println(searchWeight(queries[i]));
        }
    }
    static int ALPHABATE_SIZE=26;

    // Trie node
    static class TrieNode
    {
        TrieNode children[]=new TrieNode[ALPHABATE_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        int weight;
        // Returns new trie node (initialized to NULLs)
        public TrieNode(int w)
        {
            isEndOfWord=false;
            for(int i = 0; i<ALPHABATE_SIZE;i++)
            {
                children[i]=null;
            }
            weight =w;
        }
    };

    static TrieNode root= new TrieNode(0);

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just
    // marks leaf node
    static void insert(String key,int weight)
    {
        int level;
        int length=key.length();
        int index;
        TrieNode pCrawl=root;
        for(level = 0;level<length;level++)
        {
            index=key.charAt(level)-'a';
            if(pCrawl.children[index]==null)
            {
                pCrawl.children[index]=new TrieNode(weight);
            }
            if(pCrawl.children[index].weight < weight){
                pCrawl.children[index].weight = weight;
            }

            pCrawl=pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord=true;
    }

    // Returns true if key presents in trie, else
    // false
    static int searchWeight(String key)
    {
        int index;
        int length=key.length();
        int level;
        TrieNode pCrawl=root;

        for(level = 0;level<length;level++)
        {
            index=key.charAt(level)-'a';
            if(pCrawl.children[index]==null)
            {
                return -1;
            }
            pCrawl=pCrawl.children[index];
        }

        if(pCrawl!=null )
        {
            return pCrawl.weight;
        }
        else
        {
            return -1;
        }
    }
}
