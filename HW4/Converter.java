

public class Converter{
	String sequence;
	private String infix;
	private static String outputSequence = "";
	private static String characterExp = "(*/^+-)";
	private static String priority1 ="*^/"; //characterExp[1], [2], [3]
 	private static String priority2= "+-"; //characterExp[4], [5]
	private static char openP = '('; //characterExp[0]
	private static char closeP = ')';//, [6]
	
	public static String toPostFix(String infix) {
		ArrayStack<Character> symbolStack = new ArrayStack<Character>();
		char starter = 's';
		symbolStack.push(starter);
		
		for (int i = 0; i < infix.length(); i++) {
			char infixChar = infix.charAt(i);
			
			CharSequence infixCharSeq = infix.charAt(i)+"";
			
			//System.out.println(infixCharSeq);//infix.charAt(i));
			
			if (characterExp.contains(infixCharSeq)) {
				//infixchar is a symbol
				//determine what priority it is
				/**
				 * if infix char is priority 1 and the top of the stack is also P1, then 
				 * pop stack, and push infix
				 * 
				 * if infix char is priority 2 and top of stack is p1, then push infix
				 * 
				 * if infix char is openP, then push
				 * 
				 * if infix char is closeP, then pop everything until you get to openP
				 * when you get to openP, just pop without adding to the output sequence
				 * 
				 * else if it is a number then add it to the output Sequence
				 */
				if (priority1.contains(infixCharSeq)) {
					if (priority1.contains(symbolStack.top()+"")) {
						// stack = *
						// infixChar = /
						//pop + and then push -
						//System.out.println("yay"+symbolStack.top());
						outputSequence += " "+symbolStack.top();
						symbolStack.pop();
						//System.out.println(i+" pushing "+infixChar);
						symbolStack.push(infixChar);
					}
					else {//
						symbolStack.push(infixChar);	
					}
				}
				
				else if (priority2.contains(infixCharSeq)) {
					
					if (priority2.contains(symbolStack.top()+"")) {
						//stack: +
						//infixChar = -
						//pop * and then push *
						
						outputSequence += " "+symbolStack.top()+ " ";
						symbolStack.pop();
						
						symbolStack.push(infixChar);
						
						
					}
					else {
						symbolStack.push(infixChar);
					}
					
				}
				else if (infixChar == openP) {
						symbolStack.push(infixChar);					
				}
				else if (infixChar == closeP) {
					while (symbolStack.top()!= '(') {
						//System.out.println(i+" we are popping bc of parenthese"+symbolStack.top());
						outputSequence += " "+symbolStack.top()+" ";
						symbolStack.pop();
					}
					symbolStack.pop();
				}
			}
			
			else if(Character.isDigit(infixChar)) {
				//outputSequence += " "+infixChar+ " ";
				String entireNum = " " +infixChar;
				int j = i+1;
				while (j<infix.length() && Character.isDigit(infix.charAt(j))){
					entireNum += "" +infix.charAt(j);
					j++;
				}
				i= j-1;
				outputSequence += entireNum+" ";
					
			}
		}
		
		while (symbolStack.top() != 's') {//(!symbolStack.isEmpty()) {
			if (symbolStack.top() == '(') {
				symbolStack.pop();
			}
			
			else {
				outputSequence += symbolStack.top() + " ";
				symbolStack.pop();
			}
		}
		if (symbolStack.top() == 's'){
				symbolStack.pop();
		}
		
		return outputSequence;
		
	}
}