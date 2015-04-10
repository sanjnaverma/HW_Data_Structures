public class FastMaxStack<T> implements MaxStack<T>{

	private final Maximizer<T> maximizer;
	private LLNode<T> top = null;
	private ArrayStack<T> myMax = new ArrayStack<T>(100);

	
	public FastMaxStack(Maximizer<T> maximizer) {
		this.maximizer = maximizer;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	//@SuppressWarnings("unchecked")
	@Override
	public void push(T info) {
		//In recitation went over need for a tracker stack 
		
		if(this.isEmpty()){
				top = new LLNode<T>(info, null);
				myMax.push(info);
			
		}
		else{
			top = top.pushValue(info);
			myMax.push(maximizer.getMax(myMax.top(), info));
		}
		LLNode<Integer> tempNode = new LLNode<Integer>((Integer) info);
		tempNode.setLink(top);
		top = (LLNode<T>) tempNode;
		if (top == null){
			LLNode<T> newNode = new LLNode<T>(info, null);
			top = newNode;
		}
		else top = top.pushValue(info);
		
		if (top == null){
			LLNode<T> newNode = new LLNode<T>(info, null);
		}
		else top = top.pushValue(info);

	}

	@Override
	public T pop() {
		T info = top.info;
		top = top.link;
		return info;
	}

	@Override
	public T getMaxSoFar() {
		T currentMax = null;
		if(!this.isEmpty()){
			return myMax.top();
		}
		else return null;
	}


}
