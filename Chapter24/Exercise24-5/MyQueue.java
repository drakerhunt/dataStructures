public class MyQueue<E> extends java.util.LinkedList {
	
	public MyQueue() {
		
	}
	
	public void enqueue(E e) {
		this.addLast(e);
	}
	
	public E dequeue() {
		return (E)this.removeFirst();
	}
	
	public int getSize() {
		return this.size();
	}
	
	@Override
	public String toString() {
		return ("Queue: " + super.toString());
	}
}