import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue <Item> implements Iterable<Item> {
	
	private ArrayList<Item> list;
	
	public RandomizedQueue(){
		list = new ArrayList<Item>();
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public int size(){
		return list.size();
	}
	
	public void enqueue(Item item){
		if(item == null) throw new NullPointerException();
		list.add(item);
	}
	
	public Item dequeue(){
		return list.remove(random());
	}
	
	public Item sample(){
		return list.get(random());
	}
	
	private int random(){
		if(size() == 0) throw new NoSuchElementException();
		return (int) (Math.random()*(double)size());
	}
	
	@SuppressWarnings("unchecked")
	private RandomizedQueue<Item> copy(){
		RandomizedQueue<Item> c = new RandomizedQueue<Item>();
		c.list = (ArrayList<Item>) list.clone();
		return c;
	}
	
	public Iterator<Item> iterator(){
		return new RandomIterator<Item>((RandomizedQueue<Item>)this.copy());
	}
	
	private class RandomIterator <Item> implements Iterator<Item>{
		
		private RandomizedQueue<Item> list;
		
		public RandomIterator(RandomizedQueue<Item> l){
			list = l;
		}
		
		@Override
		public boolean hasNext() {
			return !list.isEmpty();
		}

		@Override
		public Item next() {
			return list.dequeue();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	

}
