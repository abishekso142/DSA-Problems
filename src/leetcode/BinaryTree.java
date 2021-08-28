package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
	final int val;
	Node left;
	Node right;

	Node() {
		val = 0;
		left = right = null;
	}

	Node(final int val) {
		this.val = val;
		left = right = null;
	}
}

public class BinaryTree {

	public void preorder_recur(final Node root, final List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		preorder_recur(root.left, res);
		preorder_recur(root.right, res);
	}

	public void inorder_recur(final Node root, final List<Integer> res) {
		if (root == null)
			return;
		inorder_recur(root.left, res);
		res.add(root.val);
		inorder_recur(root.right, res);
	}

	public void postorder_recur(final Node root, final List<Integer> res) {
		if (root == null)
			return;
		postorder_recur(root.left, res);
		postorder_recur(root.right, res);
		res.add(root.val);
	}

	public List<Integer> preorder_iterate(final Node root) {
		final List<Integer> result = new ArrayList<>();

		final Stack<Node> st = new Stack<>();

		st.push(root);
		Node cur = null;
		while (!st.isEmpty()) {
			cur = st.pop();
			result.add(cur.val);
			if (cur.right != null) {
				st.push(cur.right);
			}
			if (cur.left != null) {
				st.push(cur.left);
			}
		}

		return result;
	}

	public List<Integer> inorder_iterate(final Node root) {
		final List<Integer> result = new ArrayList<>();

		final Stack<Node> st = new Stack<>();

		Node cur = root;
		while (cur != null || !st.isEmpty()) {
			if (cur != null) {
				st.push(cur);
				cur = cur.left;
			} else {
				cur = st.pop();
				result.add(cur.val);
				cur = cur.right;
			}
		}

		return result;
	}

	// TODO: Post order iterative Method

	public static void main(final String[] args) {
		final BinaryTree tree = new BinaryTree();

		final Node n1 = new Node(1);
		final Node n2 = new Node(2);
		final Node n3 = new Node(3);
		final Node n4 = new Node(4);
		final Node n5 = new Node(5);
		final Node n6 = new Node(6);
		final Node n7 = new Node(7);
		final Node n8 = new Node(8);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;
		n4.left = n6;

		n3.left = n8;
		n3.right = n7;

		List<Integer> res = new ArrayList<>();
		tree.preorder_recur(n1, res);
		printList(res);

		res.clear();
		res = tree.preorder_iterate(n1);
		printList(res);

		res.clear();
		tree.inorder_recur(n1, res);
		printList(res);

		res.clear();
		res = tree.inorder_iterate(n1);
		printList(res);

		res.clear();
		tree.postorder_recur(n1, res);
		printList(res);

	}

	private static void printList(final List<Integer> res) {
		res.forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println();
	}

}
