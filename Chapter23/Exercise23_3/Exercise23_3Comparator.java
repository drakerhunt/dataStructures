class Exercise23_3Comparator {
	public static void main(String[] args) {
		
	}
	
	public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		quickSort(list, 0, list.length - 1, comparator);
	}
	
	public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
		if (last > first) {
			int pivotIndex = partition(list, first, last); 
			quickSort(list, first, pivotIndex - 1); 
			quickSort(list, pivotIndex + 1, last);
		}
	}
}