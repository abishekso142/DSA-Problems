package leetcode;

//https://leetcode.com/problems/sort-array-by-parity/
public class SortByParity {

	public static void main(final String[] args) {
		final int arr[] = { 3, 1, 2, 4, 0, 4, 7 };
		display(sortArrayByParity(arr));
	}

	public static int[] sortArrayByParity(final int[] nums) {

		int wp = 0;
		for (int rp = 0; rp < nums.length; rp++) {
			if (nums[rp] % 2 == 0) {
				swap(nums, rp, wp);
				wp++;
			}
		}

		return nums;
	}

	private static void swap(final int[] nums, final int rp, final int wp) {
		final int temp = nums[wp];
		nums[wp] = nums[rp];
		nums[rp] = temp;
	}

	private static void display(final int[] arr) {
		for (final int i : arr) {
			System.out.print(i + " ");
		}
	}

}
