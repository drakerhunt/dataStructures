class Exercise25_1 {
	public static void main(String[] args) {
		Integer[] i = new Integer[4];
		i[0] = 5;
		i[1] = 2;
		i[2] = 10;
		i[3] = 3;
		BST<Integer> bst = new BST<Integer>(i);
		
		System.out.println(bst.height());
		bst.breadthFirstTraversal();
	}
}