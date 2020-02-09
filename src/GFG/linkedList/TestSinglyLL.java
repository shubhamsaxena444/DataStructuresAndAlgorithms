package linkedList;

public class TestSinglyLL {

	public static void main(String a[]) throws Exception {
		final SinglyLinkedList<String> ll = new SinglyLinkedList<>();
		// for (int i = 0; i < 6; i++) {
		ll.insertFirst(ll, "my");
		ll.insertLast(ll, "name");

		// }
		ll.insertATk(ll, "is", 1);
		ll.printll(ll.getNode());
		System.out.println();
		ll.deleteFirst(ll);
		ll.printll(ll.getNode());
		System.out.println();
		ll.deleteLast(ll);
		ll.printll(ll.getNode());
		System.out.println();
		ll.deleteLast(ll);
		ll.printll(ll.getNode());
		System.out.println();
		ll.insertATk(ll, "shubham", 1);
		ll.printll(ll.getNode());
		System.out.println();
		ll.insertATk(ll, "sexy", 1);
		ll.printll(ll.getNode());
		System.out.println();

		ll.deleteATk(ll, 1);
		ll.printll(ll.getNode());
	}
}
