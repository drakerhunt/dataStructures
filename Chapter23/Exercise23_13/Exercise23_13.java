import java.util.*;

class Exercise23_13 {
	public static void main(String[] args) {
		long timerArray[][] = new long[6][6];
		String sortAmount[] = new String[6];
		sortAmount[0] = "50000";
		sortAmount[1] = "100000";
		sortAmount[2] = "150000";
		sortAmount[3] = "200000";
		sortAmount[4] = "250000";
		sortAmount[5] = "300000";
		
		//50000 list
		Integer[] list1 = new Integer[50000];
		initialize(list1);
		Integer[] tempList1 = new Integer[50000];
		initialize(tempList1);
		//100000 list
		Integer[] list2 = new Integer[100000];
		initialize(list2);
		Integer[] tempList2 = new Integer[100000];
		initialize(tempList2);
		//150000 list
		Integer[] list3 = new Integer[150000];
		initialize(list3);
		Integer[] tempList3 = new Integer[150000];
		initialize(tempList3);
		//200000 list
		Integer[] list4 = new Integer[200000];
		initialize(list4);
		Integer[] tempList4 = new Integer[200000];
		initialize(tempList4);
		//250000 list
		Integer[] list5 = new Integer[250000];
		initialize(list5);
		Integer[] tempList5 = new Integer[250000];
		initialize(tempList5);
		//300000 list
		Integer[] list6 = new Integer[300000];
		initialize(list6);
		Integer[] tempList6 = new Integer[300000];
		initialize(tempList6);
		
		//BubbleSort
		timerArray[0][0] = bubbleSort(tempList1);
		timerArray[0][1] = bubbleSort(tempList2);
		timerArray[0][2] = bubbleSort(tempList3);
		timerArray[0][3] = bubbleSort(tempList4);
		timerArray[0][4] = bubbleSort(tempList5);
		timerArray[0][5] = bubbleSort(tempList6);
		
		//reinitialize
		tempList1 = list1;
		tempList2 = list2;
		tempList3 = list3;
		tempList4 = list4;
		tempList5 = list5;
		tempList6 = list6;
		
		//QuickSort 
		timerArray[1][0] = quickSort(tempList1, 0, tempList1.length - 1);
		timerArray[1][1] = quickSort(tempList2, 0, tempList2.length - 1);
		timerArray[1][2] = quickSort(tempList3, 0, tempList3.length - 1);
		timerArray[1][3] = quickSort(tempList4, 0, tempList4.length - 1);
		timerArray[1][4] = quickSort(tempList5, 0, tempList5.length - 1);
		timerArray[1][5] = quickSort(tempList6, 0, tempList6.length - 1);
		
		//reinitialize
		tempList1 = list1;
		tempList2 = list2;
		tempList3 = list3;
		tempList4 = list4;
		tempList5 = list5;
		tempList6 = list6;
		
		//Heap sort 
		long startTime = System.currentTimeMillis();
		Heap h1 = new Heap(tempList1);
		long endTime = System.currentTimeMillis();
		timerArray[2][0] = endTime - startTime;
		startTime = System.currentTimeMillis();
		Heap h2 = new Heap(tempList2);
		endTime = System.currentTimeMillis();
		timerArray[2][1] = endTime - startTime;
		startTime = System.currentTimeMillis();
		Heap h3 = new Heap(tempList3);
		endTime = System.currentTimeMillis();
		timerArray[2][2] = endTime - startTime;;
		startTime = System.currentTimeMillis();
		Heap h4 = new Heap(tempList4);
		endTime = System.currentTimeMillis();
		timerArray[2][3] = endTime - startTime;
		startTime = System.currentTimeMillis();
		Heap h5 = new Heap(tempList5);
		endTime = System.currentTimeMillis();
		timerArray[2][4] = endTime - startTime;
		startTime = System.currentTimeMillis();
		Heap h6 = new Heap(tempList6);
		endTime = System.currentTimeMillis();
		timerArray[2][5] = endTime - startTime;
		
		//initialize 
		tempList1 = list1;
		tempList2 = list2;
		tempList3 = list3;
		tempList4 = list4;
		tempList5 = list5;
		tempList6 = list6;
		
		timerArray[3][0] = mergeSort(tempList1);
		timerArray[3][1] = mergeSort(tempList2);
		timerArray[3][2] = mergeSort(tempList3);
		timerArray[3][3] = mergeSort(tempList4);
		timerArray[3][4] = mergeSort(tempList5);
		timerArray[3][5] = mergeSort(tempList6);
		
		//initialize 
		tempList1 = list1;
		tempList2 = list2;
		tempList3 = list3;
		tempList4 = list4;
		tempList5 = list5;
		tempList6 = list6;
		
		timerArray[4][0] = selectionSort(tempList1);
		timerArray[4][1] = selectionSort(tempList1);
		timerArray[4][2] = selectionSort(tempList1);
		timerArray[4][3] = selectionSort(tempList1);
		timerArray[4][4] = selectionSort(tempList1);
		timerArray[4][5] = selectionSort(tempList1);
		
		//initialize 
		tempList1 = list1;
		tempList2 = list2;
		tempList3 = list3;
		tempList4 = list4;
		tempList5 = list5;
		tempList6 = list6;
		
		//Radix sort
		startTime = System.currentTimeMillis();
		Radix.radixsort(tempList1, tempList1.length);
		endTime = System.currentTimeMillis();
		timerArray[5][0] = endTime - startTime;
		startTime = System.currentTimeMillis();
		Radix.radixsort(tempList2, tempList2.length);
		endTime = System.currentTimeMillis();
		timerArray[5][1] = endTime - startTime;
		startTime = System.currentTimeMillis();
		Radix.radixsort(tempList3, tempList3.length);
		endTime = System.currentTimeMillis();
		timerArray[5][2] = endTime - startTime;
		startTime = System.currentTimeMillis();
		Radix.radixsort(tempList4, tempList4.length);
		endTime = System.currentTimeMillis();
		timerArray[5][3] = endTime - startTime;
		startTime = System.currentTimeMillis();
		Radix.radixsort(tempList5, tempList5.length);
		endTime = System.currentTimeMillis();
		timerArray[5][4] = endTime - startTime;
		startTime = System.currentTimeMillis();
		Radix.radixsort(tempList6, tempList6.length);
		endTime = System.currentTimeMillis();
		timerArray[5][5] = endTime - startTime;
		
		
		System.out.printf("%15s%15s%15s%15s%15s%15s\n\n", "BubbleSort", "QuickSort", "HeapSort", "MergeSort", "SelectionSort", "RadixSort");
		for (int i = 0; i < 6; i++) {
			System.out.print(sortAmount[i]);
			for (int c = 0; c < 6; c++) {
				System.out.printf("%13d", timerArray[c][i]);
			}
			System.out.println("\n");
		}
	}
	
