package sorting;

import java.util.Iterator;
import java.util.LinkedList;

public class MergeSortLinkedList {

	public static void main(String[] args) {
		final LinkedList<Integer> head = new LinkedList<>();
		head.addFirst(1);
		head.addFirst(211);
		head.addFirst(321);
		head.addFirst(311);
		head.addFirst(12);
		head.addFirst(11);
		head.addFirst(51);
		head.addFirst(331);
		printlinkedList(head);
		System.out.println();
		printlinkedList(mergeSort(head));
	}

	private static LinkedList<Integer> mergeSort(LinkedList<Integer> head) {
		// algorithm is to break the linked llist into two parts l1 and l2 and keep
		// breaking them until we have 1 element in each list. Then we start merging the
		// lists.
		// we break the list by inter weaving .
		// initialize two head pointers for l1 and l2;
		// check for base condition, i.e, if the list size is 1, then return;
		if (head.size() == 1) {
			return head;
		}
		LinkedList<Integer> l1 = null, l2 = null;

		while (head.size() > 0) {
			l1 = append(l1, head);
			if (head.element() != null) {
				l2 = append(l2, head);
			}

		}
		l1 = mergeSort(l1);
		l2 = mergeSort(l2);

		return merge(l1, l2);

	}

	// this method is used to merge the two sorted linked lists l1 and l2.
	private static LinkedList<Integer> merge(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		final LinkedList<Integer> merged = new LinkedList<Integer>();
		// considering base cases.
		// if both are null,return new list.
		if (l1 == null && l2 == null) {
			return new LinkedList<Integer>();
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		final LinkedList<Integer> cur1 = l1;
		final LinkedList<Integer> cur2 = l2;
		while (cur1.size() > 0 && cur2.size() > 0) {
			if (cur1.element() <= cur2.element()) {
				merged.addLast(cur1.removeFirst());
			} else {
				merged.addLast(cur2.removeFirst());
			}
		}
		while (cur1.size() > 0) {
			merged.addLast(cur1.removeFirst());
		}
		while (cur2.size() > 0) {
			merged.addLast(cur2.removeFirst());
		}
		return merged;
	}

	// this method is used to aapend first element of head to the last element of
	// l1.
	private static LinkedList<Integer> append(LinkedList<Integer> l, LinkedList<Integer> head) {
		if (head.size() == 0) {
			return l == null ? new LinkedList<>() : l;
		}
		if (l == null) {
			l = new LinkedList<>();
		}
		l.addLast(head.removeFirst());
		return l;

	}

	/**
	 * @param head
	 */
	public static void printlinkedList(final LinkedList<Integer> head) {
		final Iterator<Integer> cur = head.iterator();
		while (cur.hasNext()) {
			System.out.print(cur.next());
			if (cur.hasNext()) {
				System.out.print("->");
			}

		}
	}

}
