package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Scanner sc = new Scanner(System.in);
		final String s = sc.nextLine();
		// final Map<String, Object> map = noOfSubstringWithKdistinctChars(s,
		// sc.nextInt());
		// System.out.println(map.get("num"));
		// System.out.println(Arrays.toString((String[]) map.get("substrings")));
		System.out.println(countWords(s));
	}

	private static int countWords(String s) {
		int res = 0;
		final int n = s.length();
		// lets maintain two states in and out...in is when we are inside a word and out
		// is when we leave it
		final boolean IN = true;
		final boolean OUT = false;
		boolean state = OUT;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == ' ' || s.charAt(i) == '\t' || s.charAt(i) == '\n') {
				state = OUT;

			} else if (state == OUT) {
				state = IN;
				res++;
			}
		}

		return res;
	}

	private static Map<String, Object> noOfSubstringWithKdistinctChars(String s, int kth) {
		// TODO Auto-generated method stub
		int res = 0;
		int count = 0;
		final int n = s.length();
		final int hash[] = new int[26];
		final String subs[] = new String[n * (n + 1) / 2];
		;
		// the idea is to keep a hashmap and use it to find the no of distinct chars in
		// the substring. assuming only 26 chars with small letters.
		for (int i = 0; i < n; i++) {
			Arrays.fill(hash, 0);
			count = 0;
			for (int j = i; j < n; j++) {
				// there are a total of n(n+1)/2 subtrings
				if (hash[s.charAt(j) - 'a'] == 0) {
					// this means we are encountering this element fo the first time.
					// in such case we will increament our counter of distinct chars
					count++;
					// also inc the value in hash table.
				}
				hash[s.charAt(j) - 'a']++;
				if (count == kth) {
					subs[res++] = s.substring(i, j + 1);
				}
			}
		}
		final HashMap<String, Object> map = new HashMap<>();
		map.put("num", res);
		map.put("substrings", subs);
		return map;
	}

	@Override
	public String toString() {
		return "this";
	}
}
