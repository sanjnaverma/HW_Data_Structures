
public class FastMaximizer implements Maximizer<Integer> {

	
	@Override
	public Integer getMax(Integer t1, Integer t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getGlobalMin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		FastMaximizer max = new FastMaximizer();  //     --> Instantiates an object of type IntMax
		SlowMaxStack<Integer> stack = new SlowMaxStack<Integer>(max);//   --> Uses the FastMaximizer object as a parameter

		//Now we push the stack:

		stack.push(10);     //Please see my email about the bug in the push() method
		stack.push(20);     //of SlowMaxStack.
		stack.push(100);
		stack.push(30);
		stack.push(25);

		//Now if you call 
		System.out.println(stack.getMaxSoFar());
		
	}
	
	

}
