//package llHomework;
/*Add functions for setting info of Node and returning info
 *Add functions for setting info of Link and returning info
 *Example takes integers, allow integers to be set
 */



public class LLNode<T> {
  protected T info;
  protected LLNode<T> link;
  
  public LLNode(T info)
  {
    this.info = info;
    link = null;
  }
 
  //Set info T of LLStringNode
  public void setInfo(T info)
  {
    this.info = info;
  }

  // Return info T of this LLStringNode
  public T getInfo()
  {
    return info;
  }

  // Set link
  public void setLink(LLNode link)

  {
    this.link = link;
  }

  // Return node's link
  public LLNode getLink()

  {
    return link;
  }
  
  public LLNode(T info, LLNode<T> link) {
	  	this.info = info;
		this.link = link;
	}
	
	public LLNode<T> pushValue(T info) {
		return new LLNode<T>(info, this);
	}
}