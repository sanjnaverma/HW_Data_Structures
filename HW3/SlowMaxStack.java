public class SlowMaxStack<T> implements MaxStack<T> {

	private final Maximizer<T> maximizer;
	private LLNode<T> top;
	
	public SlowMaxStack(Maximizer<T> maximizer) {
		this.maximizer = maximizer;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void push(T info) {
		//top = top.pushValue(info);
		if (top == null){
			LLNode<T> newNode = new LLNode<T>(info, null);
			top = newNode;
		}
		else{
			top = top.pushValue(info);
		}
	}

	@Override
	public T pop() {
		T info = top.info;
		top = top.link;
		return info;
	}

	@Override
	public T getMaxSoFar() {
		T currentMax = maximizer.getGlobalMin();
		
		for(LLNode<T> node = top; node != null; node = node.link) {
			currentMax = maximizer.getMax(currentMax, node.info);
		}
		
		return currentMax;
	}
	public static void main(String[] args){
		IntMax integerMaximizer = new IntMax();            //Instantiate a maximizer
		SlowMaxStack<Integer> slowStack = new SlowMaxStack<Integer>(integerMaximizer);//
		FastMaxStack<Integer> fastStack = new FastMaxStack<Integer>(integerMaximizer);
		
		slowStack.push(5);
		slowStack.push(15);
		slowStack.push(25);
		slowStack.push(15);
		slowStack.push(55);
		slowStack.push(45);
		slowStack.push(65);
		System.out.println("slow max: "+ slowStack.getMaxSoFar());

		fastStack.push(5);
		fastStack.push(15);
		fastStack.push(25);
		fastStack.push(15);
		fastStack.push(55);
		fastStack.push(45);
		fastStack.push(65);
		
		System.out.println("fast max: "+ fastStack.getMaxSoFar());
		
	}
	

}