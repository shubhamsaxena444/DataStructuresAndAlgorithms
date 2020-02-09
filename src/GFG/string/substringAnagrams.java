package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class substringAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Scanner sc = new Scanner(System.in);
		final String str = sc.nextLine();
		System.out.println(substringAnagrams(str));
	}

	private static int substringAnagrams(String str) {
		int res = 0;
		int i, j;
		final Map<String, String> codemap = new HashMap<>();
		final int n = str.length();
		for (i = 0; i < n; i++) {

			for (j = i; j < n; j++) {
				final String key = getCode(str, i, j);
				if (codemap.get(key) == null) {
					codemap.put(key, str.substring(i, j + 1));
				} else {
					res++;
					System.out.println("pair :" + codemap.get(key) + "  " + str.substring(i, j + 1));
				}

			}
		}

		return res;
	}

	private static String getCode(String str, int i, int j) {
		final StringBuilder sb = new StringBuilder("");
		final int count[] = new int[26];
		for (int l = i; l <= j; l++) {
			count[str.charAt(l) - 'a']++;
		}
		for (int k = 0; k < 26; k++) {
			if (count[k] != 0) {
				sb.append(k + 'a');
				sb.append(count[k]);
			}
		}
		return sb.toString();
	}

}
