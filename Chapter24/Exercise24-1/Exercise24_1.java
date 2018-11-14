class Exercise24_1 {
	public static void main(String[] args) {
		MyList<String> list1 = new MyArrayList<String>();
		MyList<String> list2 = new MyArrayList<String>();
		
		list1.add("Tom");
		list1.add("George");
		list1.add("Peter");
		list1.add("Jean");
		list1.add("Jane");
		
		System.out.println(list1.toString());
		
		list2.add("Tom");
		list2.add("George");
		list2.add("Michael");
		list2.add("Michelle");
		list2.add("Daniel");
		
		System.out.println(list2.toString());
		
		list1.addAll(list2);
		
		System.out.println(list1.toString());
		
		list1.clear();
		
		System.out.println(list1.toString());
		
		list1.add("Tom");
		list1.add("George");
		list1.add("Peter");
		list1.add("Jean");
		list1.add("Jane");
		
		list1.removeAll(list2);
		
		System.out.println(list1.toString());
	}
}