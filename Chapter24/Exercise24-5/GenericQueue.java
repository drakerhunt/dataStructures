import java.util.*;

public class GenericQueue<E> extends LinkedList<E> {
	
	public void enqueue(E e) {
		this.addLast(e);
	}
	
	public E dequeue() {
		return this.removeFirst();
	}
	
	public int getSize() {
		return this.size();
	}
	
	@Override
	public String toString() {
		String temp = "[";
		int tempI = this.size();
		for (int i = 0; i < this.size(); i++) {
			if (i  < tempI - 1)
				temp += this.get(i) + ", ";
			else 
				temp += this.get(i);
		}
		
		return "Queue: " + temp + "]";
	}
}