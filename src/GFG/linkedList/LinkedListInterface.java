package GFG.linkedList;

public interface LinkedListInterface<T> {

	public Node<T> insertFirst(SinglyLinkedList<T> ll, T info);

	public Node<T> insertATk(SinglyLinkedList<T> ll, T info, int pos) throws InvalidOperationException;

	public Node<T> insertLast(SinglyLinkedList<T> ll, T info);

	public Node<T> deleteFirst(SinglyLinkedList<T> ll) throws InvalidOperationException;

	public Node<T> deleteATk(SinglyLinkedList<T> ll, int pos) throws InvalidOperationException;

	public Node<T> deleteLast(SinglyLinkedList<T> ll) throws InvalidOperationException;

	public void printll(Node<T> head);

}
