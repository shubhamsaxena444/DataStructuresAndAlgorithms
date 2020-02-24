package GFG.linkedList;

public class DoublyLinkedList<T> implements LinkedListInterface<T> {
	public Node<T> head;

	public DoublyLinkedList(Node<T> head) {
		this.head = head;
	}

	public DoublyLinkedList() {
	}



    @Override
	public Node<T> insertFirst(SinglyLinkedList<T> ll, T info) {
		return null;
	}

	@Override
	public Node<T> insertATk(SinglyLinkedList<T> ll, T info, int pos) throws InvalidOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> insertLast(SinglyLinkedList<T> ll, T info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> deleteFirst(SinglyLinkedList<T> ll) throws InvalidOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> deleteATk(SinglyLinkedList<T> ll, int pos) throws InvalidOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> deleteLast(SinglyLinkedList<T> ll) throws InvalidOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printll(Node<T> head) {
		Node<T> cur = head;
		while (cur != null) {
			System.out.println(cur.data);
			cur = cur.next;
		}
	}

}
