import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque <Item> {

	private int size;
	private Node<Item> first;

	public Deque(){
		size = 0;
	}

	public boolean isEmpty(){
		return size() == 0;
	}

	public int size(){
		return size;
	}

	public void addFirst(Item item){
		if(item == null) throw new NullPointerException();

		Node<Item> newFirst = new Node<Item>(item);
		if(size() == 0){
			newFirst.circular();
			first = newFirst;
		}
		else{
			Node<Item> oldFirst = first;
			first = newFirst;
			first.setNext(oldFirst);
			first.setPrev(oldFirst.getPrev());
			oldFirst.setPrev(first);
			first.getPrev().setNext(first);
		}

		size++;

	}

	public void addLast(Item item){
		if(item == null) throw new NullPointerException();

		if(size == 0){
			addFirst(item);
			return;
		}
		else{
			Node<Item> newLast = new Node<Item>(item);
			Node<Item> oldLast = first.getPrev();
			newLast.setPrev(oldLast);
			newLast.setNext(first);
			oldLast.setNext(newLast);
			first.setPrev(newLast);
		}

		size++;
	}

	public Item removeFirst(){
		if(size() <= 0) throw new NoSuchElementException();

		Node<Item> newFirst = first.getNext();
		Node<Item> oldFirst = first;
		newFirst.setPrev(oldFirst.getPrev());
		oldFirst.getPrev().setNext(newFirst);
		first = newFirst;

		size--;

		return oldFirst.getMe();
	}

	public Item removeLast(){
		if(size() <= 0) throw new NoSuchElementException();

		Node<Item> newLast = first.getPrev().getPrev();
		Node<Item> oldLast = first.getPrev();
		newLast.setNext(first);
		first.setPrev(newLast);

		size--;

		return oldLast.getMe();
	}

	public Iterator<Item> iterator(){
		return new DequeIterator(first);
	}

	private class DequeIterator implements Iterator{

		private Node first;
		private Node curr;

		public DequeIterator(Node<Item> first){
			this.first = first;
			curr = first;
		}

		@Override
		public boolean hasNext() {
			return curr.getNext() != first;
		}

		@Override
		public Object next() {
			if(!hasNext())
				throw new NoSuchElementException();
			Object i = curr.getMe();
			curr = curr.getNext();
			return i;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private class Node<Item>{
		private Item me;
		private Node<Item> prev;
		private Node<Item> next;

		public Node(){
			this(null, null, null);
		}

		public Node(Item i){
			this(i, null, null);
		}

		public Node(Item i, Node<Item> n, Node<Item> p){
			me = i; next = n; prev = p;
		}

		public Item getMe() {
			return me;
		}

		public void setMe(Item me) {
			this.me = me;
		}

		public Node<Item> getPrev() {
			return prev;
		}

		public void setPrev(Node<Item> prev) {
			this.prev = prev;
		}

		public Node<Item> getNext() {
			return next;
		}

		public void setNext(Node<Item> next) {
			this.next = next;
		}

		public void circular(){
			prev = this;
			next = this;
		}

	}


}
