package leetcode;

public class RemoveDuplicates {

	public static void main(final String[] args) {

		final int num[] = { 0, 1, 2, 2, 3, 3, 4, 5 };

		// A not-in-place soln final using collections :-)
		/*
		 * final TreeSet<Integer> tr = new TreeSet<>(); for (final int x : num) {
		 * tr.add(x); } Integer arr[] = new Integer[num.length]; arr = tr.toArray(arr);
		 * displayArray(arr);
		 */

		// The result is always the part of array from 0 to k-1, rest can be
		// duplicates/old values in place
		final int k = removeDupElement(num);
		System.out.println(k);
		displayArray(num);
	}

	public static int removeDupElement(final int[] nums) {

		int slow = 0;
		for (int fast = 1; fast < nums.length; fast++) {
			if (nums[slow] != nums[fast]) {
				slow++;
				nums[slow] = nums[fast];
			}
		}

		return slow + 1;

	}

	private static void displayArray(final Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void displayArray(final int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
