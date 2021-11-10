package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TripletSum {

	public static void main(final String[] args) {
		final int res[][] = tripletSum(new int[] { 1, 3, 3, 4, 2, 4 }, 10);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i] != null ? res[i][0] + "," + res[i][1] + "," + res[i][2] : "Not found");
		}
	}

	public static int[][] tripletSum(final int[] nums, final int target) {

		final int arr[][] = new int[10][3];
		final Map<Integer, Integer> ht = new HashMap<>();
		int ctr = 0;
		for (int j = 0; j < nums.length; j++) {
			final int twoSum = target - nums[j];
			ht.clear();
			for (int i = j + 1; i < nums.length; i++) {
				if (ht.containsKey(twoSum - nums[i])) {
					arr[ctr][0] = nums[j];
					arr[ctr][1] = twoSum - nums[i];
					arr[ctr][2] = nums[i];
					ctr++;
				} else {
					ht.put(nums[i], i);
				}
			}
		}

		return arr;
	}
}