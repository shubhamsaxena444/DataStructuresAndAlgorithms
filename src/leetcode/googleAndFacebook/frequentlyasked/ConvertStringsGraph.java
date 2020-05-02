package leetcode.googleAndFacebook.frequentlyasked;
/*Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.

Return true if and only if you can transform str1 into str2.



Example 1:

Input: str1 = "aabcc", str2 = "ccdee"
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
Example 2:

Input: str1 = "leetcode", str2 = "codeleet"
Output: false
Explanation: There is no way to transform str1 to str2.


Note:

1 <= str1.length == str2.length <= 10^4
Both str1 and str2 contain only lowercase English letters.*/
public class ConvertStringsGraph {
    public boolean canConvert(String s1, String t1) {
        if(s1.equals(t1))return true;
        char[] s = s1.toCharArray();
        char[] t = t1.toCharArray();
        int length = s.length;
        if (length != t.length) return false;

        int mapping[] = new int[26];
        boolean visited[] = new boolean[26];
        int uniq_count = 0;
        for (int i = 0; i < 26; i++) {
            mapping[i] = -1;
            visited[i] = false;
        }

        // build mapping
        for (int i = 0; i < s.length; i++) {
            int sc = s[i] - 'a';
            int tc = t[i] - 'a';
            if (mapping[sc] == -1) {
                mapping[sc] = tc;
            } else if (mapping[sc] != tc) {
                // this character maps to more than one character,
                // so it is not homomorphic
                return false;
            }
            // track how many unique characters appear in 't'
            if (!visited[tc]) {
                visited[tc] = true;
                uniq_count++;
            }
        }

        // if we have at least one swap character available then we can always transform the strings
        if (uniq_count < 26) return true;

        // at this point we don't have any characters available for swap space
        // so if even a single circular dependency exists then the strings
        // cannot be converted from one to the other using the global replaceAll

        for (int i = 0; i < 26; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < length; i++) {
            int sc = s[i] - 'a';
            if (!visited[sc]) {
                visited[sc] = true;
                // use fast and slow pointers
                int slow = sc, fast = sc;
                while (true) {
                    slow = mapping[slow];
                    if ((fast = mapping[fast]) == -1) break;
                    visited[fast] = true;
                    if ((fast = mapping[fast]) == -1) break;
                    visited[fast] = true;
                    // if fast == slow then a cycle was detected, and there aren't any swap characters available so fail
                    if (fast == slow) return false;
                }
            }
        }

        // if we made it this far, they are homomorphic and s can be transformed to t
        return true;
    }
}
