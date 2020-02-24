package GFG.linkedList;

public class LinkedListTestImplementationSinglyLL {

	public static void main(String[] args) {

		Node<Integer> head;
		final LinkedListTestImplementationSinglyLL ll = new LinkedListTestImplementationSinglyLL();
		head = ll.create(99);
		for (int i = 0; i < 6; i++) {
			head = ll.insertFirst(head, i);
		}
		printll(head);

	}

	private static void printll(Node<Integer> head) {
		Node<Integer> cur = head;
		while (cur != null) {
			System.out.print(cur.getData());
			cur = cur.getNext();
			if (cur != null) {
				System.out.print("->");
			}
		}
	}

	public <T> Node<T> create(T firstElement) {
		final Node<T> head = new Node<>();
		head.setData(firstElement);
		return head;
	}

	private <T> Node<T> insertFirst(Node<T> head, T info) {
		// create a new node for info.
		Node<T> newnode = null;
		try {
			newnode = new Node<>(); // allocating memory
			newnode.setData(info); // set info
			newnode.setNext(null); // set next pointer to null
		} catch (final StackOverflowError e) {
			System.out.println("memery overflow");
		}
		if (head == null) {
			/// pont head to null;
			head = newnode;
			return head;
		}
		newnode.setNext(head);
		head = newnode;
		return head;
	}
}
