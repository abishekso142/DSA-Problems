package leetcode;

public class NumOfNumbersWithEvenDigits {

	public static void main(final String[] args) {
		System.out.println(findNumbers(new int[] { 123, 56, 78, 0, 876, 7678, 34567 }));
	}

	public static int findNumbers(final int[] nums) {
		int evenctr = 0;
		for (int num : nums) {
			int ctr = 1;
			while (num / 10 != 0) {
				num = num / 10;
				ctr++;
			}
			if (ctr % 2 == 0) {
				evenctr++;
			}
		}
		return evenctr;
	}

}
