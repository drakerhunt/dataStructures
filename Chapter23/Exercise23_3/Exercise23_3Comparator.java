import java.util.*;

class Exercise23_3Comparator {
	public static void main(String[] args) {
		GeometricObject[] list = new GeometricObject[10];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new GeometricObject((double)Math.random() * 10);
		}
		
		quickSort(list, new GeometricObjectComparator());
		
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getArea());
		}
	}
	
	public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		quickSort(list, 0, list.length - 1, comparator);
	}
	
	public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
		if (last > first) {
			int pivotIndex = partition(list, first, last, comparator); 
			quickSort(list, first, pivotIndex - 1, comparator); 
			quickSort(list, pivotIndex + 1, last, comparator);
		}
	}
	
	public static <E> int partition(E[] list, int first, int last, Comparator<? super E> comparator) {
			E pivot = list[first];	
			int low = first + 1;
			int high = last; 
			
			while (high > low) {	
					
				// Search forward from left	
				while (low <= high && comparator.compare(list[low], pivot) <= 0)	
				low++;	
				
				// Search backward from right 26	
				while (low <= high && comparator.compare(list[high], pivot) > 0)
				high--; 
				
				// Swap two elements in the list 30	
				if (high > low) {	
					E temp = list[high];	
					list[high] = list[low];
					list[low] = temp;
				}
			}
			
			while (high > first && comparator.compare(list[high], pivot) >= 0) {
				high--;	// Swap pivot with list[high] 41
			}
				
			if (comparator.compare(pivot, list[high]) > 0) {	
				list[first] = list[high];	
				list[high] = pivot; 	
				return	high;
			}	
			else {
				return	first;
			} 
		}

}