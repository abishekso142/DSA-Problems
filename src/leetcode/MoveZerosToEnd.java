package leetcode;

public class MoveZerosToEnd {

	public static void main(final String[] args) {
		final int arr[] = { 1, 0, 0, 3, 0, 5, 0 };
		display(moveZeroes(arr));
	}

	public static int[] moveZeroes(final int[] arr) {

		int wp = 0;
		for (int rp = 0; rp < arr.length; rp++) {
			if (arr[rp] != 0) {
				arr[wp] = arr[rp];
				wp++;
			}
		}

		for (int i = wp; i < arr.length; i++) {
			arr[i] = 0;
		}
		return arr;
	}

	private static void display(final int[] arr) {
		for (final int i : arr) {
			System.out.print(i + " ");
		}
	}

}
