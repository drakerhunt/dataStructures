class Exercise23_7 {
	public static void main(String[] args) {
		Integer[] i1 = {1, 8, 10, 3, 9, 4, 5};
		
		Heap<Integer> heap = new Heap<Integer>(i1);
		
		for (int i = 0; i < i1.length; i++) {
			System.out.println(heap.remove());
		}
	}
}