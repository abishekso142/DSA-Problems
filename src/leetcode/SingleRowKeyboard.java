package leetcode;

//https://leetcode.com/problems/single-row-keyboard/
public class SingleRowKeyboard {

	public static void main(final String[] args) {
		System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
	}

	public static int calculateTime(final String keyboard, final String word) {
		char c;
		int x = 0;
		int time = 0;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			time += Math.abs(x - keyboard.indexOf(c));
			x = keyboard.indexOf(c);
		}
		return time;
	}

}
