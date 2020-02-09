package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxProdunctLengthFreqSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Scanner sc = new Scanner(System.in);
		final String str = sc.nextLine();
		System.out.println(maxProduct(str));
	}

	private static int maxProduct(String str) {
		int max_prod = -1;
		int i, j;
		final Map<String, Integer> codemap = new HashMap<>();
		final int n = str.length();
		for (i = 0; i < n; i++) {

			for (j = i; j < n; j++) {
				if (codemap.get(str.substring(i, j + 1)) == null) {
					codemap.put(str.substring(i, j + 1), 1);
				} else {
					codemap.put(str.substring(i, j + 1), codemap.get(str.substring(i, j + 1)) + 1);
				}
				if ((j - i + 1) * codemap.get(str.substring(i, j + 1)) > max_prod) {
					max_prod = (j - i + 1) * codemap.get(str.substring(i, j + 1));
				}
			}
		}
		return max_prod;
	}

}
