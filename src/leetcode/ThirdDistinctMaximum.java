package leetcode;

import java.util.TreeSet;

//https://leetcode.com/problems/third-maximum-number/
public class ThirdDistinctMaximum {

	public static void main(final String[] args) {
		final int arr[] = { 3, 1, 2 };
		final int max3 = thirdMax(arr);
		System.out.println(max3);
	}

	public static int thirdMax(final int[] nums) {

		final TreeSet<Integer> tree = new TreeSet<>();
		for (final int i : nums) {
			tree.add(i);
		}
		if (tree.size() >= 3) {
			tree.remove(tree.last());
			tree.remove(tree.last());
			return tree.last();
		}
		return tree.last();
	}

}
