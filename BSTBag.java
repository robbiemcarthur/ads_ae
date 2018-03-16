import java.util.Iterator;

public class BSTBag<E extends Comparable<E>> implements Bag {

	/**
	 * Inner class
	 */
	private static class Node <E extends Comparable<E>>
	{
		protected CountedElement<E> element;
		protected Node<CountedElement<E>> left, right;

		protected Node(CountedElement<E> elem) 
		{
			element = elem;
			left = null; right = null;
		}
	}
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
		return size;
	}

	@Override
	public boolean contains(Object element) {
		if(this.contains(element))
		{
			return true;
		}
		else
		{
			return false;
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

		}
	}

	@Override
	public void add(Object element) {

	}

	@Override
	public void remove(Object element) {
		int direction = 0;
		Node<CountedElement<E>> parent = null, curr = root;

	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

