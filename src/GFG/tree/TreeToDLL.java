package tree;

import linkedList.DoublyLinkedList;
import linkedList.Node;

public class TreeToDLL<T> {

	public DoublyLinkedList<T> treeToDLL(Node<T> root) {

		if (root == null) {
			return null;
		}

		if (root.prev != null) {
			// recursively convert left subtree.
			treeToDLL(root.prev);
			// find predecessor
			final Node<T> predecessor = pred(root.prev);
			// connect to root if pred is not null
			if (predecessor != null) {
				predecessor.next = root;
				root.prev = predecessor;
			}
		}

		if (root.next != null) {
			// recursively convert right subtree.
			treeToDLL(root.next);
			// find successor
			final Node<T> successor = succ(root.next);
			// connect to root if pred is not null
			if (successor != null) {
				successor.prev = root;
				root.next = successor;
			}
		}
		while (root.prev != null) {
			root = root.prev;
		}
		return new DoublyLinkedList<T>(root);
	}

	private Node<T> succ(Node<T> root) {
		if (root == null) {
			return root;
		}
		while (root.prev != null) {
			root = root.prev;
		}
		return root;
	}

	private Node<T> pred(Node<T> root) {
		if (root == null) {
			return root;
		}
		while (root.next != null) {
			root = root.next;
		}
		return root;
	}

	public DoublyLinkedList<T> usingInorderWithPrev(Node<T> root) {

		if (root == null) {
			return null;
		}

		Node<T> cur = usingInorderWithPrevUtil(root, null);
		while (cur.prev != null) {
			cur = cur.prev;
		}
		return new DoublyLinkedList<>(cur);

	}

	private Node<T> usingInorderWithPrevUtil(Node<T> root, Node<T> prev) {

		if (root == null || root.prev == null && root.next == null) {
			return root;
		}
		usingInorderWithPrevUtil(root.prev, prev);
		if (prev != null) {
			root.prev = prev;
			prev.next = root;
		}
		prev = root;

		usingInorderWithPrevUtil(root.next, prev);
		return root;
	}
}
