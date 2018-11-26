import java.util.ListIterator;

class Exercise24_3 {
	public static void main(String[] args) {
		TwoWayLinkedList<Integer> list = new TwoWayLinkedList<Integer>();
		
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		
		java.util.ListIterator<Integer> iterator = list.iterator();
		
		iterator.next();
		iterator.next();
		iterator.next();
		
		while (iterator.hasPrevious()) {
			System.out.print(iterator.previous() + " ");
		}
	}
}