package leetcode;

public class ReplaceElementsWithGreatestRightElements {

	public static void main(final String[] args) {
		final int arr[] = { 17, 18, 5, 4, 6, 1 };
		display(replaceElements(arr));
	}

	public static int[] replaceElements(final int[] arr) {
		int max;
		int i;
		for (i = 0; i < arr.length - 1; i++) {
			max = arr[i + 1];
			for (int j = i + 2; j < arr.length; j++) {
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			arr[i] = max;
		}
		arr[i] = -1;
		return arr;
	}

	private static void display(final int[] arr) {
		for (final int i : arr) {
			System.out.print(i + " ");
		}
	}

}
