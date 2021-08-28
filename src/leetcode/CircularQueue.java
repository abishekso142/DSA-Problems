package leetcode;

public class CircularQueue {

	int[] arr;
	int start, end;

	CircularQueue(final int k) {
		arr = new int[k];
		start = end = 0;
	}

	public boolean enQueue(final int value) {

		arr[start++] = value;
	}

	public static void main(final String[] args) {
		// TODO Auto-generated method stub

	}

}
