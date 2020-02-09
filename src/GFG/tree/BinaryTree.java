package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import tree.TestBinaryTree.bool;

public class BinaryTree<T> implements Tree<T> {
	public Node<T> root;

	@Override
	public void preorder(Node<T> root) {
		if (root == null) {
			return;
		}
		// if(tree.root.getRight() == null && tree.root.getLeft() ==null)
		// {
		System.out.println(root.getData());
		// }
		preorder(root.getLeft());
		preorder(root.getRight());

	}

	@Override
	public void postorder(Node<T> root) {
		if (root == null) {
			return;
		}
		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.println(root.getData());

	}

	@Override
	public void postorderIterative(Node<T> root) {
		if (root == null) {
			return;
		}
		Node<T> p = null;
		Node<T> cur = root;
		final Stack<Node<T>> s = new Stack<>();
		// initialize with root elemt.
		s.push(cur);
		while (!s.isEmpty()) {
			// there are three conditions,
			// if cur is the child of p, then push cur.left,cur.right
			// if p is the left child of current,check for right of cur ,push to stack
			// if p is the right child of cur, print p
			// store in stack untill left exists.
			if (p == null || p.getLeft() == cur || p.getRight() == cur) {
				if (cur.getLeft() != null) {
					s.push(cur.getLeft());
					p = cur;
					cur = cur.getLeft();

				} else if (cur.getRight() != null) {
					s.push(cur.getRight());
					p = cur;
					cur = cur.getRight();

				} else {
					final Node<T> tmp = s.pop();
					System.out.println(tmp.getData());
					cur = s.peek();
					p = tmp;
				}

			} else if (cur.getLeft() == p) {
				if (cur.getRight() != null) {
					s.push(cur.getRight());
					p = cur;
					cur = cur.getRight();
				} else {
					final Node<T> tmp = s.pop();
					System.out.println(tmp.getData());
					cur = s.isEmpty() ? null : s.peek();
					p = tmp;
				}
			} else if (cur.getRight() == p) {
				final Node<T> tmp = s.pop();
				System.out.println(tmp.getData());
				cur = s.isEmpty() ? null : s.peek();
				p = tmp;
			}
		}
	}

	@Override
	public void inorder(Node<T> root) {
		if (root == null) {
			return;
		}
		inorder(root.getLeft());
		System.out.println(root.getData());
		inorder(root.getRight());

	}

	@Override
	public void inorderIterative(Node<T> root) {
		if (root == null) {
			return;
		}
		Node<T> cur = root;
		final Stack<Node<T>> s = new Stack<>();
		// initialize with root elemt.
		s.push(cur);
		while (!s.isEmpty()) {
			// store in stack untill left exists.
			while (cur.getLeft() != null) {
				s.push(cur.getLeft());
				cur = cur.getLeft();
			}
			if (!s.isEmpty()) {
				// pop stack print the element if stack is not null.
				final Node<T> tmp = s.pop();
				System.out.println(tmp.getData());
				if (tmp.getRight() != null) {
					// if popped element has right child ,then push the element.
					s.push(tmp.getRight());// just like root.
					cur = tmp.getRight();// works like recursion.
				}
			}
		}
	}

	@Override
	public void levelorder(BinaryTree<T> tree) {
		for (int i = 1; i <= tree.getHeight(tree.root); i++) {
			// pring all nodes at given level()
			traverseAtLevel(tree.root, i);
			System.out.println();
		}

	}

