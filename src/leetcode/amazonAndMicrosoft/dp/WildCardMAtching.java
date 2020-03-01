package leetcode.amazonAndMicrosoft.dp;
/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.*/
public class WildCardMAtching {

    /*Solution
Approach 1: Recursion with memorisation
Intuition

The first idea here is a recursion. That's a straightforward approach but quite time consuming because of huge recursion depth for long input strings.

If the strings are equal p == s, return True.

If the pattern matches whatever string p == '*', return True.

If p is empty, or s is empty, return False.

If the current characters match p[0] == s[0] or p[0] == '?', then compare the next ones and return isMatch(s[1:], p[1:]).

If the current pattern character is a star p[0] == '*', then there are two possible situations:

The star matches no characters, and hence the answer is isMatch(s, p[1:]).

The star matches one or more characters, and so the answer is isMatch(s[1:], p).

If p[0] != s[0], return False.

bla

The problem of this algorithm is that it doesn't pass all test cases because of time limit issue, and hence has to be optimised. Here is what could be done:

Memorisation. That is a standard way to optimise the recursion. Let's have a memorisation hashmap using pair (s, p) as a key and match/doesn't match as a boolean value. One could keep all already checked pairs (s, p) in this hashmap, so that if there are any duplicate checks, the answer is right here, and there is no need to proceed to the computations again.

Clean up of the input data. Whether the patterns with multiple stars in a row a****bc**cc are valid wildcards or not, they could be simplified without any data loss a*bc*cc. Such a cleanup helps to decrease the recursion depth.

Algorithm

Here is the algorithm.

Clean up the input by replacing more than one star in a row by a single star: p = remove_duplicate_stars(p).

Initiate the memorisation hashmap dp.

Return the helper function with a cleaned input: helper(s, p).

helper(s, p):

If (s, p) is already known and stored in dp, return the value.

If the strings are equal p == s, or the pattern matches whatever string p == '*', add dp[(s, p)] = True.

Else if p is empty, or s is empty, add dp[(s, p)] = False.

Else if the current characters match p[0] == s[0] or p[0] == '?', then compare the next ones and add dp[(s, p)] = helper(s[1:], p[1:]).

Else if the current pattern character is a star p[0] == '*', then there are two possible situations: the star matches no characters, and the star matches one or more characters. dp[(s, p)] = helper(s, p[1:]) or helper(s, p[1:]).

Else p[0] != s[0], add dp[(s, p)] = False.

Now that the value is computed, return it dp[(s, p)].

Implementation


Complexity Analysis

Time complexity: \mathcal{O}(\min(S, P))O(min(S,P)) for the best case, and \mathcal{O}(2^{\min(S, P/2)})O(2
min(S,P/2)
 ) for the worst case, where S and P are lengths of the input string and the pattern correspondingly. The best case is quite obvious, let's estimate the worst case. The most time consuming is the situation where recursion forms the tree on the star character in the pattern. In this situation 2 branches are executed : helper(s, p[1:]) and helper(s[1:], p). The maximum number of stars in the pattern after data cleanup is P/2P/2 and hence the time complexity is \mathcal{O}(2^{\min(S, P/2)})O(2
min(S,P/2)
 ).
Space complexity: \mathcal{O}(2^{\min(S, P/2)})O(2
min(S,P/2)
 ) to keep the memorisation hashmap and the recursion stack.

Approach 2: Dynamic Programming
Intuition

Recursion approach above shows how painful the large recursion depth could be, so let's try something more iterative.

Memorisation from the first approach gives an idea to try a dynamic programming. The problem is very similar with Edit Distance problem, so let's use exactly the same approach here.

The idea would be to reduce the problem to simple ones. For example, there is a string adcebdk and pattern *a*b?k, and we want to compute if there is a match for them: D = True/False. One could notice that it seems to be more simple for short strings and patterns and so it would be logical to relate a match D[p_len][s_len] with the lengths p_len and s_len of input pattern and string correspondingly.

Let's go further and introduce a match D[p_idx][s_idx] which is a match between the first p_idx characters of the pattern and the first s_idx characters of the string.

bla

It turns out that one could compute D[p_idx][s_idx], knowing a match without the last characters D[p_idx - 1][s_idx - 1].

If the last characters are the same or pattern character is '?', then

D[p_{idx}][s_{idx}] = D[p_{idx} - 1][s_{idx} - 1] \qquad (1)D[p
idx
​
 ][s
idx
​
 ]=D[p
idx
​
 −1][s
idx
​
 −1](1)

bla

If the pattern character is '*' and there was a match on the previous step D[p_idx - 1][s_idx - 1] = True, then

The star at the end of pattern still results in a match.

The star could much as many characters as you wish.

D[p_{idx} - 1][i] = \textrm{True}, i \ge s_{idx} - 1 \qquad(2)D[p
idx
​
 −1][i]=True,i≥s
idx
​
 −1(2)

So each step of the computation would be done based on the previous ones, as follows:

bla

bla

Algorithm

Start from the table initiated as False everywhere but D[0][0] = True.

Apply rules (1) and (2) in a loop and return D[p_len][s_len] as an answer.

bla

Implementation


Complexity Analysis

Time complexity : \mathcal{O}(S P)O(SP) where S and P are lengths of the input string and the pattern correspondingly.
Space complexity : \mathcal{O}(S P)O(SP) to keep the matrix.

Approach 3: Backtracking
Intuition

Complexity \mathcal{O}(S P)O(SP) is much better than \mathcal{O}(2^{\min(S, P/2)})O(2
min(S,P/2)
 ), but still could be improved. There is no need to compute the entire matrix, and i.e. to check all the possibilities for each star :

Star matches zero characters.
Star matches one character.
Star matches two characters.
...

Star matches all remaining characters.
Let's just pick up the first opportunity "matches zero characters" and proceed further. If this assumption would lead in "no match" situation, then backtrack : come back to the previous star, assume now that it matches one more character (one) and proceed again. Again "no match" situation? Backtrack again : come back to the previous star, and assume now that it matches one more character (two), etc.

bla

Algorithm

Here is the algorithm.

Let's use two pointers here: s_idx to iterate over the string, and p_idx to iterate over the pattern. While s_idx < s_len:

If there are still characters in the pattern p_idx < p_len and the characters under the pointers match p[p_idx] == s[s_idx] or p[p_idx] == '?', then move forward by increasing both pointers.

Else if there are still characters in the pattern p_idx < p_len, and p[p_idx] == '*', then first check "match zero characters" situation, i.e. increase only pattern pointer p_idx++. Write down for a possible backtrack the star position in star_idx variable, and the current string pointer in s_tmp_idx variable.

Else if there is "no match" situation: the pattern is used up p_idx < p_len or the characters under the pointers doesn't match.

If there was no stars in the pattern, i.e. no star_idx, return False.

If there was a star, then backtrack: set pattern pointer just after the last star p_idx = star_idx + 1, and string pointer s_idx = s_tmp_idx + 1, i.e. assume that this time the star matches one more character. Save the current string pointer for the possible backtrack s_tmp_idx = s_idx.

Return True if all remaining characters in the pattern are stars.

Implementation


Complexity Analysis

Time complexity : \mathcal{O}(\min(S, P))O(min(S,P)) for the best case and better than \mathcal{O}(S \log P)O(SlogP) for the average case, where S and P are lengths of the input string and the pattern correspondingly. Please refer to this article for the detailed proof.
Space complexity : \mathcal{O}(1)O(1) since it's a constant space solution.*/
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        // base cases
        if (p.equals(s) || p.equals("*")) return true;
        if (p.isEmpty() || s.isEmpty()) return false;

