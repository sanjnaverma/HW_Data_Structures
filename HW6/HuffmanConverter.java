/**
 * It will take an ordinary text file, record the frequencies of characters
 * used in that file, then use assignment #4's code to find the 
 * Huffman encoding. 
 * 
 * Next, we will use these to convert our text file 
 * into its equivalent Huffman encoding. 
 * 
 * Lastly, we will compare the # 
 * of bits used in the Huffman encoding versus the standard ASCII encoding.  
 * (This always encodes 7-8 bits per character, regardless of that 
 * character’s frequency.)
 *
 * @author sanjnaverma 
 *The text file used will have several lines \n (newline characters) count as 
 *characters, as well as any letters, numbers, spaces, tabs, comma, periods, colons, 
 *etc. Also, there is a difference between upper-case and lower-case letters for 
 *this assignment. 
 *
 *Hence, the frequency of Q is not the same thing as the frequency of q. 
 *Also, the text file must END with a newline character.
 *
 *
 *We can convert integers to characters and vice versa using Java's 
 *built-in ASCII conversion. We can convert an int i into a char c by doing 
 *c = (char)i. Similarly, we can convert a char c into an int i by doing 
 *i = (int)c. This allows us to use the arrays count[] and code[] to keep track of 
 *the count and Huffman encoding for each character. Hence, for some char c, 
 *count[(int)c] tells us how often c occurs, and code[(int)c] tells us the 
 *Huffman encoding for character c. However, please remember that there are only 
 *256 (or even 128) legal characters on most machines 
 *(which is also the size of the ASCII table). 
 *Hence, we can't convert the number 300 into a character.
 */