	public static void initialize(Integer[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = (int)Math.random() * 100 + 1;
		}
	}
	
	public static long bubbleSort(Integer[] list) {
		long startTime = System.currentTimeMillis();
		for (int k = 1; k < list.length; k++) {
			for (int i = 0; i < list.length - k; i++) {
				if (list[i] > list[i + 1]) {
					Integer temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	public static long quickSort(Integer[] arr, int low, int high) {
		long startTime = System.currentTimeMillis();
		
		if (arr == null || arr.length == 0)
			return 0;
 
		if (low >= high)
			return 0;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				Integer temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
		if (high > i)
			quickSort(arr, i, high);
			
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	/** The method for sorting the numbers */
	public static long mergeSort(Integer[] list) { 
		long startTime = System.currentTimeMillis();
		if (list.length > 1) {
			Integer[] firstHalf = new Integer[list.length / 2];	
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);

			// Merge sort the second half 11	
			int secondHalfLength = list.length - list.length / 2;	
			Integer[] secondHalf = new Integer[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);

			// Merge firstHalf with secondHalf into list 18	
			merge(firstHalf, secondHalf, list);
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	/** Merge two sorted lists */
	public static void merge(Integer[] list1, Integer[] list2, Integer[] temp) {	
		int current1 = 0; // Current index in list1 25	
		int current2 = 0; // Current index in list2 26	
		int current3 = 0; // Current index in temp 27  rewasr
		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
				
		while (current1 < list1.length)	
			temp[current3++] = list1[current1++];
				
		while (current2 < list2.length)	
			temp[current3++] = list2[current2++];
	}
	
	public static long selectionSort(Integer[] arr) {
		long startTime = System.currentTimeMillis();
		int min;
		for (int i = 0; i < arr.length; i++) {
			// Assume first element is min
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;

				}
			}
			if (min != i) {
				final int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}