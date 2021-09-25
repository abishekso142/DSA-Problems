package leetcode;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SortedArraySqaures {

	public static void main(final String[] args) {
		final int[] arr = { -1 };
		sortedSquares(arr);
	}

	public static int[] sortedSquares(final int[] nums) {

		int i = 0;
		while (nums[i] < 0 && i < nums.length) {
			i++;
		}

		int pos_ptr = i;
		int neg_ptr = i - 1;
		final int[] squares = new int[nums.length];
		int j = 0;
		while (pos_ptr < nums.length && neg_ptr >= 0) {
			if (((-1) * nums[neg_ptr]) < nums[pos_ptr]) {
				squares[j++] = nums[neg_ptr] * nums[neg_ptr];
				neg_ptr--;
			} else {
				squares[j++] = nums[pos_ptr] * nums[pos_ptr];
				pos_ptr++;
			}
		}

		while (pos_ptr < nums.length) {
			squares[j++] = nums[pos_ptr] * nums[pos_ptr];
			pos_ptr++;
		}

		while (neg_ptr >= 0) {
			squares[j++] = nums[neg_ptr] * nums[neg_ptr];
			neg_ptr--;
		}

		return squares;

	}

}
