package leetcode;

public class PerformOperations {

	public static void main(final String[] args) {
		final String[] ops = { "--X", "X++", "X++" };
		System.out.println(finalValueAfterOperations(ops));
	}

	public static int finalValueAfterOperations(final String[] operations) {
		int i = 0;
		for (int j = 0; j < operations.length; j++) {
			final String op = operations[j];
			switch (op) {
			case "X++":
			case "++X":
				i = i + 1;
				break;
			case "X--":
			case "--X":
				i = i - 1;
				break;
			}
		}
		return i;

	}

}