	@Override
	public void levelorderIterative(Node<T> root) {

		final Queue<Node<T>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			final Node<T> tmp = q.poll();
			if (tmp == null) // we have reached another level
			{
				System.out.println();
				if (!q.isEmpty()) {
					q.offer(null);
				}
			} else {
				System.out.println(tmp.getData());
				if (tmp.getLeft() != null) {
					q.offer(tmp.getLeft());
				}
				if (tmp.getRight() != null) {
					q.offer(tmp.getRight());
				}
			}
		}
	}

	private void traverseAtLevel(Node<T> root, int l) {
		if (root == null) {
			return;
		}
		if (l == 1) {
			System.out.println(root.getData());
		}
		traverseAtLevel(root.getLeft(), l - 1);
		traverseAtLevel(root.getRight(), l - 1);
	}

	@Override
	public int getHeight(Node<T> root) {
		if (root == null) {
			return 0;
		}
		final int lheight = getHeight(root.getLeft());
		final int rheight = getHeight(root.getRight());
		if (lheight > rheight) {
			return 1 + lheight;
		} else {
			return 1 + rheight;
		}

	}

	// vertical
	@Override
	public void verticalTraversal(Node<T> root) {
		// we need to maintain a hashmap with key
		final Map<Integer, ArrayList<T>> map = new TreeMap<>();
		final int index = 0;
		verticaltravUtil(root, map, index);
		System.out.println(map.values());

	}

	/**
	 * @param root
	 * @param map
	 * @param index
	 */
	private void verticaltravUtil(Node<T> root, final Map<Integer, ArrayList<T>> map, int index) {
		if (map.get(index) == null && root != null) {

			map.put(index, new ArrayList<T>(Arrays.asList(root.getData())));
		} else {
			map.get(index).add(root.getData());
		}
		if (root.getLeft() != null) {
			verticaltravUtil(root.getLeft(), map, index - 1);
		}

		if (root.getRight() != null) {
			verticaltravUtil(root.getRight(), map, index + 1);
		}
	}

	// horizontal

	// diagonal
	@Override
	public void diagonalTraversal(Node<T> root) {
		// we need to maintain a hashmap with key
		final Map<Integer, ArrayList<T>> map = new TreeMap<>();
		final int index = 0;
		diagonaltravUtil(root, map, index);
		System.out.println(map.values());

	}

	/**
	 * @param root
	 * @param map
	 * @param index
	 */
	private void diagonaltravUtil(Node<T> root, final Map<Integer, ArrayList<T>> map, int index) {
		if (map.get(index) == null && root != null) {

			map.put(index, new ArrayList<T>(Arrays.asList(root.getData())));
		} else {
			map.get(index).add(root.getData());
		}
		if (root.getLeft() != null) {
			diagonaltravUtil(root.getLeft(), map, index - 1);
		}

		if (root.getRight() != null) {
			diagonaltravUtil(root.getRight(), map, index);
		}
	}

	@Override
	public void bundaryTraversal(Node<T> root) {
		if (root == null) {
			return;
		}
		// print left part except last top to bottom
		leftSubpart(root);
		// leaf nodes l to r
		leafNodes(root);
		// right part bottom up except last and root
		rightSubpart(root.right);
	}

	private void rightSubpart(Node<T> root2) {
		if (root2 == null || root2.right == null) {
			return;
		}
		rightSubpart(root2.right);
		System.out.println(root2.data);
	}

	private void leafNodes(Node<T> root2) {
		if (root2 == null) {
			return;
		}
		if (root2.left == null && root2.right == null) {
			System.out.println(root2.data);
		}
		leafNodes(root2.left);
		leafNodes(root2.right);
	}

	private void leftSubpart(Node<T> root2) {
		if (root2 == null) {
			return;
		}
		while (root2.left != null) {
			System.out.println(root2.data);
			root2 = root2.left;
		}
	}

	@Override
	public Node<Integer> fromParentArray(int[] a, int val) {
		final int in = search(a, val);
		if (in == -1) {
			return null;
		}
		final Node<Integer> root = new Node<>(in);
		root.left = fromParentArray(a, in);
		root.right = fromParentArray(a, in);
		return root;

	}

	private int search(int[] a, int val) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			if (a[i] == val) {
				a[i] = 1000 + a[i];
				return i;
			}
		}
		return -1;
	}

	// this method returns the number of leaf nodes in a tree given the root
	@Override
	public int leafPrint(Node<T> root2) {
		return leafCountUtil(root2);
	}

	/**
	 * @param root2
	 * @param count
	 */
	private int leafCountUtil(Node<T> root2) {
		final Node<T> cur = root2;
		if (cur == null) {
			return 0;
		} else if (cur.getLeft() == null && cur.getRight() == null) {

			System.out.println(cur.getData());
			return 1;
		} else {
			return leafCountUtil(cur.getLeft()) + leafCountUtil(cur.getRight());
		}
	}

	// this method returns the node in which x exists
	@Override
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
		} else if (root.getData() == x) {
			if (p != null
					&& (p.getRight() != null && p.getLeft() == null || p.getRight() == null && p.getLeft() != null)) {
				b.isSingleChild = true;
			}
			return root;
		}
		final Node<T> cur = root;
		if (cur.getLeft() != null) {
			p = cur;
			f = findNodeUtil(x, cur.getLeft(), p, b);
		}
		if (f == null && cur.getRight() != null) {
			p = cur;
			f = findNodeUtil(x, cur.getRight(), p, b);
		}
		return f;
	}

}
