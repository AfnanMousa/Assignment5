package eg.edu.alexu.csd.datastructure.stack.cs15;

import java.util.EmptyStackException;

public class ImplementationOfStack implements IStack {

	Object value;
	ImplementationOfStack next;
	ImplementationOfStack head;
	int Size;
	ImplementationOfStack(ImplementationOfStack head)
	{
		this.head=head;
	}
	ImplementationOfStack()
	{
		
	}
	public void push(Object element)
	{
		ImplementationOfStack help=new ImplementationOfStack();
		help.value=element;
		help.next=head;
		head=help;
		Size++;
	}
	public Object pop()
	{
		Object element ;
		if(Size==0)
		{
			throw new EmptyStackException();
		}
		else 
		{
			element=head.value;
			head=head.next;
			Size--;
			return element;
		}
	}
	public Object peek()
	{
		Object element ;
		if(Size!=0)
		{
			element = head.value;
			return element;
		}
		else
		{
			throw new EmptyStackException();
		}
	}
	public boolean isEmpty()
	{
		if(Size==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int size()
	{
		return Size;
	}
}
