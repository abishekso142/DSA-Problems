package leetcode;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
//https://leetcode.com/problems/linked-list-cycle/

class Node3 {
	int val;
	Node3 next;

	Node3() {
		val = 0;
		next = null;
	}

	Node3(final int val) {
		this.val = val;
		next = null;
	}

	Node3(final int val, final Node3 next) {
		this.val = val;
		this.next = next;
	}
}

public class LinkedListCycleAndIntersection {

	public static void main(final String[] args) {

	}

	public static boolean hasCycle(final Node3 n1) {
		Node3 slow;
		Node3 fast;
		slow = fast = n1;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public static Node3 getIntersectionNode(final Node3 n1, final Node3 n2) {
		Node3 p1;
		Node3 p2;
		p1 = n1;
		p2 = n2;

		while (p1 != p2) {

			/*
			 * if (p1 == null) { p1 = n2; } else { p1 = p1.next; } if (p2 == null) { p2 =
			 * n1; } else { p2 = p2.next; }
			 */

			p1 = p1 == null ? n2 : p1.next;
			p2 = p2 == null ? n1 : p2.next;
		}

		return p1;
	}

}
