package leetcode;

//https://leetcode.com/problems/add-two-numbers/
public class Add2Numbers {

	public static void main(final String[] args) {
		final ListNode l1_03 = new ListNode(3, null);
		// , l1_02 = new ListNode(4, l1_03), l1_01 = new ListNode(2, l1_02);
		final ListNode l2_06 = new ListNode(9, null), l2_05 = new ListNode(9, l2_06);
		/*
		 * , l2_04 = new ListNode(9, l2_05), l2_03 = new ListNode(9, l2_04), l2_02 = new
		 * ListNode(9, l2_03), l2_01 = new ListNode(9, l2_02);
		 */

		final ListNode result = getSum(l1_03, l2_05);
		result.printList(result);

	}

	public static ListNode getSum(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode();
		final ListNode tmp = new ListNode(0, l3);
		int quo = 0;
		while ((l1 != null || l2 != null || quo != 0) && l3 != null) {
			final int l1val = l1 == null ? 0 : l1.val;
			final int l2val = l2 == null ? 0 : l2.val;
			l3.val = (quo + l1val + l2val) % 10;
			quo = (quo + l1val + l2val) / 10;

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;

			if (l1 != null || l2 != null || quo != 0) {
				l3.next = new ListNode();
			} else {
				l3.next = null;
			}
			l3 = l3.next;

		}

		return tmp.next;

	}

}

class ListNode {

	int val;
	ListNode next;

	ListNode() {
		val = 0;
		next = null;
	}

	ListNode(final int val, final ListNode next) {
		this.val = val;
		this.next = next;
	}

	void printList(ListNode l) {
		while (l != null) {
			System.out.print(l.val + " -> ");
			l = l.next;
		}
	}

}
