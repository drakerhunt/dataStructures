import java.util.*;

class Exercise22_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a series of numbers ending with 0: ");
		ArrayList<Integer> intList = new ArrayList<Integer>();
		int num = 1;
		
		while (num != 0) {
			num = input.nextInt();
			intList.add(num);
		}
		
		int index = 0;
		int length = 1;
		int tempLength = 1;
		int number = 0;
		int c = 0;
		
		for (int i = 1; i < intList.size(); i++) {
			if (intList.get(i) == intList.get(c)) {
				tempLength++;
			}
			else if (intList.get(i) > intList.get(c) || intList.get(i) < intList.get(c)) {
				if (length < tempLength) {
					index = intList.indexOf(intList.get(c));
					length = tempLength;
					number = intList.get(c);
				}
				tempLength = 1;
			}
			c++;
		}
		System.out.println("The longest same number sequence starts at index " + index + " with " + length + " values of " + number);
	}
}