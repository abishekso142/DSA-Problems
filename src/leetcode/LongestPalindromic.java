package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromic {

	public static void main(final String[] args) {

		System.out.println(longestPalindrome("abba"));
	}

	public static String longestPalindrome(final String s) {
		String pal = new String(new char[] { s.charAt(0) });
		int max = 0;
		final Map<Integer, String> store = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				pal = s.substring(i, i + 2);
				System.out.println(pal);
				store.put(pal.length(), pal);
				if (pal.length() > max) {
					max = pal.length();
				}
			}
			for (int j = 1; j <= i && j < s.length() - i; j++) {
				if (s.charAt(i - j) == s.charAt(i + j)) {
					pal = s.substring(i - j, i + j + 1);
					store.put(pal.length(), pal);
					System.out.println(pal);
					if (pal.length() > max) {
						max = pal.length();
					}

				}

				else {
					break;
				}

			}
		}
		System.out.println();
		return store.get(max) == null ? pal : store.get(max);
	}

}
