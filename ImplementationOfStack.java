package eg.edu.alexu.csd.datastructure.stack.cs15;

import java.util.EmptyStackException;
import java.util.Scanner;

public class ImplementationOfStack implements IStack {
  Object value;
  ImplementationOfStack next;
  ImplementationOfStack head;
  int size;
  ImplementationOfStack(ImplementationOfStack head) { 
    this.head = head;
  }
  ImplementationOfStack() {
  }
 /**
  * Pushes an item onto the top of this stack.
  * @param object to insert
  */
public void push(Object element) {
	/**
	 * another node to help stack.
	 */
    ImplementationOfStack help = new ImplementationOfStack();
    help.value = element;
    help.next = head;
    head = help;
    size++;
  }
 /**
  * Removes the element at the top of stack and returns that element.
  * @return top of stack element, or through exception if empty
  */
  public Object pop() {
    Object element;
    if (size == 0) {
      throw new EmptyStackException();
    } else {
      element = head.value;
      head = head.next;
      size--;
      return element;
    }
  }
 /**
  * Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  public Object peek() {
    Object element;
    if (size != 0) {
      element = head.value;
      return element;
    } else {
      throw new EmptyStackException();
    }
  }
 /**
  * Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }
 /**
  * Returns the number of elements in the stack.
  * @return number of elements in the stack
  */
  public int size() {
    return size;
  }
  public static void userinterface() {

  }
}
