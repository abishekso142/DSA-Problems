package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

	public static void main(final String[] args) {
		final int res[] = twoSum(new int[] { 1, 3, 3, 4 }, 5);
		System.out.println(res != null ? res[0] + "," + res[1] : "Not found");

	}

	public static int[] twoSum(final int[] nums, final int target) {
//        final int arr[] = new int[2];
//        for (int i = 0; i < nums.length - 1; i++)
//        {
//            for (int j = i + 1; j < nums.length; j++)
//            {
//                if (nums[i] + nums[j] == target)
//                {
//                    arr[0] = i;
//                    arr[1] = j;
//                    return arr;
//                }
//            }
//        }
//        return null;

		final int arr[] = new int[2];
		final Map<Integer, Integer> ht = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (ht.containsKey(target - nums[i])) {
				arr[0] = ht.get(target - nums[i]);
				arr[1] = i;
				return arr;
			} else {
				ht.put(nums[i], i);
			}
		}
		return null;
	}

}
