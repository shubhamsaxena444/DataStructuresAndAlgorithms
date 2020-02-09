package tree;

public class TestBinaryTree {

	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
		final BinaryTree<Integer> bt = new BinaryTree<>();
		bt.root = new Node(21);
		bt.root.setPrev(new Node(2));
		bt.root.setNext(new Node(11));

		bt.root.getLeft().setPrev(new Node(4));
		bt.root.getLeft().setNext(new Node(5));

		bt.root.getRight().setPrev(new Node(16));
		bt.root.getRight().setNext(new Node(18));

		bt.root.right.left.left = new Node(1);

		// bt.levelorder(bt);
		System.out.println();
		// bt.postorder(bt.root);

		System.out.println();
		// bt.levelorder(bt);

		// bt.diagonalTraversal(bt.root);
		// bt.postorderIterative(bt.root);
		// bt.bundaryTraversal(bt.root);
		// final InorderANdPreorder<Character> ip = new InorderANdPreorder<>();
		// final Character in[] = new Character[] { 'D', 'B', 'E', 'A', 'F', 'C' };

		// final BinaryTree<Character> bnt = ip.inAndPre(in, new Character[] { 'A', 'B',
		// 'D', 'E', 'C', 'F' });
		// bt.inorder(bnt.root);
		// bt.preorder(bt.fromParentArray(new int[] { -1, 0, 0, 1, 1, 3, 5 }, -1));

		/*
		 * final TreeToDLL<Integer> td = new TreeToDLL<>(); final
		 * DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
		 * dl.printll(td.treeToDLL(bt.root).head);
		 * dl.printll(td.usingInorderWithPrev(bt.root).head);
		 */
		final bool b = new TestBinaryTree().new bool();
		final int x = bt.leafPrint(bt.root);
		final int y = bt.leafPrint(bt.findNode(bt.root, 2, b));
		if (b.isSingleChild) {
			System.out.println(x - y + 1);
		} else {
			System.out.println(x - y);
		}
	}

	class bool {
		boolean isSingleChild = false;

	}
}
