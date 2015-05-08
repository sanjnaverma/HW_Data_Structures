
public class TreeNode<T> implements Comparable<Object>{//<T extends Comparable<? super T>>{//<T extends Comparable<T>> implements Comparable{
	protected T info;
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	protected double dist;
	
	public TreeNode(T info, double distance) {
		this.info = info;
		this.dist = distance;
		left = null;
		right = null;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setLeft(TreeNode<T> link) {
		left = link;
	}
	
	public void setRight(TreeNode<T> link) {
		right = link;
	}
	
	public TreeNode<T> getLeft(){
		return left;
	}
	
	public TreeNode<T> getRight(){
		return right;
	}
	
	
	public String toString() {
		String s = "<"+this.info+", "+ dist+">";
		System.out.println(s);
		return s;
	}

	@Override
	public int compareTo(Object o) {
		TreeNode node = (TreeNode) o;
		
		double diff = this.dist - node.dist;
		double result = 0;
		if (diff >0) {
			result= 1;
		}
		else if (diff < 0 ) {
			result= -1;
		}
		else if (diff == 0) {
			result= 0;
		}
		return (int) result;
		
	}
}
