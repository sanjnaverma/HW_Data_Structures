public class HuffmanNode implements Comparable<Object>
{
	   // - add constructors to initialize letter and frequency, etc.
	   // - add int compareTo(Object o) method so we can compare 
	   //   two HuffmanNodes based on their frequency attributes. 
	   // - we're going to build a .heap. of these HuffmanNodes...
   public String letter; 
   public Double frequency;
   public HuffmanNode left, right;

	public HuffmanNode(String letter, Double frequency) {
		//. This constructor creates a new HuffmanNode where letter is set to l, 
		//frequency is set to f, and left and right are set to null.
		left = null;
		right = null; 
		this.frequency = frequency;
		this.letter = letter;
	}
	
	public HuffmanNode(HuffmanNode l, HuffmanNode r) 
	{
		
		//. This constructor creates a new HuffmanNode from its two children 
		//(i.e. the two nodes passed as parameters should become children of the new node), 
		//setting the letter variable to the concatenation of left.letter & right.letter, 
		
		//and the frequency variable to the sum of left.frequency & right.frequency.
		
		
		this.letter = l.letter + r.letter;
		this.frequency = l.frequency + r.frequency;
		this.left = l;
		this.right = r;
	}
	
	public String toString() {
		return "<"+letter+", "+frequency+">";
		//. Place this method in the HuffmanNode class.  xx
		//It returns a string of form "<"+letter+", "+frequency+">". 
		//There's no need to recursively iterate left/right pointers in this method. 
		//It may help you to better debug your assignment if you also add toString() methods 
		//in the BinaryHeap and HuffmanTree classes. I'll let you figure out on your own how these 
		//methods should behave...
	}
	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		//Place this method in the HuffmanNode class. 
		//This method casts Object o into a HuffmanNode object called huff.
		//We then return this.frequency.compareTo(huff.frequency).
		//This allows us to make a heap of HuffmanNodes where the frequency determines which node 
		//is larger than which... (This is the primary reason we make frequency of type Double 
		//rather than double...)
		
		//HuffmanNode huff = (HuffmanNode) o;
		//return this.frequency.compareTo(huff.frequency);
		
		HuffmanNode huff = (HuffmanNode) o;
		return this.frequency.compareTo(huff.frequency);
		}
}
