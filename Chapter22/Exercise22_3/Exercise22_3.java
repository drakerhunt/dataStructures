import java.util.*;

class Exercise22_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();
		
		String[] sArray = s1.split("");
		String[] sArray2 = s2.split("");
		String temp = "";
		int tempInt = 0;
		int c = 0;
		
		for(int i = 0; i < sArray.length; i++) {
			if(sArray[i].equalsIgnoreCase(sArray2[c])) {
				temp += sArray[i];
				tempInt = i;
				if(c < sArray2.length - 1) {
					c++;
				}
			}
		}
		if(temp.equalsIgnoreCase(s2))
			System.out.print("The substring is: " + temp);
		else
			System.out.print("s2 is not a substring of s1.");
	}
}