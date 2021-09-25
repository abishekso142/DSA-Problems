package leetcode;

//https://leetcode.com/problems/remove-element/
public class RemoveElementsFromArray {

	public static void main(final String[] args) {
		final int num[] = { 0, 1, 2, 2, 3, 0, 4, 2 };
		final int k = removeElement(num, 2);

		System.out.println(k);
		displayArray(num);
	}

	// Brute force MAX
	public static int removeElement(final int[] nums, final int val) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val || nums[i] == 'z') {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] != val && nums[j] != 'z') {
						nums[i] = nums[j];
						nums[j] = 'z';
						break;
					}
				}
			}
		}
		for (int x = 0; x < nums.length; x++) {
			if (nums[x] == val || nums[x] == 'z') {
				return x;
			}
		}
		return nums.length;

	}

	// Nicer way, Less time complexity
	public static int removeElement1(final int[] nums, final int val) {

		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				// reduce array size by one
				n--;
			} else {
				i++;
			}
		}

		// Only needed if rest of array has to be filled with some random character,
		// optional in leetcode
		while (n < nums.length) {
			nums[n++] = 'z';
		}
		return n;
	}

	private static void displayArray(final int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
