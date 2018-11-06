import java.util.*;

class Exercise23_3Comparable {
	public static void main(String[] args) {
		String[] s = {
			"e",
			"b",
			"d",
			"a",
			"c"};
			
		quickSort(s);
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
	
	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length - 1);
	}
	public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last); 
			quickSort(list, first, pivotIndex - 1); 
			quickSort(list, pivotIndex + 1, last);
		}
	}
	public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
		E pivot = list[first];	
		int low = first + 1;
		int high = last; 
		
		while (high > low) {	
				
			// Search forward from left	
			while (low <= high && list[low].compareTo(pivot) <= 0)	
			low++;	
			
			// Search backward from right 26	
			while (low <= high && list[high].compareTo(pivot) > 0)
			high--; 
			
			// Swap two elements in the list 30	
			if (high > low) {	
				E temp = list[high];	
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high].compareTo(pivot) >= 0) {
			high--;	// Swap pivot with list[high] 41
		}
			
		if (pivot.compareTo(list[high]) > 0) {	
			list[first] = list[high];	
			list[high] = pivot; 	
			return	high;
		}	
		else {
			return	first;
		} 
	}
}