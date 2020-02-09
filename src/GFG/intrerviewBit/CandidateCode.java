package intrerviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class bool {
	boolean isSingleChild = false;

}

class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> prev;

	public Node() {
	}

	public Node(T data1) {
		this.setData(data1);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

}

class BinaryTree<T> {
	public Node<T> root;

	// this method returns the number of leaf nodes in a tree given the root
	int leafPrint(Node<T> root2) {
		return leafCountUtil(root2);
	}

	public void preorder(Node<T> root) {
		if (root == null) {
			return;
		}
		// if(tree.root.getRight() == null && tree.root.getLeft() ==null)
		// {
		System.out.println(root.getData());
		// }
		preorder(root.getPrev());
		preorder(root.getNext());

	}

	/**
	 * @param root2
	 * @param count
	 */
	private int leafCountUtil(Node<T> root2) {
		final Node<T> cur = root2;
		if (cur == null) {
			return 0;
		} else if (cur.getPrev() == null && cur.getNext() == null) {

			return 1;
		} else {
			return leafCountUtil(cur.getPrev()) + leafCountUtil(cur.getNext());
		}
	}

	// this method returns the node in which x exists
	public Node<T> findNode(Node<T> root, T x, bool bool) {

		final Node<T> p = null;

		return findNodeUtil(x, root, p, bool);

	}

	/**
	 * @param x
	 * @param f
	 * @param cur
	 * @return
	 */
	private Node<T> findNodeUtil(T x, Node<T> root, Node<T> p, bool b) {
		Node<T> f = null;

		if (root == null) {
			return null;
		} else if (root.getData().equals(x)) {
			if (p != null
					&& (p.getNext() != null && p.getPrev() == null || p.getNext() == null && p.getPrev() != null)) {
				b.isSingleChild = true;
			}
			return root;
		}
		final Node<T> cur = root;
		if (cur.getPrev() != null) {
			p = cur;
			f = findNodeUtil(x, cur.getPrev(), p, b);
		}
		if (f == null && cur.getNext() != null) {
			p = cur;
			f = findNodeUtil(x, cur.getNext(), p, b);
		}
		return f;
	}

	public void levelOrderInsert(T i, T a) {
		final Queue<Node<T>> q = new LinkedList<>();
		if (root == null) {
			root = new Node<T>(i);
			return;
		}
		q.offer(root);
		while (!q.isEmpty()) {
			final Node<T> tmp = q.poll();
			if (tmp.getPrev() != null) {
				q.offer(tmp.getPrev());
			} else if (tmp.getData().equals(a)) {
				tmp.prev = new Node<T>(i);
				return;
			}
			if (tmp.getNext() != null) {
				q.offer(tmp.getNext());
			} else if (tmp.getData().equals(a)) {
				tmp.next = new Node<T>(i);
				return;
			}
		}
	}

}

class Pair {

	short a;
	short i;

	public Pair(short a, short i) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.i = i;
	}
}

public class CandidateCode {

	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);
		final short N = sc.nextShort();
		final List<Pair> l = new ArrayList<>();
		for (short i = 0; i < N; i++) {
			l.add(new Pair(sc.nextShort(), i));
		}
		// sort a;
		Collections.sort(l, (x, y) -> x.a - y.a);
		final BinaryTree<Short> bt = new BinaryTree<>();
		for (int i = 0; i < N; i++) {
			bt.levelOrderInsert(l.get(i).i, l.get(i).a);
		}
		final Short X = sc.nextShort();
		sc.close();
		// bt.preorder(bt.root);
		final bool b = new bool();
		final int x = bt.leafPrint(bt.root);
		final int y = bt.leafPrint(bt.findNode(bt.root, X, b));
		if (b.isSingleChild) {
			System.out.println(x - y + 1);
		} else {
			System.out.println(x - y);
		}
	}

}
