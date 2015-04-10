


//T denotes anytype

public class ETNode<T>{// extends Comparable<T>>{
	  // Used to hold references to ETNode nodes for the linked implementation
	  protected T info;                // The info in an ET node
	  protected ETNode<T> left;       // A link to the left child node
	  protected ETNode<T> right;      // A link to the right child node

	  public ETNode(T info)
	  {
	    this.info = info;
	    left = null;
	    right = null;
	  }
	 
	  

	public void setInfo(T info)
	  // Sets info of this ETNode.
	  {
	    this.info = info;
	  }

	  public T getInfo()
	  // Returns info of this ETNode.
	  {
	    return info;
	  }
	 
	  public void setLeft(ETNode<T> link)
	  // Sets left link of this ETNode.
	  {
	    left = link;
	  }

	  public void setRight(ETNode<T> link)
	  // Sets right link of this ETNode.
	  {
	    right = link;
	  }
/**
 * Rather than calling .getLeft, i can just say x.left because variables declared above. 
 */
	  public ETNode<T> getLeft()
//	  // Returns left link of this ETNode.
	  {
	    return left;
	  }

	  public ETNode<T> getRight()
//	  // Returns right link of this ETNode.
	  {
	    return right;
	  }
	  
	  boolean isLeaf(){//it is a leaf if the node has no children
			if(this.left == null && this.right == null){
				return true;
			}else{
				return false;
			}
		}

}
