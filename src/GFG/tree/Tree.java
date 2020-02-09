package tree;

import tree.TestBinaryTree.bool;

public interface Tree<T> {

	void preorder(Node<T> root);

	void postorder(Node<T> root);

	void postorderIterative(Node<T> root);

	void inorder(Node<T> root);

	void inorderIterative(Node<T> root);

	void levelorder(BinaryTree<T> tree);

	void levelorderIterative(Node<T> root);

	int getHeight(Node<T> root);

	void verticalTraversal(Node<T> root);

	void diagonalTraversal(Node<T> root);

	void bundaryTraversal(Node<T> root);

	Node<Integer> fromParentArray(int[] a, int val);

	int leafPrint(Node<T> root2);

	Node<T> findNode(Node<T> root, T x, bool bool);

}
