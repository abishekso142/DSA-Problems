
package leetcode;

//https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class TreeNode {
	final int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
		val = 0;
		left = right = null;
	}

	TreeNode(final int val) {
		this.val = val;
		left = right = null;
	}
}

public class BinaryTree {

	public void preorder_recur(final TreeNode root, final List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		preorder_recur(root.left, res);
		preorder_recur(root.right, res);
	}

	public void inorder_recur(final TreeNode root, final List<Integer> res) {
		if (root == null)
			return;
		inorder_recur(root.left, res);
		res.add(root.val);
		inorder_recur(root.right, res);
	}

	public void postorder_recur(final TreeNode root, final List<Integer> res) {
		if (root == null)
			return;
		postorder_recur(root.left, res);
		postorder_recur(root.right, res);
		res.add(root.val);
	}

	public List<Integer> preorder_iterate(final TreeNode root) {
		final List<Integer> result = new ArrayList<>();

		final Stack<TreeNode> st = new Stack<>();

		st.push(root);
		TreeNode cur = null;
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

	public List<Integer> inorder_iterate(final TreeNode root) {
		final List<Integer> result = new ArrayList<>();

		final Stack<TreeNode> st = new Stack<>();

		TreeNode cur = root;
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

		final TreeNode n1 = new TreeNode(1);
		final TreeNode n2 = new TreeNode(2);
		final TreeNode n3 = new TreeNode(3);
		final TreeNode n4 = new TreeNode(4);
		final TreeNode n5 = new TreeNode(5);
		final TreeNode n6 = new TreeNode(6);
		final TreeNode n7 = new TreeNode(7);
		final TreeNode n8 = new TreeNode(8);

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

		// res.forEach(i -> System.out.print(i + " "));

		final Iterator<Integer> it = res.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}

		for (final Integer x : res) {
			System.out.print(x + " ");
		}

		System.out.println();
		System.out.println();
	}

}
