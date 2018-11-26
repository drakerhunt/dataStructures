import java.util.Scanner;

class Exercise25_5 {
	public static void main(String[] args) {
		Integer[] iArray = new Integer[10];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			iArray[i] = input.nextInt();
		}
		BST<Integer> bst = new BST<Integer>(iArray);
		
		bst.nonRecursivePostorder();
	}
}