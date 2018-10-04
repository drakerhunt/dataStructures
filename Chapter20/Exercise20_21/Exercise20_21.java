import java.util.*;

class Exerscise20_21 {
	public static void main(String[] args) {
		
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
			new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
			new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
			new Circle(6.5), new Rectangle(4, 5)};
			
			System.out.println("The sorted list is: ");
			selectionSort(list, new GeometricObjectComparator());
			for (int i = 0; i < list.length; i++) {
				System.out.println(list[i].getArea());
			}
	}
	
	public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
		
		for (int i = 0; i < list.length; i++) {
			for (int c = 0; c < list.length; c++) {
				if (comparator.compare(list[i], list[c]) > 0) {
					E temp = list[i];
					list[i] = list[c];
					list[c] = temp;
				}
			}
		}
	}
}