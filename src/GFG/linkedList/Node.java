package linkedList;

public class Node<T> {
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
