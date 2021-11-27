package leetcode;

//https://leetcode.com/problems/split-a-string-in-balanced-strings/
public class BalancedStrings {

	public static void main(final String[] args) {
		System.out.println(balancedStringSplit("RLRRLLRLRL"));
		System.out.println(balancedStringSplit("RLLLLRRRLR"));
		System.out.println(balancedStringSplit("LLLLRRRR"));
		System.out.println(balancedStringSplit("RLRRRLLRLL"));
	}

	public static int balancedStringSplit(final String s) {
		int l_ctr = 0, r_ctr = 0, ctr = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'L') {
				l_ctr++;
			} else {
				r_ctr++;
			}
			if (l_ctr == r_ctr) {
				ctr++;
				l_ctr = r_ctr = 0;
			}
		}
		return ctr;
	}

}
