package leetcode.uber.dp;

import java.util.*;

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false*/
public class wordbreak {
/*Approach 1: Brute Force
Algorithm

The naive approach to solve this problem is to use recursion and backtracking. For finding the solution, we check every possible prefix of that string in the dictionary of words, if it is found in the dictionary, then the recursive function is called for the remaining portion of that string. And, if in some function call it is found that the complete string is in dictionary, then it will return true.


Complexity Analysis

Time complexity : O(n^n)O(n
n
 ). Consider the worst case where ss = "\text{aaaaaaa}aaaaaaa" and every prefix of ss is present in the dictionary of words, then the recursion tree can grow upto n^nn
n
 .

Space complexity : O(n)O(n). The depth of the recursion tree can go upto nn.


Approach 2: Recursion with memoization
Algorithm

In the previous approach we can see that many subproblems were redundant, i.e we were calling the recursive function multiple times for a particular string. To avoid this we can use memoization method, where an array memomemo is used to store the result of the subproblems. Now, when the function is called again for a particular string, value will be fetched and returned using the memomemo array, if its value has been already evaluated.

With memoization many redundant subproblems are avoided and recursion tree is pruned and thus it reduces the time complexity by a large factor.


Complexity Analysis

Time complexity : O(n^2)O(n
2
 ). Size of recursion tree can go up to n^2n
2
 .

Space complexity : O(n)O(n). The depth of recursion tree can go up to nn.


Approach 3: Using Breadth-First-Search
Algorithm

Another approach is to use Breadth-First-Search. Visualize the string as a tree where each node represents the prefix upto index endend. Two nodes are connected only if the substring between the indices linked with those nodes is also a valid string which is present in the dictionary. In order to form such a tree, we start with the first character of the given string (say ss) which acts as the root of the tree being formed and find every possible substring starting with that character which is a part of the dictionary. Further, the ending index (say ii) of every such substring is pushed at the back of a queue which will be used for Breadth First Search. Now, we pop an element out from the front of the queue and perform the same process considering the string s(i+1,end)s(i+1,end) to be the original string and the popped node as the root of the tree this time. This process is continued, for all the nodes appended in the queue during the course of the process. If we are able to obtain the last element of the given string as a node (leaf) of the tree, this implies that the given string can be partitioned into substrings which are all a part of the given dictionary.

The formation of the tree can be better understood with this example:

Current
1 / 7

Complexity Analysis

Time complexity : O(n^2)O(n
2
 ). For every starting index, the search can continue till the end of the given string.

Space complexity : O(n)O(n). Queue of atmost nn size is needed.


Approach 4: Using Dynamic Programming
Algorithm

The intuition behind this approach is that the given problem (ss) can be divided into subproblems s1s1 and s2s2. If these subproblems individually satisfy the required conditions, the complete problem, ss also satisfies the same. e.g. "\text{catsanddog}catsanddog" can be split into two substrings "\text{catsand}catsand", "\text{dog}dog". The subproblem "\text{catsand}catsand" can be further divided into "\text{cats}cats","\text{and}and", which individually are a part of the dictionary making "\text{catsand}catsand" satisfy the condition. Going further backwards, "\text{catsand}catsand", "\text{dog}dog" also satisfy the required criteria individually leading to the complete string "\text{catsanddog}catsanddog" also to satisfy the criteria.

Now, we'll move onto the process of \text{dp}dp array formation. We make use of \text{dp}dp array of size n+1n+1, where nn is the length of the given string. We also use two index pointers ii and jj, where ii refers to the length of the substring (s's
′
 ) considered currently starting from the beginning, and jj refers to the index partitioning the current substring (s's
′
 ) into smaller substrings s'(0,j)s
′
 (0,j) and s'(j+1,i)s
′
 (j+1,i). To fill in the \text{dp}dp array, we initialize the element \text{dp}[0]dp[0] as \text{true}true, since the null string is always present in the dictionary, and the rest of the elements of \text{dp}dp as \text{false}false. We consider substrings of all possible lengths starting from the beginning by making use of index ii. For every such substring, we partition the string into two further substrings s1's1
′
  and s2's2
′
  in all possible ways using the index jj (Note that the ii now refers to the ending index of s2's2
′
 ). Now, to fill in the entry \text{dp}[i]dp[i], we check if the \text{dp}[j]dp[j] contains \text{true}true, i.e. if the substring s1's1
′
  fulfills the required criteria. If so, we further check if s2's2
′
  is present in the dictionary. If both the strings fulfill the criteria, we make \text{dp}[i]dp[i] as \text{true}true, otherwise as \text{false}false.


Complexity Analysis

Time complexity : O(n^2)O(n
2
 ). Two loops are their to fill \text{dp}dp array.

Space complexity : O(n)O(n). Length of pp array is n+1n+1.*/
public boolean wordBreak1(String s, List<String> wordDict) {
    return word_Break1(s, new HashSet(wordDict), 0);
}
    public boolean word_Break1(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break1(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        return word_Break2(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean word_Break2(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break2(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
    public boolean wordBreak4(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
