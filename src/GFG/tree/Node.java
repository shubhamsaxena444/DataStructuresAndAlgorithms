package GFG.tree;

public class Node<T> {
	public T data;
	public Node<T> right;
	public Node<T> left;

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

	public Node<T> getRight() {
		return right;
	}

	public void setNext(Node<T> next) {
		this.right = next;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setPrev(Node<T> prev) {
		this.left = prev;
	}

}
