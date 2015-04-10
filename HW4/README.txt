README.txt

Hw Assignment #4
Sanjna Verma

ETNode class is the class that represents a node in an expression tree

Classes: Converter, ETNode, ExpressionTree
Converter
altered from HW1 to fix parentheses and postfix order
<<can check using calculator, pfconsle, etc>>



ETNode: 
A generically implemented node inside the ExpressionTree.  

--data members are its element value, which is of type AnyType, and the ENode values "left child" and "right child". 

--The constructors allow for passing in children or not, and there is another method to check if the node is a leaf(if both children are null)

ExpressionTree: 
Wanted to do this for recInorder() 
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

however the parentheses are off, so worked with Diego to evaluate each case. 


expression tree
uses ETNode class to create expression tree and its respective nodes 
preOrder and postOrder were simple to calculate
inOrder is just very frustrating as aforementioned

