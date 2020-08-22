package com.lams1989.findmergepointtwolist;


public class FindMergePointInTwoList {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

	}

	public static void main(String args[]) {

		SinglyLinkedList llist1 = new SinglyLinkedList();
		SinglyLinkedList llist2 = new SinglyLinkedList();
		int[] llistItem1 = { 141, 302, 400, 530, 700 };

		for (int i = 0; i < llistItem1.length; i++) {
			SinglyLinkedListNode llist_head1 = insertNodeAtHead(llist1.head, llistItem1[i]);
			llist1.head = llist_head1;
		}
		for (int i = 1; i < llistItem1.length; i++) {
			SinglyLinkedListNode llist_head2 = insertNodeAtHead(llist2.head, llistItem1[i]);
			llist2.head = llist_head2;

		}

		SinglyLinkedListNode headaux = llist1.head.next.next.next;
		headaux.next = llist1.head;

		System.out.println(findMergeNode(llist1.head, llist2.head));
	}

	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode aux1 = head1;
		SinglyLinkedListNode aux2 = head2;

		while (aux1 != aux2) {
			if (aux1.next == null) {
				aux1 = head2;
			} else {
				aux1 = aux1.next;
			}

			if (aux2.next == null) {
				aux2 = head1;
			} else {
				aux2 = aux2.next;
			}
		}
		return aux1.data;

	}

	static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
		SinglyLinkedListNode nodeInsert = new SinglyLinkedListNode(data);
		if (head == null) {
			return nodeInsert;
		}
		nodeInsert.next = head;
		return nodeInsert;
	}

	static void printLinkedList(SinglyLinkedListNode head) {

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}
}
