import java.util.Scanner;

//The book contains two classes: PostFixEvaluator and PFixConsole. 
//PostFixEvaluator takes a postfix expression and evaluates it. It has no main function. 
//PFixConsole is just a main function, and it opens a console for the user to type in postfix expressions 
//and get answers. Your calculator class should combine the functionality of both classes. 
//You will need to make the following changes:
//
//The input will be an infix expression instead of a postfix expression. 
//The prompt in PFixConsole needs to be changed.
//the Calculator class will instantiate an object of the Converter class in order to have the infix expression 
//converted to a postfix expression.
//An additional operator, "^", will be added. J
//ava has a build in exponent function: Math.pow(x, y). Use this to evaluate x^y
//Parentheses are legal in the infix expression 
//(Note: The parentheses are needed in the infix expression. 
//		After your Converter class' algorithm converts the expression to postfix, it will no 
//		longer have parentheses because they are not necessary in postfix expressions.)
public class Calculator extends PostFixEvaluator  {
	public static void main(String[] args)
	  {
	    Scanner conIn = new Scanner(System.in);

	    String line = null;          // string to be evaluated
	    String more = null;          // used to stop or continue processing
	    int result;                  // result of evaluation

	    do
	    {
	      // Get next expression to be processed.
	      System.out.println("Enter an infix expression to be evaluated: ");
	      line = conIn.nextLine();
	      
	      // Obtain and output result of expression evaluation.
	      try
	      {
	    	
	        line = Converter.toPostFix(line);
	        System.out.println("postfix exp: " + line);
	        result = evaluate(line);

	        // Output result.
	        System.out.println();
	        System.out.println("Result = " + result);
	      }
	      catch (PostFixException error)
	      {        
	        // Output error message.
	        System.out.println();
	        System.out.println("Error in expression - " + error.getMessage());
	      }

	      // Determine if there is another expression to process.
	      System.out.println();
	      System.out.print("Evaluate another expression? (Y=Yes): ");
	      more = conIn.nextLine();
	      System.out.println();
	    }
	    while (more.equalsIgnoreCase("y"));

	    System.out.println("Program completed.");
	  }
	
	public static int evaluate(String expression)
	  {
	    BoundedStackInterface<Integer> stack = new ArrayStack<Integer>(50);  

	    int value;
	    String operator;

	    int operand1;
	    int operand2;

	    int result = 0;

	    Scanner tokenizer = new Scanner(expression);

	    while (tokenizer.hasNext())
	    {
	      if (tokenizer.hasNextInt())
	      {
	        // Process operand.
	        value = tokenizer.nextInt();
	        if (stack.isFull())
	          throw new PostFixException("Too many operands - stack overflow");
	        stack.push(value);
	      }
	      else
	      {
	        // Process operator.
	        operator = tokenizer.next();
	        
	        // Obtain second operand from stack.
	        if (stack.isEmpty())
	          throw new PostFixException("Not enough operands - stack underflow");
	        operand2 = stack.top();
	        stack.pop();

	        // Obtain first operand from stack.
	        if (stack.isEmpty())
	          throw new PostFixException("Not enough operands - stack underflow");
	        operand1 = stack.top();
	        stack.pop();

	        // Perform operation.
	        if (operator.equals("/"))
	          result = operand1 / operand2;
	        else
	        if(operator.equals("*"))
	          result = operand1 * operand2;
	        else
	        if(operator.equals("+"))
	          result = operand1 + operand2;
	        else
	        if(operator.equals("-"))
	          result = operand1 - operand2;
	        else
	        if (operator.equals("^"))
	        	result = (int)Math.pow(operand1, operand2);
	        else
	          throw new PostFixException("Illegal symbol: " + operator);

	        // Push result of operation onto stack.
	        stack.push(result);
	      }
	    }

	    // Obtain final result from stack. 
	    if (stack.isEmpty())
	      throw new PostFixException("Not enough operands - stack underflow");
	    result = stack.top();
	    stack.pop();

	    // Stack should now be empty.
	    if (!stack.isEmpty())
	      throw new PostFixException("Too many operands - operands left over");

	    // Return the final.
	    return result;
	  }
}