        // init all matrix except [0][0] element as False
        boolean[][] d = new boolean[pLen + 1][sLen + 1];
        d[0][0] = true;

        // DP compute
        for(int pIdx = 1; pIdx < pLen + 1; pIdx++) {
            // the current character in the pattern is '*'
            if (p.charAt(pIdx - 1) == '*') {
                int sIdx = 1;
                // d[p_idx - 1][s_idx - 1] is a string-pattern match
                // on the previous step, i.e. one character before.
                // Find the first idx in string with the previous math.
                while ((!d[pIdx - 1][sIdx - 1]) && (sIdx < sLen + 1)) sIdx++;
                // If (string) matches (pattern),
                // when (string) matches (pattern)* as well
                d[pIdx][sIdx - 1] = d[pIdx - 1][sIdx - 1];
                // If (string) matches (pattern),
                // when (string)(whatever_characters) matches (pattern)* as well
                while (sIdx < sLen + 1) d[pIdx][sIdx++] = true;
            }
            // the current character in the pattern is '?'
            else if (p.charAt(pIdx - 1) == '?') {
                for(int sIdx = 1; sIdx < sLen + 1; sIdx++)
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1];
            }
            // the current character in the pattern is not '*' or '?'
            else {
                for(int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    // Match is possible if there is a previous match
                    // and current characters are the same
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1] &&
                            (p.charAt(pIdx - 1) == s.charAt(sIdx - 1));
                }
            }
        }
        return d[pLen][sLen];
    }
}
