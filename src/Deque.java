import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque <Item> {
	
	private int size;
	
	public Deque(){
		size = 0;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public int size(){
		return -1;
	}
	
	public void addFirst(Item item){
		if(item == null) throw new NullPointerException();
		size++;
		
	}
	
	public void addLast(Item item){
		if(item == null) throw new NullPointerException();
		size++;
	}
	
	public Item removeFirst(){
		if(size() <= 0) throw new NoSuchElementException();
		size--;
		
		return null;
	}
	
	public Item removeLast(){
		if(size() <= 0) throw new NoSuchElementException();
		size--;
		
		return null;
	}
	
	public Iterator<Item> iterator(){
		return null;
	}
	
	
}
