package leetcode;

public class RemoveVowelsFromString {

	public static void main(final String[] args) {
		System.out.println(removeVowels("leetcodeisacommunityforcoders"));
	}

	public static String removeVowels(final String s) {
		final StringBuffer newString = new StringBuffer("");
		for (int i = 0; i < s.length(); i++) {
			final char ch = s.charAt(i);
			if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
				newString.append(ch);
			}
		}
		return newString.toString();
	}
}
