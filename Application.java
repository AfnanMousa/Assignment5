package eg.edu.alexu.csd.datastructure.stack.cs15;

/**
 * Date: April
 * this class contain function which convert from infix to postfix and evaluate..
 * @author Afnan
 * @version 0.1
 * 
 */
public class Application implements IExpressionEvaluator {
    /**
     * add the parentheses to the equation 
     * @param editing linked list of equation which split 
     * @return equation with parentheses
     */
  public static String help (SingleLinkedList editing) {
    	for(int i=0;i<editing.size();i++){
	    	if((editing.get(i).equals("*"))||(editing.get(i).equals("/"))){
	    		String temp="("+editing.get(i-1)+editing.get(i)+editing.get(i+1)+")";
	    		editing.remove(i-1);
	    		editing.remove(i-1);
	    		editing.remove(i-1);
	    		editing.add(i-1, temp);
	    		i -- ;
	    	}
	    }
	    for(int i=0;i<editing.size();i++){
	    	if((editing.get(i).equals("+"))||(editing.get(i).equals("-"))){
	    		String temp="("+editing.get(i-1)+editing.get(i)+editing.get(i+1)+")";
	    		editing.remove(i-1);
	    		editing.remove(i-1);
	    		editing.remove(i-1);
	    		editing.add(i-1, temp);
	    		i--;
	    	}
	    }
	    return (String) editing.get(0);
    }
    /**
     * split the equation but safe the negative number
     * @param editing linked list of equation which split 
     * @return Modified the linked list 
     */
    public static SingleLinkedList NegativeNum (SingleLinkedList editing )
    {
		for(int z=0;z<editing.size();z++)
		{
			if(z+1<editing.size())
			{
				String go_quick=(String) editing.get(z+1);
				String go_quick1=(String) editing.get(z+2);
				String go_quick2=(String) editing.get(z);
				if ((((String) editing.get(z)).matches("[-+/%*]+"))&&(((String) editing.get(z+1)).matches("[-+]+")))
				{
					editing.remove(z+1);
					editing.remove(z+1);
					editing.add(z+1, go_quick+go_quick1);
				}
				else if((((String) editing.get(z)).matches("[-+]+"))&&(!(((String) editing.get(z+1)).matches("[-+/%*()]+"))))
				{
					editing.remove(z);
					editing.remove(z);
					editing.add(z, go_quick2+go_quick);
				}
	
			}
			 
		}
		return editing;
    }
	
	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.stack.cs15.IExpressionEvaluator#infixToPostfix(java.lang.String)
	 */
	
	public String infixToPostfix(String expression)
	{
		SingleLinkedList  editing=new SingleLinkedList();
		expression=expression.replace(" ", "");
		String[] yes =expression .split("(?<=[-+*/%(),])(?=.)|(?<=.)(?=[-+*/%(),])");
		
		for(int z=0;z<yes.length;z++)
		{
			editing.add(yes[z]);
		}
		editing=NegativeNum(editing);
		for(int i=0;i<editing.size();i++)
		{
			int count=0;
		  if(editing.get(i).equals("("))
			{
				String temp="";
				count++;
				
				int j=i;
				j++;
				while(count!=0)
				{
					if(editing.get(j).equals("("))
					{
						count++;
					}
					else if(editing.get(j).equals(")"))
					{
						count--;
						int z=j-1;
						SingleLinkedList yub=new SingleLinkedList();
						while(!editing.get(z).equals("("))
						{
							yub.add(0,editing.get(z));
							z--;
						}
						
						for(int w=z;w<=j;w++)
						{
							editing.remove(z);
						}
						temp=help(yub);
						editing.add(z, temp);
						j=z;
					}
					 j++;
			  }
				i=j-1;
				
			}
		}
		
		String help_please=help(editing);
		SingleLinkedList afnan=new SingleLinkedList();
	    String[] preper_num = (help_please).split("(?<=[-+*/%(),])(?=.)|(?<=.)(?=[-+*/%(),])");
	    for(int z=0;z<preper_num.length;z++)
		{
	    	afnan.add(preper_num[z]);
		}
	    afnan=NegativeNum(afnan);
	    ImplementationOfStack to_postfix=new ImplementationOfStack();
	    String infix_To_Postfix="";
	   for(int i=0;i<afnan.size();i++)
	   {
		   while(!afnan.get(i).equals(")"))
		   {
			   to_postfix.push(afnan.get(i));
			   i++;
		   }
		   ImplementationOfStack temp=new ImplementationOfStack();
		   String help1=(String) to_postfix.pop();
		   while(!help1.equals("("))
		   {
			   temp.push(help1);
			   help1=(String) to_postfix.pop();
		   }
		   SingleLinkedList try_more=new SingleLinkedList();
		   while(!temp.isEmpty())
		   {
			   try_more.add((String) temp.pop());
		   }
		   if(try_more.size()>4)
		   {
			   
		   }
		   else
		   {
			   infix_To_Postfix=try_more.get(0)+" "+try_more.get(2)+" "+try_more.get(1);
		   }
		   to_postfix.push(infix_To_Postfix);	  
	   }
		
	  /* System.out.println(infix_To_Postfix);
		for(int i=0;i<editing.size();i++)
		{
			System.out.print(editing.get(i));
		}
		System.out.println();
		for(int i=0;i<preper_num.length;i++)
		{
			System.out.println(preper_num[i]);
		}*/
		return infix_To_Postfix;
	}
	
	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.stack.cs15.IExpressionEvaluator#evaluate(java.lang.String)
	 */
	public int evaluate(String expression)
	{
		//String work=infixToPostfix(expression);
		String[] preper_num = expression.split(" ");
		ImplementationOfStack operands=new ImplementationOfStack();
		for(int i=0;i<preper_num.length;i++)
		{
			if((!preper_num[i].equals("+"))&&(!preper_num[i].equals("*"))&&(!preper_num[i].equals("-"))&&(!preper_num[i].equals("/")))
			{
				operands.push(preper_num[i]);
			}
			else
			{
				//int help1=Integer.parseInt((String) operands.pop());
				//int help2=Integer.parseInt((String) operands.pop());
				float help1=Float.parseFloat((String) operands.pop());
				float help2=Float.parseFloat((String) operands.pop());
				String temp="";
				float x;
				if(preper_num[i].equals("+"))
				{
					x=help2+help1;
				}
				else if(preper_num[i].equals("-"))
				{
					x=help2-help1;
				}
				else if(preper_num[i].equals("*"))
				{
					x=help2*help1;
				}
				else
				{
					x=help2/help1;
				}
				temp=""+Float.toString(x);
				operands.push(temp);
			}
		}
		float x=Float.parseFloat((String) operands.pop());
		int y=(int) x;
		//System.out.println(y);
		return y;
	}
}
