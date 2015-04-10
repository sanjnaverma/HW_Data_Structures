

import java.util.Scanner;
import java.util.StringTokenizer;

public class ExpressionTree {
	//so it can be accessed in any of your following methods --> stackOverflow reference
	private static ETNode<String> root;
	
	public static void main(String[] args) throws PostFixException, StackOverflowException, StackUnderflowException{
		Scanner scan = new Scanner(System.in);
		while(true) {//loop the prompt
			System.out.println("Enter an expression: ");
			String infix = scan.nextLine();
			
			//Create an ExpressionTree
			ExpressionTree myTree = new ExpressionTree(infix);
			
			//Call toPreOrder = root, left, right
			System.out.println("in pre order");
			toPreOrder();
			
			//Call toInOrder = left, root, right
			System.out.println("in in order");
			toInOrder();
			
			//Call toPostOrder = left, right, root
			System.out.println("in post order:");
			toPostOrder();
		}
	}
	public ExpressionTree(String infix) {
		//1) Convert infix to pstfix
		
		String pfixConversion = Converter.toPostFix(infix);//should be called converter
		//System.out.println(pfixConversion);
		
		//2) create an arraystack of type ETNode bc we will be pushing ETnodes 
		ArrayStack<ETNode<String>> s = new ArrayStack<ETNode<String>>();
		
		//3) create a tokenizer 
		Scanner token = new Scanner(pfixConversion);
		
		//4) while token.hasnext, check if is operator or operand
		
		while(token.hasNext()) {
			//System.out.println("Evaluating: "+ token.next());
			
			if (token.hasNextInt()){//is an operand number
				//make it an ETnode, push it to the stack

				ETNode<String> operand = new ETNode<String>(token.next());
				s.push(operand);
			}
			else {//operator (what if it is a variable.. ask in class)
				//make it an ETnode
				
				ETNode<String> operator = new ETNode<String>(token.next());
				operator.setRight(s.top());
				s.pop();
				operator.setLeft(s.top());
				s.pop();
				s.push(operator);
			}
		}
		root = s.top();
		s.pop();
		
		if (!s.isEmpty()){
			throw new PostFixException("Too many operands");
		}
	}
	//now root is addressed to our expression tree
	public static void toPreOrder(){
		recPreOrder(root);
		System.out.println();
	}
	
	private static void recPreOrder(ETNode<String> t){
		if(t == null){
			return;
		}
		System.out.print(t.getInfo() + " ");
		recPreOrder(t.getLeft());
		recPreOrder(t.getRight());
	}
	
	
	


	public static void toInOrder(){
		recInorder(root);
		System.out.println();
	}
//	public static void recInorder(ETNode<String> root){//left operand, operator, right operand. Normal writing.
//		if(root.isLeaf()){
//			System.out.print(root.getInfo());//simply print if there is no 
//		}else{
//			System.out.print("(");//to make sure order of operations are present
//			recInorder(root.left);//print left node
//			//System.out.print(")");//close
//			System.out.print(root.getInfo());//print current node
//			//System.out.print("(");
//			recInorder(root.right);//print right node
//			System.out.print(")");
//		}
//	}
	
	private static void recInorder(ETNode<String> t){
		if(t == null){
			return;
		}
		//use cases to sort in order --> with help from Diego 
		boolean leftP = false;
		boolean rightP = false;
		String expSign = "^";
		String divSign = "/";
		String multSign = "*";
		String addSign = "+";
		String subSign = "-";
				
		if(t.getInfo().equals(expSign)){
			if(t.getLeft().getInfo().equals(divSign)
					|| t.getLeft().getInfo().equals(multSign) 
					|| t.getLeft().getInfo().equals(addSign) 
					|| t.getLeft().getInfo().equals(subSign)){
				leftP = true;
			}
			if(t.getRight().getInfo().equals(divSign) 
					|| t.getRight().getInfo().equals(multSign) 
					|| t.getRight().getInfo().equals(addSign) 
					|| t.getRight().getInfo().equals(subSign)){
				rightP = true;
			}
		}
		else if(t.getInfo().equals(divSign)){
			if(t.getLeft().getInfo().equals(addSign) 
					|| t.getLeft().getInfo().equals(subSign)){
				leftP = true;
			}
			if(t.getRight().getInfo().equals(expSign)  //declare precedence
					|| t.getRight().getInfo().equals(divSign) 
					|| t.getRight().getInfo().equals(multSign) 
					|| t.getRight().getInfo().equals(addSign) 
					|| t.getRight().getInfo().equals(subSign)){
				rightP = true;
			}
		}
		else if(t.getInfo().equals(multSign)){
			if(t.getLeft().getInfo().equals(addSign) 
					|| t.getLeft().getInfo().equals(subSign)){
				leftP = true;
			}
			if(t.getRight().getInfo().equals(addSign) 
					|| t.getRight().getInfo().equals(subSign)){
				rightP = true;
			}
		}
		
		//Print parenthesis only if required; recursive call for left subtree
		if (leftP) 
			System.out.print("( ");
		recInorder(t.getLeft());
		if (leftP) 
			System.out.print(") ");
		
		System.out.print(t.getInfo() + " ");
		
		//Print parenthesis only if required; recursive call for right subtree
		if (rightP) 
			System.out.print("( ");
		recInorder(t.getRight());
		if (rightP) 
			System.out.print(") ");
	}
	
	
	public static void toPostOrder(){
		recToPostorder(root);
		System.out.println();
	}
	
	private static void recToPostorder(ETNode<String> t){
		if(t == null){
			return;
		}
		recToPostorder(t.getLeft());
		recToPostorder(t.getRight());
		System.out.print(t.getInfo() + " ");
	}
}