import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class HuffmanConverter {
	
  // The # of chars in the ASCII table dictates
  // the size of the count[] & code[] arrays.
  public static final int NUMBER_OF_CHARACTERS = 256;
 
  // the contents of our message...
  private String contents;
 
  // the tree created from the msg
  private HuffmanTree huffmanTree;
 
  // tracks how often each character occurs
  private int count[];
 
  // the huffman code for each character
  private String code[];
 
  // stores the # of unique chars in contents
  private int uniqueChars = 0; //(optional)

private char[] charArray;
 
  /** Constructor taking input String to be converted */
  public HuffmanConverter(String input)
  {
    this.contents = input;
    this.count = new int[NUMBER_OF_CHARACTERS];
    this.code = new String[NUMBER_OF_CHARACTERS];
  }
 
  /**
   * Records the frequencies that each character of our
   * message occurs...
   * I.e., we use 'contents' to fill up the count[] list...
   */
  
  public void recordFrequencies() {
	  for(int i = 0; i < contents.length(); i++)
	  count[(int) contents.charAt(i)]++;
}

 
  /**
   * Converts our frequency list into a Huffman Tree. We do this by
   * taking our count[] list of frequencies, and creating a binary
   * heap in a manner similar to how a heap was made in HuffmanTree's
   * fileToHeap method. Then, we print the heap, and make a call to
   * HuffmanTree.heapToTree() method to get our much desired
   * HuffmanTree object, which we store as huffmanTree.
   */
  public void frequenciesToTree() throws UnderflowException{
	  /**
	   * 1) create an array of huff nodes 
	   * 	this will be based on letters and freqs from count
	   * 2) might need 2 counters (maybe 3?)
	   * 3) one counter to iterate through loop (while loop will be best for this,
	   * 	length of counter won't be defined)
	   * 4) convert index counter to a char, then convert it to a Character, 
	   * 	then convert to string
	   * 5) convert count[indexCounter] to a double --> becomes 2nd parameter
	   * 6) create a huff node at that nodeindex (aka the second counter)
	   * 	use parameters create above
	   */
	  ArrayList<HuffmanNode> l = new ArrayList<HuffmanNode>();
	  
	  for (int i = 0; i <count.length; i++) {
		  if (count [i] != 0) {
			  l.add(new HuffmanNode(""+ (char) i, (double) count[i]));
		  }
	  }
	  HuffmanNode[] huffArray = new HuffmanNode[l.size()];
	  for (int j = 0; j<l.size(); j++) {
		  huffArray[j] = l.get(j);
		  System.out.println((j+1)+": ["+huffArray[j]+"]");
	  }
	  
	  BinaryHeap<HuffmanNode> bheap = new BinaryHeap<HuffmanNode>(huffArray);
	  huffmanTree = HuffmanTree.createFromHeap(bheap);
	  
//	  HuffmanNode[] letters = new HuffmanNode[this.uniqueChars +1];
////	  
//	  int j = 0;
//	  for ( int i = 0; i <count.length; i++) {
//		  if(count[i] != 0) {
//			  letters[j] = new HuffmanNode(""+(char)i, Double.parseDouble(""+ count[i]));
//			  j++;
//		  }
//	  }
//	  
//	  BinaryHeap<HuffmanNode> bheap = new BinaryHeap<HuffmanNode>(letters);
//	  System.out.println(bheap);
//	  
//	  this.huffmanTree = huffmanTree.createFromHeap(bheap);
  }
 
  /**
   * Iterates over the huffmanTree to get the code for each letter.
   * The code for letter i gets stored as code[i]... This method
   * behaves similarly to HuffmanTree's printLegend() method...
   * Warning: Don't forget to initialize each code[i] to ""
   * BEFORE calling the recursive version of treeToCode...
   */
  public void treeToCode()  {
	  
	  /**
	   * 1) iterate through code[i] 
	   * 2) initialize it to ""
	   * 3) get code for each letter thru private method (like recursion lesson(ISH))
	   * 
	   */
	  int index = 0;
	  while (index <this.code.length) {
		  this.code[index] = "";
		  index++;
	  }
	  
	  this.treeToCode(this.huffmanTree.root, this.code[0]);
	  
  }
 
  /**
   * A private method to iterate over a HuffmanNode t using s, which
   * contains what we know of the HuffmanCode up to node t. This is
   * called by treeToCode(), and resembles the recursive printLegend
   * method in the HuffmanTree class. Note that when t is a leaf node,
   * t's letter tells us which index i to access in code[], and tells
   * us what to set code[i] to...
   */
  private void treeToCode(HuffmanNode t, String s) {
	  char c = 0; 
	  if(t.letter.length() >1) {
		  this.treeToCode(t.left, s+ "0"); //similar to the recursion in hufftree
		  this.treeToCode(t.right, s+"1");
	  }
	  else {
		  c = t.letter.charAt(0);
		  this.code[(int) c] = s;
	  }
	  
  }
 
  /**
   * Using the message stored in contents, and the huffman conversions
   * stored in code[], we create the Huffman encoding for our message
   * (a String of 0's and 1's), and return it...
   */
  public String encodeMessage() {
	  /**
	   * So the for loop goes through each character of “contents” uptil 
	   * contents.length() and the index to each is (int) contents.charAt(i) s
	   * o the huffman value of each character is code[(int)contents.charAt(i)]
	   */
	 String encoded = "";
	 for (int i = 0; i <this.contents.length(); i++) {
		 encoded += code[(int) contents.charAt(i)];
		 
	 }
	 return encoded;
  }
 
  /**
   * Reads in the contents of the file named filename and returns
   * it as a String. The main method calls this method on args[0]...
   */
  public static String readContents(String filename) throws IOException{
	  //basically use buffered reader
	  
	  /**
	   * ask if we need to use args[0] as mentioned by substitute
	   * will what is returned in readContents be
	   */
	  BufferedReader in = new BufferedReader(new FileReader(filename));
	  String fileString = "";
	  while(true) {
		   String line = in.readLine();
		   if(line == null) {
			   break;
		   }
		   else {
			   fileString += line;
			   fileString += '\n';
		   }
		   System.out.println(line);
	  }
	  return fileString;
	//return filename;
	  
  }
 
  /**
   * Using the encoded String argument, and the huffman codings,
   * re-create the original message from our
   * huffman encoding and return it...
   */
  
  public String decodeMessage(String encodedStr) {
	  //get the node
	 String decoded = "";
	 int i=0;
	 while(i < encodedStr.length()) {
		 HuffmanNode r = this.huffmanTree.root;
		 while (r.letter.length() > 1) {
			 if (encodedStr.charAt(i) == '0') {
				 r = r.left;
				 i++;
			 }
			 else {
				 r = r.right;
				 i++;
			 }
		 }
		 decoded += r.letter;
	 }
	 return decoded; 
  }  

 
  /**
   * Uses args[0] as the filename, and reads in its contents. Then
   * instantiates a HuffmanConverter object, using its methods to
   * obtain our results and print the necessary output. Finally,
   * decode the message and compare it to the input file.<p>
   * NOTE: Example method provided below...
 * @throws IOException 
   */
  public static void main(String[] args) throws IOException
  {
//    //call all your methods from here
//	  BufferedReader in = new BufferedReader(new FileReader("poem.txt"));
//	   String fileString = "";
//	   while(true) {
//		   String line = in.readLine();
//		   if(line == null) {
//			   break;
//		   }
//		   else {
//			   fileString += line;
//			   fileString += '\n';
//		   }
//		   System.out.println(line);
//	   }
	  	String hi = readContents(args[0]);
		 HuffmanConverter converter = new HuffmanConverter(hi);
		 converter.recordFrequencies();
		 converter.frequenciesToTree();
		 converter.treeToCode();
		 String encodedMessage = converter.encodeMessage();
		 System.out.println("\ncharacter encoding:");
		 converter.huffmanTree.printLegend();
		 System.out.println("\n\nHuffman Encoding:");
		 System.out.println(encodedMessage);
		 System.out.println("\nThe decoded message:" + "\n");
		 System.out.println(converter.decodeMessage(encodedMessage));
		 
		 System.out.println("\n\nMessage size in ASCII encoding is "+ converter.contents.length()*8);
		 System.out.println("Message size of Huffman encoding is "+ encodedMessage.length());
	  
  }
}

