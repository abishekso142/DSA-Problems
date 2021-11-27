package leetcode;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStones {

	public static void main(final String[] args) {
		System.out.print(numJewelsInStones("zz", "ZZZ"));

	}

	public static int numJewelsInStones(final String jewels, final String stones) {
		int ctr = 0;
		for (int i = 0; i < jewels.length(); i++) {
			final char c = jewels.charAt(i);
			for (int j = 0; j < stones.length(); j++) {
				if (stones.charAt(j) == c) {
					ctr++;
				}
			}

		}
		return ctr;
	}

}
