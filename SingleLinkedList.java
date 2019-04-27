package eg.edu.alexu.csd.datastructure.stack.cs15;

/**
 * this class implement the linked list 
 * @author ibm
 * 
 */
public class SingleLinkedList {
  Object value;
  SingleLinkedList next;
  SingleLinkedList head;
  public SingleLinkedList(SingleLinkedList head) {
    this.head = head;
  }
  public SingleLinkedList() {
  }
  /**
   * get the size of linked list.
   * @return size
   */
  public int size() {
    SingleLinkedList help = head;
    int count = 0;
    while (help != null) {
      help = help.next;
      count++;
    }
    return count;
  }
  /**
   * add element in the last linked list.
   * @param element which need add it
   */
  public void add(Object element) {
    SingleLinkedList n = new SingleLinkedList();
    n.next = null;
    n.value = element;
    SingleLinkedList help = head ;
    if (head == null) {
      head = n;
    } else {
      while (help.next != null) {
        help = help.next;
      }
      help.next = n;
    }
  }

  /**
   * add element in a certain place .
   * @param index
   * @param element
   */
  public void add(int index, Object element) {
    SingleLinkedList help = head;
    int count = 0;
    if (index == 0) {
      SingleLinkedList New_Node = new SingleLinkedList();
      New_Node.value = element;
      New_Node.next = head;
      head = New_Node;	
    } else if (index == (size())) {
      add(element);
    } else if ((help != null) && (index < size())) {
      while ((help != null) && (count < index - 1)) {
        help = help.next;
        count++;
      }
      SingleLinkedList New_Node = new SingleLinkedList();
      New_Node.value = element;
      New_Node.next = help.next;
      help.next = New_Node;
   }
  }
  /**
   * get the element which in certain place index.
   * @param index the number of index.
   * @return
   */
  public Object get(int index) {
    SingleLinkedList help = head;
    int count = 0;
    while ((index < size()) && (help != null)) {
      if (count == index) {
        break;
      } else {
    	help = help.next;
  		count++;    	  
      }
    }
    return help.value;
  }
  /**
   * set the element in certain index.
   * @param index
   * @param element
   */
  public void set(int index, Object element) {
    SingleLinkedList i = head ;
    int counter = 0;
    while (i != null) {
      if (counter == index) {
        i.value = element;
      }
      i = i.next;
      counter++;
    }
  }
  /**
   *  remove element in linked list which have index
   * @param index ..
   */
  public void remove(int index) {
    SingleLinkedList help = head;
    int count = 0;
    int found = 0;
    if ((size() == 1) || (index == 0)) {
      head = head.next;
    } else {
      while ((index < size()) && (help.next != null)) {
        if (count == (index - 1)) {
          found = 1;
          break;
        } else {
          help = help.next;
          count++;
        }
      }
      if (found == 1) {
        help.next = help.next.next;
      } 
    } 
  }


}
