import java.util.*;

class Exercise22_1 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s1 = input.nextLine();
		
		String[] sArray = s1.split("");
		String temp = sArray[0];
		int c = 0;
		ArrayList<String> sList = new ArrayList<String>();
		
		for(int i = 1; i < sArray.length; i++) {
			
			if(sArray[i].compareTo(sArray[c]) > 0) {
				temp += sArray[i];
			}
			else {
				sList.add(temp);
				temp = sArray[i];
			}
			c++;
		}
		
		c = 0;
		for(int i = 1; i < sList.size(); i++) {
			if(sList.get(i).compareTo(sList.get(c)) > 0) {
				temp = sList.get(i);
			}
		}
		
		System.out.println(temp);
	}
}