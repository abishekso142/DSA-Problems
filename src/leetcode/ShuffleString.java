package leetcode;

//https://leetcode.com/problems/shuffle-string/
public class ShuffleString {

	public static void main(final String[] args) {
		final String s = "aiohn";
		final int indices[] = { 3, 1, 4, 2, 0 };
		System.out.println(restoreString(s, indices));
	}

	public static String restoreString(final String s, final int[] indices) {
		final char arr[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[indices[i]] = s.charAt(i);
		}
		return new String(arr);
	}

}
