import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque <Item> {
	
	public Deque(){
		
	}
	
	public boolean isEmpty(){
		return false;
	}
	
	public int size(){
		return -1;
	}
	
	public void addFirst(Item item){
		if(item == null) throw new NullPointerException();
		
	}
	
	public void addLast(Item item){
		if(item == null) throw new NullPointerException();
		
	}
	
	public Item removeFirst(){
		if(size() <= 0) throw new NoSuchElementException();
		return null;
	}
	
	public Item removeLast(){
		return null;
	}
	
	public Iterator<Item> iterator(){
		return null;
	}
	
	
}
