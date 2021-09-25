package leetcode;

public class Node1 {
	int val;
	Node1 next;

	Node1() {
		val = 0;
		next = null;
	}

	Node1(final int val) {
		this.val = val;
		next = null;
	}

	Node1(final int val, final Node1 next) {
		this.val = val;
		this.next = next;
	}
}
