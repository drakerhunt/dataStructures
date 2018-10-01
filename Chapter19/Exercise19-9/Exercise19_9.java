import java.util.ArrayList;
import java.awt.*;

class Exercise19_9 {
	public static void main(String[] args) {
		ArrayList<Integer> iList = new ArrayList<Integer>();
		ArrayList<String> sList = new ArrayList<String>();
		
		iList.add(4);
		iList.add(2);
		iList.add(3);
		iList.add(1);
		iList.add(5);
		
		sList.add("D");
		sList.add("K");
		sList.add("E");
		sList.add("R");
		sList.add("A");
		sList.add("Z");
		sList.add("Y");
		
		sort(iList);
		sort(sList);
		
		for (int i = 0; i < iList.size(); i++) {
			System.out.println(iList.get(i));
		}
		System.out.println();
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
	}
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		for (int c = 0; c < list.size(); c++) {
			for (int i = c + 1; i < list.size(); i++) {
				if (list.get(c).compareTo(list.get(i)) > 0) {
					E temp = list.get(c);
					list.set(c, list.get(i));
					list.set(i, temp);
				}
			}
		}
	}
}