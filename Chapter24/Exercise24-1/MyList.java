public interface MyList<E> extends java.lang.Iterable<E> {
	public void add(E e);
	
	public void add(int index, E e);
	
	public boolean addAll(MyList<E> otherList);
	
	public void clear();
	
	public boolean contains(E e);
	
	public E get(int index);
	
	public int indexOf(E e);
	
	public int lastIndexOf(E e);
	
	public E remove(int index);
	
	public boolean removeAll(MyList<E> otherList);
	
	public boolean retainAll(MyList<E> otherList);
	
	public Object set(int index, E e);
	
	public int size();	
}