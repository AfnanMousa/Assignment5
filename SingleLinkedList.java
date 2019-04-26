package eg.edu.alexu.csd.datastructure.stack.cs15;

/**
 * this class implement the linked list 
 * @author ibm
 * 
 */
public class SingleLinkedList {
Object value ;
SingleLinkedList next;
SingleLinkedList head;
	 
public SingleLinkedList(SingleLinkedList head)
	 {
		 this.head=head;
	 }
	 public SingleLinkedList()
	 {
		 
	 }
	 /**
	  * get the size of linked list
	 * @return size
	 */
	public int size()
	 {
		 SingleLinkedList help=head;
		 int count=0;
		 while(help!=null)
		 {
			 help=help.next;
			 count++;
		 }
		 return count;
	 }
	 
	 /**
	  * add element in the last linked list
	 * @param element which need add it
	 */
	public void add(Object element)
	 {
		  SingleLinkedList n=new SingleLinkedList();
		  n.next=null;
		  n.value=element;
		  SingleLinkedList help=head ;
			if (head==null)
			{
				head=n;
			}
			else
			{
			  while (help.next!=null)
			  {
				help=help.next;
			  }
			   help.next=n;
			}
	 }
	 
	 /**
	  * add element in a certain place 
	 * @param index
	 * @param element
	 */
	public void add(int index, Object element)
	 {
		 SingleLinkedList help=head;
		 int count=0;
		 if(index==0)
		 {
			 SingleLinkedList New_Node=new SingleLinkedList();
			 New_Node.value=element;
			 New_Node.next=head;
			 head= New_Node;
		 }
		 else if(index==(size()))
		 {
			 add(element);
		 }
		 else if((help!=null)&&(index<size()))
		 {
			 while((help!=null)&&(count<index-1))
			 {
				 help=help.next;
				 count++;
			 }
			 SingleLinkedList New_Node=new SingleLinkedList();
			 New_Node.value=element;
			 New_Node.next=help.next;
			 help.next= New_Node; 
		 }
	 }
	 
	 /**
	  * get the element which in certain place index
	 * @param index
	 * @return
	 */
	public Object get(int index)
	 {
		 SingleLinkedList help=head;
		 int count=0;
		 while((index<size())&&(help!=null))
		 {
			 if(count==index)
			 {
				break;
			 }
			 else
			 {
				 help=help.next;
				 count++;
			 }
			
		 }
		 return help.value;
	 }
	 /**
	  * set the element in certain index
	 * @param index
	 * @param element
	 */
	public void set(int index, Object element)
	 {
		 SingleLinkedList i=head ;
		int counter=0;
		while (i!=null)
		{
		  if (counter==index)
		  {
			i.value=element;
		  }
			i=i.next;
			counter++;
		}
	}
	 /**
	 * clear the linked list
	 */
	public void clear()
	 {
		 if (size()!=0)
		 {
			 head.next=null;
			head=null; 
		 }
		
		//head.value=null;
		 
	 }
	 /**
	  * return true if the linked list is empty false in else
	 * @return true or false
	 */
	public boolean isEmpty()
	 {
		boolean check=false;	
		if (head==null&&size()==0)
		{
		  check=true;
		}	
		return check;
	}
	 /**
	  *  remove element in linked list which have index
	 * @param index
	 */
	public void remove(int index)
	 {
		 SingleLinkedList help=head;
		 int count=0;
		 int found=0;
		 if((size()==1)||(index==0))
		 {
			 head=head.next;
		 }
		 else
		 {
			 while((index<size())&&(help.next!=null))
			 {
				 if(count==(index-1))
				 {
					 found=1;
					 break;
				 }
				 else
				 {
					 help=help.next;
					 count++;
				 }
			 }
			 if(found==1)
			 {
				 help.next=help.next.next;
			 } 
		 } 
	 }
	 
	 /**
	  * sub list from the main linked list
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	public SingleLinkedList sublist(int fromIndex, int toIndex)
	 {
		SingleLinkedList sub=new SingleLinkedList() ;
		SingleLinkedList list2=new SingleLinkedList() ;
		int counter=0,i=0;
		Object [] list =new Object [size()];
		SingleLinkedList help=head;
		SingleLinkedList temp=head;
		int size= size();
		while(temp!=null) 
		{
		   list[i]=temp.value;
	       temp=temp.next;
		   i++;
		}
			
		if (fromIndex==toIndex) 
		{
			return sub;
		}
		while (help!=null)
		{
		  if (fromIndex==counter)
		  {
			sub.head=help;
			break;
		  }
			counter++;
			help=help.next;
		}
		int size2=sub.size();
		for(i=0;i<size-toIndex-1;i++)
		{
			sub.remove(size2-1);
			size2=size2-1;
		}
			
		for (i=0;i<list.length;i++)
		{
			list2.add(list[i]);
		}
		head=list2.head;
		return sub;
	}
	 
	 /**
	  * check if this object in linked list or not
	 * @param o
	 * @return
	 */
	public boolean contains(Object o)
	  {
		boolean check=false;
		SingleLinkedList help=head;
		while (help!=null)
		{
		   if(help.value==o)
		   {
	 		 check=true;
	 		 break;
		   }
		   help=help.next;
		 }
		return check;
	 }
	 

}
