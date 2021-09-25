package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberAndDouble {

	public static void main(final String[] args) {

		final int arr[] = { 2, 3, 5, 5 };
		System.out.println(checkIfExist1(arr));
	}

	// Brute
	public static boolean checkIfExist(final int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if ((arr[i] == 2 * arr[j]) || (arr[j] == 2 * arr[i])) {
					return true;
				}

			}

		}
		return false;
	}

	// Using set
	public static boolean checkIfExist1(final int[] arr) {
		final Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(2 * arr[i]) || (((arr[i] % 2) == 0) && set.contains(arr[i] / 2))) {
				return true;
			} else {
				set.add(arr[i]);
			}

		}
		return false;
	}

}
