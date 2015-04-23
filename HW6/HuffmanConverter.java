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
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


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
	  /**
	   * 1) Convert contents to characters
	   * 2) Store characters in array
	   * 3) loop through array
	   * 4) increment the count at index of integer value of that specific character
	   * 5) count number of unique characters 
	   * 6) update this.uniqueChars 
	   */
	  char[] contentsChar = this.contents.toCharArray();
	  for (int i = 0; i <contentsChar.length; i++) {
		  //System.out.println(contentsChar[i]);
		  char c = contentsChar[i];
		  if((int)c < this.count.length) {
			  this.count[(int)c]++;
			  //System.out.println("Count:"+count.length);//should stay at 256
			  System.out.println("c: "+(c+""));
		  }
	  }
	  
	  for (int j= 0; j< count.length; j++) {
		  if(count[j] != 0) {
			  this.uniqueChars++;
		  }
	  }
	  System.out.println("unique chars: "+ uniqueChars); 
  }
 
  /**
   * Converts our frequency list into a Huffman Tree. We do this by
   * taking our count[] list of frequencies, and creating a binary
   * heap in a manner similar to how a heap was made in HuffmanTree's
   * fileToHeap method. Then, we print the heap, and make a call to
   * HuffmanTree.heapToTree() method to get our much desired
   * HuffmanTree object, which we store as huffmanTree.
   */
  public void frequenciesToTree() {
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
	  HuffmanNode[] letters = new HuffmanNode[this.uniqueChars];
	  int i = 0;
	  int nodeIndex = 0;
	  while (i <count.length) {
		  if(this.count[i] != 0) {
			 // char ch = (char) i;
			 // Character o = (Character) ch;
			  Character o = (Character)((char)i);
			  
			  String l = o.toString(); //param 1
			  //double lc = (double) count[i];
			  //Double freq = (double) lc;
			  Double freq = (double)((double)count[i]); //param2
			  letters[nodeIndex] = new HuffmanNode(l, freq);
			  
			  
		  } i++;
	  }
	  
	  
	  BinaryHeap heap = new BinaryHeap (letters);
	  this.huffmanTree = huffmanTree.createFromHeap(heap);
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
	  
	  String encoded = ""; //final message. will be returned
	  String[] eMessage = new String[this.contents.length()];
	  int i = 0;
	  while (i <this.contents.length()) {
		  int m = (int) this.contents.charAt(i);
		  eMessage[i] = code[m];
		  encoded = encoded + eMessage[i];
		  i++;
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
	  HuffmanNode r = this.huffmanTree.root; //get the root
	  String output = "";
	  
	  
	  for (int i = 0; i < encodedStr.length(); i++) {
		  if(encodedStr.charAt(i) == '0') {
			  if(r.left != null ) {
				  r = r.left;
			  }
		  }
		  else { //encodedStr.charAt(i) == '1'
			  if (r.right != null) {
				  r = r.right;
			  }
		  }
		  output+= r;
	  }
	  
	  return output;
  }
 
  /**
   * Uses args[0] as the filename, and reads in its contents. Then
   * instantiates a HuffmanConverter object, using its methods to
   * obtain our results and print the necessary output. Finally,
   * decode the message and compare it to the input file.<p>
   * NOTE: Example method provided below...
 * @throws IOException 
   */
  public static void main(String args[]) throws IOException
  {
    //call all your methods from here
	  BufferedReader in = new BufferedReader(new FileReader("huff.txt"));
	   String fileString = "";
	   while(true) {
		   String line = in.readLine();
		   if(line == null) {
			   break;
		   }
		   else {
			   fileString += line;
		   }
		   System.out.println(line);
	   }
	  
		 HuffmanConverter converter = new HuffmanConverter(fileString);
		 converter.recordFrequencies();
		 converter.frequenciesToTree();
		 converter.treeToCode();
		 String encodedMessage = converter.encodeMessage();
		 System.out.print("\nHuffman encoding:" + "\n");
		 converter.huffmanTree.printLegend();
		 System.out.println("\n\nHuffman Encoding:");
		 System.out.println(encodedMessage);
		 System.out.println("\nThe decoded message:" + "\n");
		 System.out.println(converter.decodeMessage(encodedMessage));
	  
  }
}

