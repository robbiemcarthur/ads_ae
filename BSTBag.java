import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Robbie McArthur - 2098323m
 *
 */

public class BSTBag<E extends Comparable<E>> implements Bag<CountedElement<E>> {

	/**
	 * Inner class
	 */
	private static class Node <E extends Comparable<E>>
	{
		protected E element;
		protected Node<E> left, right;

		protected Node(E elem) 
		{
			element = elem;
			left = null; right = null;
		}
	}

	/**
	 * Outer class
	 */
	private Node<CountedElement<E>> root;
	private int size;

	public BSTBag() 
	{
		root = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		if(root==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int size() {
		if(root==null)
		{
			return 0;
		}
		else
		{
		return size; 
		}
	}

	@Override
	public boolean equals(Bag that) {
		if(this==that)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clear() {
		{
			root = null;
		}
	}

	@Override
	public boolean contains(CountedElement<E> element) {
		Node<CountedElement<E>> curr = root;
		int direction = 0;
				
		for(;;) 
		{
			if(curr == null||curr.element.getCount()==0) // if null or 0, element not technically there
			{
				return false;
			}
			direction = element.compareTo(curr.element);
			if(direction==0)
			{
				if(curr.element.getCount()>0)
				{
					return true;
				}
			}
			else if(direction<0)
			{
				curr = curr.left;
			}
			else // direction > 0
			{
				curr = curr.right;
			}
		}
	}

	@Override
	public void add(CountedElement<E> element) {
		// TODO Auto-generated method stub
		size++;
		int direction = 0;
		Node<CountedElement<E>> parent = null, curr = root;
		for(;;)
		{
			if(curr==null)
			{
				Node<CountedElement<E>> ins = new Node<CountedElement<E>>(element);
				if(root==null)
				{
					root= ins;
				}
				else if(direction<0)
				{
					parent.left = ins;
				}
				else // direction>0
				{
					parent.right=ins;
				}
				return; // terminate
			}
			direction = element.compareTo(curr.element);
			if(direction==0)
			{
				return; // terminate
			}
			parent = curr;
			if(direction<0)
			{
				curr = curr.left;
			}
			else // direction > 0
			{
				curr = curr.right;
			}

		}
	}

	@Override
	public void remove(CountedElement<E> element) {
		int direction = 0;
		Node<CountedElement<E>> parent = null, curr = root;
		for(;;) 
		{
			if(curr == null) 
			{
				return; // terminate, not found
			}
			direction = element.compareTo(curr.element);
			if(direction == 0) 
			{
				if(curr.element.getCount()>0)
				{
					curr.element.setCount(curr.element.getCount()-1);
					size--;
				}
				return;
			}
			parent = curr;
			if(direction<0)
			{
				curr = parent.left;
			}
			else // direction > 0
			{
				curr = parent.right;
			}
		}
	}

	@Override
	public Iterator iterator() {
		return new BSTBag.InOrderIterator();
	}
	
	private class InOrderIterator implements Iterator{
		private Stack<Node<E>> track;

		private InOrderIterator() {
			track = new LinkedStack<Node<E>>();
			for (Node<E> curr = (Node<E>) root; curr != null; curr = curr.left) {
				track.push(curr);
			}
		}

		@Override
		public boolean hasNext() {
			return (! track.empty() );
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			Node<E> place = (Node<E>) track.pop();
			for(Node<E> curr = place.right; curr!= null; curr = curr.left) {
				track.push(curr);
			}
			return (E) ((CountedElement<E>) place.element).getElement(); 
		}

	}

}



