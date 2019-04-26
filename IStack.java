package eg.edu.alexu.csd.datastructure.stack.cs15;

public interface IStack {

	/**
	 * @return
	 */
	public Object pop();
	/**
	 * @return
	 */
	public Object peek();
	/**
	 * @param element
	 */
	public void push(Object element);
	/**
	 * @return
	 */
	public boolean isEmpty();
	/**
	 * @return
	 */
	public int size();
}
