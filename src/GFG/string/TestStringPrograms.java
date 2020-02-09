package strings;

import java.util.Scanner;

public class TestStringPrograms {
	public static final int asscii = 256;

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		final String str = sc.nextLine();
		final String pat = sc.nextLine();
		System.out.println(minWindowExactlyTwice(str, pat));
	}

	private static String minWindow(String str, String pat) {
		final int strl = str.length();
		final int patl = pat.length();
		if (strl < patl) {
			return "false";
		}
		int count = 0;
		int start = 0;
		int start_in = -1;
		int window_size;
		int min_length = Integer.MAX_VALUE;
		final int hash_str[] = new int[asscii];
		final int hash_pat[] = new int[asscii];
		for (int i = 0; i < patl; i++) {
			hash_pat[pat.charAt(i)]++;
		}
		for (int j = 0; j < strl; j++) {
			hash_str[str.charAt(j)]++;
			if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)]) {
				count++;
			}
			if (count == patl) {
				// try to minmize the window size
				while (hash_pat[str.charAt(start)] == 0 || hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {
					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {
						hash_str[str.charAt(start)]--;
					}
					start++;
				}
				window_size = j - start + 1;
				if (min_length > window_size) {
					min_length = window_size;
					start_in = start;
				}

			}
		}
		return str.substring(start_in, start_in + min_length);
	}

	private static String minWindowExactlyTwice(String str, String pat) {
		final int strl = str.length();
		final int patl = pat.length();
		if (strl < patl) {
			return "false";
		}
		int count = 0;
		int start = 0;
		int start_in = -1;
		int window_size;
		int min_length = Integer.MAX_VALUE;
		final int hash_str[] = new int[asscii];
		final int hash_pat[] = new int[asscii];
		for (int i = 0; i < patl; i++) {
			hash_pat[pat.charAt(i)]++;
		}
		for (int j = 0; j < strl; j++) {
			hash_str[str.charAt(j)]++;
			if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= 2 * hash_pat[str.charAt(j)]) {
				count++;
			}
			if (count == 2 * patl) {
				// try to minmize the window size
				while (hash_pat[str.charAt(start)] == 0
						|| hash_str[str.charAt(start)] > 2 * hash_pat[str.charAt(start)]) {
					if (hash_str[str.charAt(start)] > 2 * hash_pat[str.charAt(start)]) {
						hash_str[str.charAt(start)]--;
					}
					start++;
				}
				window_size = j - start + 1;
				if (min_length > window_size) {
					min_length = window_size;
					start_in = start;
				}

			}
		}
		if (start_in != -1) {
			return str.substring(start_in, start_in + min_length);
		} else {
			return "fasle";
		}
	}

}
