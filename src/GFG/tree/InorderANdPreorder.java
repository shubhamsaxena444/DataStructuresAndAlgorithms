package tree;

public class InorderANdPreorder<T> {
	static int preorder = 0;

	public BinaryTree<T> inAndPre(T[] in, T[] pre) {
		final BinaryTree<T> bt = new BinaryTree<>();

		bt.root = inAndPreUtil(in, 0, in.length - 1, pre, 0, pre.length - 1, bt.root);
		return bt;

	}

	// we dont need to keep track of preorder array indexes, since in the folllowing
	// recursive calls prev,next, we will always require preorder++ which can be
	// taken as a static variable
	public BinaryTree<T> inAndPreEnhanced(T[] in, T[] pre) {
		final BinaryTree<T> bt = new BinaryTree<>();
		// bt.root= inAndPreUtilEnhanced(in,0,in.length-1,pre);
		return bt;

	}

	private Node<T> inAndPreUtil(T[] in, int i, int j, T[] pre, int k, int l, Node<T> root) {
		if (i > j || k > l) {
			return root;
		}
		// find first from pre call it r
		// make it the root.
		final T r = pre[k];
		root = new Node<T>(r);
		// search r in in
		final int index = search(in, i, j, r);
		// call for in(0...r-1),make it left subtree
		root.left = inAndPreUtil(in, i, index - 1, pre, k + 1, k + index - i, root.left);
		// call for in(r+1...n-1),make it right subtree
		root.right = inAndPreUtil(in, index + 1, j, pre, l - j + index + 1, l, root.right);

		return root;
	}

	private int search(T[] in, int i, int j, T r) {
		// TODO Auto-generated method stub
		for (int u = i; u <= j; u++) {
			if (in[u] == r) {
				return u;
			}
		}
		return -1;
	}
}
