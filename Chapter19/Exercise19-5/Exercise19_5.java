import java.util.List;

class Exercise19_5 {
	public static void main(String[] args) {
		String[] s = {"H", "B", "A", "Z", "Y"};
		Integer[] i = {10, 1, 2, 3, 8, 4, 5, 7, 9, 1};
		
		//System.out.println(max(s));
		System.out.println(max(i));
	}
	
	public static <E extends Comparable<E>> E max(E[] list) {
		int max = 0;
		for (int i = 0; i < list.length; i++) {
			for (int c = list.length - 1; c > 0; c--) {
				if (list[i].compareTo(list[c]) > 0) {
					System.out.println("HERE");
					max = i;
				}//end if
			}//end for 2
		}//end for 1
		return list[max];
	}//end method
}//end class