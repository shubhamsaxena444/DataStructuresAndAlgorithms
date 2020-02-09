package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
	private static class Heap {
		// array which represents heap. since it is a complete binary tree hence we can
		// represent it as an array.
		private final short[] a;
		// total capacity of the heap
		private final int CAPACITY;
		// current size of the heap.
		private int size;

		Heap(short arr[]) {
			a = arr;
			CAPACITY = a.length;
			size = CAPACITY;
		}

		// returns the index of left child of parent index
		public int getLChild(int p) {
			if (size - 1 >= 2 * p + 1) {
				return 2 * p + 1;
			} else {
				return -1;
			}
		}

		// returns the index of right child.
		public int getRChild(int p) {
			// TODO Auto-generated method stub
			if (size - 1 >= 2 * p + 2) {
				return 2 * p + 2;
			} else {
				return -1;
			}
		}

		// returns the index of parent .
		public int getParent(int l) {
			// TODO Auto-generated method stub
			if ((l - 1) / 2 >= 0) {
				return (l - 1) / 2;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		final byte T = sc.nextByte();
		final short input[][] = new short[T][];
		short N;
		for (short i = 0; i < T; i++) {
			N = sc.nextShort();
			input[i] = new short[N];
			for (short j = 0; j < N; j++) {
				input[i][j] = sc.nextShort();
			}

		}
		for (short i = 0; i < T; i++) {
			System.out.println(Arrays.toString(heapSort(input[i])));
		}
	}

	private static short[] heapSort(short arr[]) {
		// TODO Auto-generated method stub
		final int n = arr.length;
		if (n == 0) {
			return arr;
		}
		// represent array as the HEap.
		final Heap h = new Heap(arr);
		while (h.size > 1) {
			// this method creates a max heap if called multiple times of all parents in
			// bottom up manner. The last parent would be the parent of last element in
			// array i.e, size/2.
			buildHeap(h);
			// now we hae a heap ready.
			// System.out.println(Arrays.toString(h.a));
			// swap the max element i.e, root with last heap element
			swap(h.a, 0, h.size - 1);
			// decrease the size of the heap by 1
			h.size = h.size - 1;
			// repeat the same until size becomes 1
		}

		return h.a;
	}

	/**
	 * @param h
	 */
	private static void buildHeap(final Heap h) {
		for (int i = h.getParent(h.size - 1); i >= 0; i--) {
			heapify(h, i);
		}
	}

	// this method creates a max heap using bottom up approach and heapifying all
	// the children, i.e, i =size/2 ...size
	private static void heapify(Heap h, int root_index) {

		final int root = root_index;
		int max_index = root;
		// compare root with left child and right child and which is max , swap max with
		// root.
		final int l = h.getLChild(root);
		final int r = h.getRChild(root);
		// base condition:if only root is left.
		if (l == -1 && r == -1) {
			return;
		}
		if (l != -1 && h.a[root] < h.a[l]) {
			max_index = l;
		}
		if (r != -1 && h.a[max_index] < h.a[r]) {
			max_index = r;
		}
		// swap if max_index is not root;
		if (root != max_index) {
			swap(h.a, root, max_index);
			// repeat the same process affected subtree;
			heapify(h, max_index);
		}
	}

	private static void swap(short[] a, int root, int max_index) {
		final short t = a[root];
		a[root] = a[max_index];
		a[max_index] = t;
	}

}
