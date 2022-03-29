package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
public class MyLinkedList {
	Node head;

	MyLinkedList() {
		head = new Node();
	}

	MyLinkedList(final int val) {
		head = new Node(val);
	}

	public int get(final int index) {
		int ctr = 0;
		Node temp = head;
		while (temp != null) {
			if (index == ctr) {
				return temp.val;
			}
			ctr++;
			temp = temp.next;
		}
		return -1;
	}

	public void addAtHead(final int val) {
		final Node n1 = new Node(val);
		n1.next = head;
		head = n1;
	}

	public void addAtTail(final int val) {
		Node temp = head;
		while (temp.next != null) {
			temp = head.next;
		}
		final Node n1 = new Node(val);
		temp.next = n1;
	}

	public void addAtIndex(final int index, final int val) {
		if (index < 0) {
			return;
		} else if (index == 0) {
			addAtHead(val);
		} else {
			int ctr = 0;
			Node temp = head;
			while (temp != null) {
				if (ctr == index - 1) {
					final Node n1 = new Node(val);
					final Node temp2 = temp.next;
					temp.next = n1;
					n1.next = temp2;
					return;
				}
				ctr++;
				temp = temp.next;
			}
		}
	}

	public void deleteAtIndex(final int index) {
		if (index < 0) {
			return;
		} else if (index == 0) {
			head = head.next;
		} else {
			Node temp = head;
			int ctr = 0;
			while (temp != null && temp.next != null) {
				if (ctr == index - 1) {
					temp.next = temp.next.next;
					return;
				}
				temp = temp.next;
				ctr++;
			}
		}
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void removeNthNodeFromEnd(final int n) {
		final Map<Integer, Node> map = new HashMap<>();
		Node curr = head;
		int len = 0;
		while (curr != null) {
			map.put(len, curr);
			len++;
			curr = curr.next;
		}

		if (n < 1 || n > len) {
			return;
		}

		final Node prev = map.get(len - n - 1);
		final Node rem = map.get(len - n);
		if (prev != null) {
			prev.next = rem.next;
		} else {
			return;
		}

	}

	public void reverseIterative() {

		Node cur = head;
		Node prev = null;
		Node tmp = null;

		while (cur != null) {
			tmp = cur.next;
			cur.next = prev;

			prev = cur;
			cur = tmp;

		}

		head = prev;

	}

	public void reverseRecursive() {

	}

	public void reverseUsingStack() {
		final Stack<Node> s = new Stack<>();
		Node temp = head;
		while (temp.next != null) {
			s.add(temp);
			temp = temp.next;
		}
		head = temp;
		while (!s.isEmpty()) {
			temp.next = s.pop();
			temp = temp.next;
		}
		temp.next = null;
	}

	public void removeElement(final int val) {
		if (head.val == val) {
			head = head.next;
		}
		Node cur = head;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == val) {
				cur.next.next = cur.next.next.next;
			}
			cur = cur.next;
		}

	}

	public static void main(final String[] args) {
		final MyLinkedList obj = new MyLinkedList();
		obj.display();

		obj.addAtHead(3);
		obj.display();

		obj.addAtTail(5);
		obj.display();

		obj.addAtIndex(-1, 7);
		obj.display();

		obj.addAtIndex(0, 8);
		obj.display();

		obj.addAtIndex(2, 4);
		obj.display();

		obj.addAtIndex(4, 1);
		obj.display();

		obj.addAtIndex(6, 6);
		obj.display();

		obj.deleteAtIndex(0);
		obj.display();

		obj.deleteAtIndex(3);
		obj.display();

		obj.deleteAtIndex(4);
		obj.display();

		obj.deleteAtIndex(4);
		obj.display();

		/*
		 * System.out.println(obj.get(-2)); System.out.println(obj.get(0));
		 * System.out.println(obj.get(2)); System.out.println(obj.get(3));
		 * System.out.println(obj.get(7));
		 */

		obj.removeNthNodeFromEnd(0);
		obj.display();

		obj.reverseIterative();
		obj.display();

		obj.reverseUsingStack();
		obj.display();
	}

	public static MyLinkedList getSampleLinkedList() {
		final MyLinkedList obj = new MyLinkedList();

		obj.addAtHead(3);
		obj.addAtTail(5);
		obj.addAtIndex(0, 8);
		obj.addAtIndex(2, 4);
		obj.addAtIndex(4, 1);
		obj.addAtIndex(6, 6);

		return obj;

	}

}

class Node {
	int val;
	Node next;

	Node() {
		val = 0;
		next = null;
	}

	Node(final int val) {
		this.val = val;
		next = null;
	}

	Node(final int val, final Node next) {
		this.val = val;
		this.next = next;
	}
}
