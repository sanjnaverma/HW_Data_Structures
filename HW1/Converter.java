

public class Converter extends ArrayStack{
	String sequence; 
	private String infix;
	private static String outputSequence = "";
	
	public static String toPostFix(String infix){
		// It will convert the infix expression to a postfix expression.
		ArrayStack<Character> symbolStack = new ArrayStack<Character>(infix.length());
		
		
		for (int i = 0; i < infix.length(); i++){
			char infixCharacter = infix.charAt(i);
			
			if (infixCharacter == '('){
				System.out.println("read open parenthesis");
				symbolStack.push(infixCharacter);
			}
			else if (infixCharacter == ')'){
				System.out.println("read close parenthesis");
				while (!symbolStack.isEmpty() && symbolStack.top() != '('){
					symbolStack.pop();
				}
				if (!symbolStack.isEmpty() && symbolStack.top() == '('){
					symbolStack.pop();
					continue;
				}
			}
			else if (infixCharacter == '*'){
				System.out.println("read *");
				if (symbolStack.isEmpty()){
					symbolStack.push(infixCharacter);
				}
				else if (!symbolStack.isEmpty()){
					if ((char)symbolStack.top() == '/' || (char)symbolStack.top() == '^'|| (char)symbolStack.top()=='*'){
						outputSequence += symbolStack.top() +" ";
						symbolStack.pop();
						symbolStack.push(infixCharacter);
					}
					else{
					symbolStack.push(infixCharacter);}
					
				}
			}
			else if (infixCharacter == '/'){
				System.out.println("read /");
				if (symbolStack.isEmpty()){
					symbolStack.push(infixCharacter);
				}
				else if (!symbolStack.isEmpty()){
					if ((char)symbolStack.top() == '*' || (char)symbolStack.top() == '^' || (char)symbolStack.top()=='/'){
						outputSequence += symbolStack.top() +" ";
						symbolStack.pop();
						symbolStack.push(infixCharacter);
					}
					else{
					symbolStack.push(infixCharacter);}
					
				}
			}
			
			else if (infixCharacter == '^'){
				System.out.println("read ^");
				if (symbolStack.isEmpty()){
					symbolStack.push(infixCharacter);
				}
				else if (!symbolStack.isEmpty()){
					if ((char)symbolStack.top() == '*' || (char)symbolStack.top() == '/'|| (char)symbolStack.top()=='^'){
						outputSequence += symbolStack.top() +" ";
						symbolStack.pop();
						symbolStack.push(infixCharacter);
					}
					else{
					symbolStack.push(infixCharacter);}
					
				}
			}
			else if (infixCharacter == '+'){
				System.out.println("read +");
				if (symbolStack.isEmpty()){
					symbolStack.push('+');
				}
				else if (!symbolStack.isEmpty()){
					if ((char)symbolStack.top() == '-'|| (char)symbolStack.top()=='-'){
						outputSequence += symbolStack.top() +" ";
						symbolStack.pop();
						//symbolStack.push(infixCharacter);
						if (symbolStack.isEmpty()){
							symbolStack.push(infixCharacter);
						}
					}
					else{
					symbolStack.push(infixCharacter);}
					
				}
				 
			}
			else if (infixCharacter == '-'){
				System.out.println("read -");
				if (symbolStack.isEmpty()){
					symbolStack.push(infixCharacter);
				}
				else if (!symbolStack.isEmpty()){
					if ((char)symbolStack.top() == '+'|| (char)symbolStack.top()=='+'){
						outputSequence += symbolStack.top() +" ";
						symbolStack.pop();
						symbolStack.push(infixCharacter);
					}
					else{
					symbolStack.push(infixCharacter);}
					
				}
			}
			
			else{
				//assuming is a number...
				//int digiCharacter = (int)infixCharacter; 
				if (Character.isDigit(infixCharacter)){
					System.out.println("read digit: " + infixCharacter);
					String number = ""+ infixCharacter;
					
					int j = i + 1; //that way you can evaluate the next character to see isDigit
					while (j < infix.length() && Character.isDigit(infix.charAt(j))){
						number += ""+infix.charAt(j);
						j++;
					}
					
					i = j-1;
					outputSequence += number+" ";
				}
				
			}	
			while (!symbolStack.isEmpty()){
				//Character popped = symbolStack.pop();
				outputSequence += symbolStack.top()+" ";
				symbolStack.pop();
				//System.out.println(outputSequence);
			}
		}
		return outputSequence;
		
		//once run through the string, pop the number stack
	}
	
	
}
