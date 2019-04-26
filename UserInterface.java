package eg.edu.alexu.csd.datastructure.stack.cs15;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a new stack\r\n" + 
				"2- Push new element\r\n" + 
				"3- Pop\r\n" + 
				"4- Peek\n"+
				"5- Get size\r\n" + 
						"6- Check if empty\r\n" + 
						"7- Set expression which need convert it from infix to postfix");
		System.out.println("====================================================================");
		Scanner scan=new Scanner(System.in);
		int num_of_operation=scan.nextInt();
		ImplementationOfStack stack=new ImplementationOfStack();
		
		while(true)
		{
			int found=0;
			if((0<num_of_operation)&&(num_of_operation<8))
			{
				found=1;
			}
			else 
			{
				System.out.println("please Enter number from 1 to 7 to Chose the Operation");
				num_of_operation=scan.nextInt();
				while((0>num_of_operation)||(num_of_operation>8))
				{
					System.out.println("please Enter number from 1 to 7 to Chose the Operation");
					num_of_operation=scan.nextInt();
				}
			}
			
			if(found==1)
			{
				if(num_of_operation==1)
				{
					ImplementationOfStack stack1=new ImplementationOfStack();
					stack=stack1;
				}
				else if(num_of_operation==2)
				{
					System.out.println("Insert the element which need store it");
					Object element=scan.next();
					stack.push(element);
				}
				else if(num_of_operation==3)
				{
					System.out.println("Value of object :"+ stack.pop());
				}
				else if(num_of_operation==4)
				{
					System.out.println("Value of object :"+ stack.peek());
				}
				else if(num_of_operation==5)
				{
					System.out.println("The size of stack is ="+" "+ stack.size());
				}
				else if(num_of_operation==6)
				{
					if (stack.isEmpty())
					{
						System.out.println("the stack is Empty");
					}
					else
					{
						System.out.println("the stack is not Empty");
					}
				}
				else 
				{
					System.out.println("Insert the expression : ");
					Scanner scanner = new Scanner(System.in);
					String username = scanner.nextLine();
					IExpressionEvaluator y=new Application();
					String w=y.infixToPostfix(username );
					System.out.println("The result of convert is  : " + w );
					System.out.println("The result of evaluate is  : " + y.evaluate(w) );
					
				}
				System.out.println("====================================================================");
				System.out.println("Please choose an action\r\n" + 
						"1- Set a polynomial variable, ... etc\r\n" + 
						"====================================================================");
				num_of_operation=scan.nextInt();
			}
			
			
		}
	}

}
