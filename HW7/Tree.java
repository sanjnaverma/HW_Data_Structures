//This will be the main class
import java.util.Scanner;
import java.util.StringTokenizer;


public class Tree {
	private static int numElements;
	
	public static void main(String args[]) {
		String root = readFromInput();
		TreeNode r = inputToTree(root);
		//TreeNode r = inputToTree("a 0 ( b 4 ( * 100 b 6 ) w 9 ( x 3 y 5 ( * 2 z 3 ) ) )");

		System.out.println("Found '*' at distance: "+findClosest(r, "*"));
	}
	
	public static String readFromInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Evaluate: ");
		String in = scan.nextLine(); 
		return in;
	}
	
	public static TreeNode inputToTree(String s) {
		
		ArrayStack<TreeNode<String>> stack = new ArrayStack<TreeNode<String>>();
		Scanner token = new Scanner(s);//readFromInput());
		int numElements = 0;
		while(token.hasNext()) {
			String temp = token.next();
			if (temp.equals( "(")) {
				//do nothing
			}
			else if (temp.equals(")")) {
				/**
				 * pop off last two nodes (call them left_child, right_child)
				 * pop off a third node (call it parent)
				 * assign left_child, right_child as parent's children
				 * push parent back onto the stack
				 */
				 
				 TreeNode rightChild = stack.top();
				 stack.pop();
				 TreeNode leftChild = stack.top();
				 stack.pop();
				 stack.top().setRight(rightChild);
				 stack.top().setLeft(leftChild);
			}
			else {
				/**
				 * push a new TreeNode(label=temp, distance=getNextToken)
				 */
				double distance = token.nextDouble();
				TreeNode t = new TreeNode(temp, distance);
				stack.push(t);
				numElements+=1;
			}
		}
		return stack.top();
	}
	
	public static int findClosest(TreeNode root, Object search) {
		BinaryHeap minHeap = new BinaryHeap(numElements); 
		
		minHeap.insert(root);
		
		while (!minHeap.isEmpty()) {
			TreeNode<String> t = (TreeNode<String>) minHeap.deleteMin();
			while(t != null && !t.info.equals(search)){
    			
    			if(t.left!=null){
    				t.left.dist += t.dist;
    				minHeap.insert(t.left);
    			}
    			if(t.right!=null){
    				t.right.dist += t.dist;
    				minHeap.insert(t.right);
    			}
    			t = (TreeNode<String>) minHeap.deleteMin();
	    	} //this if loop ends if the element is not found. If the element was found, with min value, then it would've been returned
    		return (int) t.dist;
    	}
    	return -1;
		
	}
}
//read from input
//public int find closest(treenode root, object target)
/**
 * stack<treenode>
 * s = new stack<treenode>
 * 1) read input
 * 2) create tree w/ stack
 * 3) run FindClosest w bheap
 */