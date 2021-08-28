package leetcode;

public class MergeSortedArrays {

	public static void main(final String[] args) {
		final int[] nums1 = { 1 };
		final int[] nums2 = {};
		merge(nums1, 1, nums2, 0);

		for (int i = 0; i < nums1.length; i++) {
			System.out.println(nums1[i] + " ");
		}

	}

	public static void merge(final int[] nums1, final int m, final int[] nums2, final int n) {

		int p1 = m - 1, p2 = n - 1;
		for (int p3 = m + n - 1; p3 >= 0; p3--) {
			if (p2 < 0) {
				break;
			}
			if (p1 >= 0 && nums1[p1] >= nums2[p2]) {
				nums1[p3] = nums1[p1];
				p1--;
			} else {
				nums1[p3] = nums2[p2];
				p2--;
			}
		}

	}

}
