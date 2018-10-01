import java.util.*;

class Exercise19_3 {
	public static void main(String[] args) {
		ArrayList<String> listS = new ArrayList<String>();
		ArrayList<Integer> listI = new ArrayList<Integer>();
		
		listS.add("Hello");
		listS.add("Hello");
		listS.add("Bob");
		listS.add("Hello");
		listS.add("Bob");
		
		listI.add(1);
		listI.add(1);
		listI.add(2);
		listI.add(1);
		listI.add(2);
		
		removeDuplicates(listS);
		removeDuplicates(listI);
		
		for (int i = 0; i < listS.size(); i++) {
			System.out.println(listS.get(i));
		}
		for (int i = 0; i < listI.size(); i++) {
			System.out.println(listI.get(i));
		}
	}
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int c = i + 1; c < list.size(); c++) {
				if (list.get(i) == list.get(c)) {
					list.remove(c);
				} //end if
			} //end for c
		} // end for i
		return list;
	} //end method removeDuplicates
} //end class Exercise19_3