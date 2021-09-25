package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

	final static Map<Integer, String> store = new HashMap<>();

	public static void main(final String[] args) {
		final int maxLength = lengthOfLongestSubstring("abcrdfgnmklo");
		System.out.println(store.get(maxLength));
		System.out.println(maxLength);
	}

	public static int lengthOfLongestSubstring(final String s) {
		String sub = "";
		String tmp = "";
		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			if (sub.indexOf(s.charAt(i)) > -1) {
				if (sub.length() > max) {
					max = sub.length();
					store.put(max, sub);
				}
				tmp = s.substring(0, i);
				sub = s.substring(tmp.lastIndexOf(s.charAt(i)) + 1, i + 1);
			} else {

				sub += s.charAt(i);
			}
		}
		if (sub.length() > max) {
			max = sub.length();
			store.put(max, sub);
		}

		return max;
	}

}
