//package llHomework;

//Implement to equalLists() function. 
//Analyze the running time of equalLists()

//There is a static function in LLHomeworkFunctions called equalLists. 
//Currently, it compared the two lists by calling "list1 == list2". 
//We know that's incorrect because it's only comparing the addresses of the 
//lists, and not the contents. We want two lists with equal contents to be 
//equal.

public class LLHomeworkFunctions {

	static public void main(String [] args) {
		
		//Set up linked list A (LLNode.java) test case
		LLNode<Integer> linkListA1 = new LLNode<Integer>(1);
		LLNode<Integer> linkListA2 = new LLNode<Integer>(6);
		LLNode<Integer> linkListA3 = new LLNode<Integer>(0);
		LLNode<Integer> linkListA4 = new LLNode<Integer>(null);
		linkListA1.setLink(linkListA2);
		linkListA2.setLink(linkListA3);
		
		//Set up linked list B (LLNode.java) test case
		LLNode<Integer> linkListB1 = new LLNode<Integer>(2);
		LLNode<Integer> linkListB2 = new LLNode<Integer>(6);
		LLNode<Integer> linkListB3 = new LLNode<Integer>(8);
		linkListB1.setLink(linkListB2);
		linkListB2.setLink(linkListB3);		
		
		System.out.println(equalLists(linkListA1, linkListB1));
		
		//This test case should be false
		//Set up linked list A (LLNode.java) test case
		LLNode<Integer> linkListC1 = new LLNode<Integer>(1);
		LLNode<Integer> linkListC2 = new LLNode<Integer>(6);
		LLNode<Integer> linkListC3 = new LLNode<Integer>(0);
		LLNode<Integer> linkListC4 = new LLNode<Integer>(null);
		linkListC1.setLink(linkListC2);
		linkListC2.setLink(linkListC3);
				
		//Set up linked list D (LLNode.java) test case
		LLNode<Integer> linkListD1 = new LLNode<Integer>(1);
		LLNode<Integer> linkListD2 = new LLNode<Integer>(6);
		LLNode<Integer> linkListD3 = new LLNode<Integer>(0);
		LLNode<Integer> linkListD4 = new LLNode<Integer>(null);
		linkListD1.setLink(linkListD2);
		linkListD2.setLink(linkListD3);
		linkListD3.setLink(linkListD4);
		System.out.println(equalLists(linkListC1, linkListD1));
		
		//Should be false for second test case
		
	}
	
	/**
	 * @param <T>
	 * @param list1
	 * @param list2
	 * @return true if the lists are equal.  Assume both lists terminate.
	 */
	static public <T> boolean equalLists(LLNode<T> list1, LLNode<T> list2) {
		// TODO: Part 1 of this assignment is to implement this correctly.
		//check if the links of each list are equal
		boolean verdict = true;
		
		
		//loop through given that heads are not null
		while (list1.getLink() != null && list2.getLink() != null){
			if (list1.getInfo() != list2.getInfo()){
				return verdict = false;
			}
			//For debugging
			//System.out.println(list1.getInfo()+"   ||    "+list2.getInfo());
			
			list1 = list1.getLink();
			list2 = list2.getLink();
			//For debugging
			//System.out.println("Increment the first list: "+ list1.getInfo());
			//System.out.println("Increment the second list: "+ list2.getInfo());
			
		}

		if (list1.getLink() == null && list2.getLink() == null){
			if (list1.getInfo() != list2.getInfo()){
				verdict = false;
			}
		}
		else if (list1.getLink() == null || list2.getLink() == null){
			verdict = false;
		}
		return verdict;
		
	}
	
	/**
	 * @param <T>
	 * @param list1
	 * @return true if the list eventually terminates, and false if the list points back at one of it's
	 *  previous nodes.
	 */
	
	//If you keep calling list.link, you will never reach a NULL pointer. 
	//Instead, looking at the values, you'll keep repeating the sequence 4,2,5,4,2,5,4,2,5...
	//part 2 of the hw assignment
	static public <T> boolean terminates(LLNode<T> list) {
		//check for intersection by iterating through the nodes and checking for overlap
		//start at top of list, iterate through 
		boolean terminate = true;
		LLNode<Integer> var1 = (LLNode<Integer>) list; 
		LLNode<Integer> var2 = (LLNode<Integer>) list;
		
		while(terminate && var2.getLink() != null && var2.getLink().getLink() != null){ //use getLink().getLink() to run through the list twice as fast 
			var1 = var1.getLink();
			var2 = var2.getLink().getLink();
			if(var1 == var2)
				terminate = false;
		}
		return terminate;
	}
}