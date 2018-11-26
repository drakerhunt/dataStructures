import java.util.*;

public class TwoWayLinkedList<E> extends MyAbstractList<E> {
	
	private Node<E> head, tail;
	
	public TwoWayLinkedList() {
		
	}
	
	public TwoWayLinkedList(E[] objects) {
		super(objects);
	}
	
	public E getFirst() {
		if (size == 0) {
			return null;
		}
		else {
			return head.element;
		}
	}
	
	public E getLast() {
		if (size == 0) {
			return null;
		}
		else {
			return tail.element;
		}
	}
	
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
		
		if (tail == null) {
			tail = head;
		}
	}
	
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		
		Node<E>temp = tail;
		if(tail == null) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = tail.next;
		}
		
		size++;
		
		tail.previous = temp;
	}
	
	@Override
	public void add(int index, E e) {
		if (index == 0) addFirst(e);
		else if (index >= size) addLast(e);
		else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
			
			temp.previous = current.next;
			current.next.previous = current;
		}
	}
	
	@Override
	public void add(E e) {
		addFirst(e);
	}
	
	public E removeFirst() {
		if (size == 0) return null;
		else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) tail = null;
			return temp.element;
		}
	}
	
	public  E removeLast() {
		if (size == 0) return null;
		else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else {
			Node<E> current = head;
			
			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}
			
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}
	
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) return null;
		else if ( index == 0) return removeFirst();
		else if (index == size - 1) return removeLast();
		else {
			Node<E> previous = head;
			
			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}
			
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(",");
			}
			else {
				result.append("]");
			}
		}
		
		return result.toString();
	}
	
	@Override
	public void clear() {
		size = 0;
		head = tail = null;
	}
	
	@Override
	public boolean contains(E e) {
		System.out.println("Implementation left as an exercise");
		return false;
	}
	
	@Override
	public E get(int index) {
		return null;
	}
	
	@Override
	public int indexOf(E e) {
		return 0;
	}
	
	@Override
	public int lastIndexOf(E e) {
		return 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public E set(int index, E e) {
		return null;
	}
	
	@Override
	public java.util.ListIterator<E> iterator() {
		return new LinkedListIterator<E>();
	}
	
		public void iterator(int i) {
			new LinkedListIterator<E>();
		}

	private class LinkedListIterator<E> implements java.util.ListIterator<E> {
		private Node<E> current = (Node<E>)head;
		
		@Override
		public boolean hasNext() {
			return (current != null);
		}
		
		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}
		
		@Override
		public void add(E e) {
			
		}
		
		@Override
		public void set(E e) {
			current.element = e;
		}
		
		@Override
		public void remove() {
			
		}
		
		public boolean hasPrevious() {
			return (current != head);
		}
		
		@Override
		public E previous() {
			E e = current.element;
			current = current.previous;
			return e;
		}
		
		@Override
		public int nextIndex() {
			return 0;
		}
		
		@Override
		public int previousIndex() {
			return 0;
		}
	}

	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> previous;
		
		public Node(E element) {
			this.element = element;
		}
	}
}
