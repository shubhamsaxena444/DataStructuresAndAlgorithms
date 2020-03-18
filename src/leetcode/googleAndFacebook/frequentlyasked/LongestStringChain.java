package leetcode.googleAndFacebook.frequentlyasked;

import java.util.*;
/*Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.



Example 1:

Input: ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".


Note:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of English lowercase letters.*/
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> lengthToWords = new HashMap<>();
        for (String word : words) {
            lengthToWords.putIfAbsent(word.length(), new ArrayList<>());
            lengthToWords.get(word.length()).add(word);
        }
        int max = 0;
        Map<String, Integer> seen = new HashMap<>();
        for (String word : words) {
            max = Math.max(max, longestStrChain(word, lengthToWords, seen));
        }
        return max;
    }

    private int longestStrChain(String word, Map<Integer, List<String>> lengthToWords, Map<String, Integer> seen) {
        if (!lengthToWords.containsKey(word.length() - 1)) return 1;
        if (seen.containsKey(word)) return seen.get(word);
        int max = 1;
        for (String curr : lengthToWords.get(word.length() - 1)) {
            if (!isPred(word, curr)) continue;
            max = Math.max(max, longestStrChain(curr, lengthToWords, seen) + 1);
        }
        seen.put(word, max);
        return max;
    }

    private boolean isPred(String word1, String word2) {
        for (int i = 0, j = 0, diff = 0; i < word1.length() && j < word2.length(); i++) {
            if (word1.charAt(i) == word2.charAt(j)) j++;
            else {
                diff++;
                if (diff > 1) return false;
            }
        }
        return true;
    }
}
