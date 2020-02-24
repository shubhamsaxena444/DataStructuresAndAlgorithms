package GFG.linkedList;

public class SinglyLinkedList<T> implements LinkedListInterface<T> {
	private Node<T> head;

	public Node<T> getNode() {
		return head;
	}

	public void setNode(Node<T> node) {
		head = node;
	}

	public SinglyLinkedList(Node<T> head) {
		this.head = head;
	}

	public SinglyLinkedList() {
	}

	@Override
	public Node<T> insertFirst(SinglyLinkedList<T> ll, T info) {
		// create a new node for info.
		Node<T> head = ll.getNode();
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
			ll.setNode(head);
			return ll.getNode();
		}
		newnode.setNext(ll.getNode());
		head = newnode;
		ll.setNode(head);
		return ll.getNode();
	}

	// this method inserts element at k position or throws exeption
	@Override
	public Node<T> insertATk(SinglyLinkedList<T> ll, T info, int pos) throws InvalidOperationException {
		// if position is one call insert first.
		if (pos == 1) {
			return insertFirst(ll, info);
		}
		if (head == null || pos <= 0) // if cur is null and pos is not 1 ,then throw exception.
		{
			throw new InvalidOperationException("invalid position");
		}

		final Node<T> head = ll.getNode();
		Node<T> newnode = null;
		try {
			newnode = new Node<>(); // allocating memory
			newnode.setData(info); // set info
			newnode.setNext(null); // set next pointer to null
		} catch (final StackOverflowError e) {
			System.out.println("memery overflow");
		}

		Node<T> cur = head;
		for (int i = 0; i < pos - 2; i++) {
			if (cur.getNext() != null) {
				cur = cur.getNext();
			} else {
				throw new InvalidOperationException("invalid position");
			}
		}
		newnode.setNext(cur.getNext());
		cur.setNext(newnode);
		return newnode;
	}

	@Override
	public Node<T> insertLast(SinglyLinkedList<T> ll, T info) {
		Node<T> head = ll.getNode();
		Node<T> newnode = null;
		try {
			newnode = new Node<>(); // allocating memory
			newnode.setData(info); // set info
			newnode.setNext(null); // set next pointer to null
		} catch (final StackOverflowError e) {
			System.out.println("memery overflow");
		}

		if (head == null) {
			head = newnode;
			ll.setNode(head);
			return head;
		}
		Node<T> cur = head;
		while (cur.getNext() != null) {
			cur = cur.getNext();
		}
		cur.setNext(newnode);
		return newnode;
	}

	@Override
	public Node<T> deleteFirst(SinglyLinkedList<T> ll) throws InvalidOperationException {
		Node<T> head = ll.getNode();
		if (head == null) {
			throw new InvalidOperationException("Invalid deletion.");
		}
		final Node<T> temp = head.getNext();
		head = head.getNext();
		ll.setNode(head);
		return temp;
	}

	@Override
	public Node<T> deleteATk(SinglyLinkedList<T> ll, int pos) throws InvalidOperationException {

		// if pos = 1
		if (pos == 1) {
			return deleteFirst(ll);
		}
		if (head == null || pos <= 0) {
			throw new InvalidOperationException("Invalid deletion.");
		}
		final Node<T> head = ll.getNode();
		Node<T> cur = head;
		for (int i = 0; i < pos - 2; i++) {
			if (cur.getNext() != null) {
				cur = cur.getNext();
			} else {
				throw new InvalidOperationException("Invalid deletion.");
			}
		}
		final Node<T> temp = cur.getNext();
		if (temp != null) {
			cur.setNext(temp.getNext());
		} else {
			throw new InvalidOperationException("Invalid deletion.");
		}
		return temp;
	}

	@Override
	public Node<T> deleteLast(SinglyLinkedList<T> ll) throws InvalidOperationException {
		Node<T> head = ll.getNode();
		if (head == null) {
			throw new InvalidOperationException("Invalid deletion.");
		}
		Node<T> cur = head;
		// if there is only one element left to delete and pos =1
		if (cur.getNext() == null) {
			head = null;
			ll.setNode(head);
			return cur;
		}
		while (cur.getNext() != null && cur.getNext().getNext() != null) {
			cur = cur.getNext();
		}
		final Node<T> temp = cur.getNext();
		cur.setNext(null);
		return temp;
	}

	@Override
	public void printll(Node<T> head) {
		Node<T> cur = head;
		while (cur != null) {
			System.out.print(cur.getData());
			cur = cur.getNext();
			if (cur != null) {
				System.out.print("->");
			}
		}
	}

}
