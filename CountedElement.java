/**
 * 
 * @author Robbie McArthur - 2098323m
 *
 */
public class CountedElement<E extends Comparable<E>> implements Comparable<CountedElement<E>> {
	private E element;
	private int count;

	public CountedElement(E e, int count){
		this.element = e;
		this.count = count;
	}
	
	public CountedElement(E e){
		this.element = e;
	}

	//add getters and setters
	public E getElement() 
	{
		return element;
	}
	
	public void setElement(E e) 
	{
		this.element = e;
	}
	
	public int getCount() 
	{
		return count;
	}
	
	public void setCount(int n) 
	{
		this.count = n;
	}
	
	public void incrementCount() {
		count++;
	}
	
	//add toString() method
	public String toString() {
		String output = ("("+getElement()+","+getCount()+"), ");
		return output;
	}
	
	public int compareTo(CountedElement<E> sC1) {
	    return this.element.compareTo(sC1.element);
	}

}
