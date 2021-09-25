package leetcode;

//https://leetcode.com/problems/valid-mountain-array/
public class MountainArray {

	public static void main(final String[] args) {
		final int arr[] = { 0, 3, 2, 1 };
		System.out.println(validMountainArray(arr));

	}

	public static boolean validMountainArray(final int[] arr) {

		Integer max = null;
		Integer min = null;
		int i = 1;
		while (i < arr.length && arr[i] > arr[i - 1]) {
			max = arr[i];
			i++;
		}

		if ((i == arr.length) || max == null) {
			return false;
		}

		while (i < arr.length && arr[i] < arr[i - 1]) {
			min = arr[i];
			i++;
		}

		if (min == null || i != arr.length) {
			return false;
		}

		return true;
	}

}
