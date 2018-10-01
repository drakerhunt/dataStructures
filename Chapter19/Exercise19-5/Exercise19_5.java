import java.util.List;

class Exercise19_5 {
	public static void main(String[] args) {
		String[] s = {"H", "B", "A", "Z", "Y", "ZZ"};
		Integer[] i = {10, 1, 2, 160, 3, 8, 4, 5, 7, 9, 1, 12, 155};
		
		System.out.println(max(s));
		System.out.println(max(i));
	}
	
	public static <E extends Comparable<E>> E max(E[] list) {
		int max = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[max].compareTo(list[i]) < 0) {
				max = i;
			}//end if
		}//end for 1
		return list[max];
	}//end method
}//end class