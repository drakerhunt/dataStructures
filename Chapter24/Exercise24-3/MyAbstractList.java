import java.util.*;

public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0;
	
	protected MyAbstractList() {
	}
	
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	
	public boolean addAll(MyList<E> otherList) {
		
		for (int i = 0; i < otherList.size(); i++) {
			add(otherList.get(i));
		}
		if (otherList.size() > 0) {
			return true;
		}
			else return false;
	}
	
	public boolean removeAll(MyList<E> otherList) {
		if (otherList.size() >= 1) {
			for (int i = 0; i < this.size(); i++) {
				this.remove(i);
			}
			return true;
		}
		else return false;
	}
	
	public boolean retainAll(MyList<E> otherList) {
		if (otherList.size() >= 1) {
			for (int i = 0; i < otherList.size(); i++) {
				for (int c = 0; c < otherList.size(); c++) {
					if (otherList.get(i) != this.get(c)) {
						this.add(otherList.get(i));
					}
				}
			}
			return true;
		}
		else return false;
	}
}