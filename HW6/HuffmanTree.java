
// - add a constructor to init the Tree from a HuffmanNode
// - the main method will go here, as well as code to take
//   a command-line argument for the input file name

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class HuffmanTree{
	
   HuffmanNode root;
   
   /**
    * public HuffmanTree(HuffmanNode huff)
   	sets this.root to huff
   Before calling this constructor, we make a BinaryHeap of HuffmanNodes 
   --where each node has its left & right pointers set appropriately via the constructor in 
   2. above (HuffmanNode (left, right)
   . Once the final HuffmanNode (containing all the others) 
   is removed from the heap, we make that into a HuffmanTree object by calling this constructor.
    */
   public HuffmanTree(HuffmanNode huff) {
	   this.root = huff;
   }
 
   /**
    * public void printLegend()is located in the HuffmanTree class, and
    *  it calls printLegend(root, ""), which calls private void printLegend(HuffmanNode t, String s) 
    *  which is a recursive method that works as follows:
		If (t.letter.length() > 1) i.e., t contains multiple characters, 
		then t is NOT a leaf node, 
		so we recursively call printLegend() on it's left child using 
		string s + "0", and recurse on t's right child using string s + "1"
		If t.letter is a single character, then t is a leaf node, and we print out (t.letter+"="+s);
    */
   
   public void printLegend() {
	   printLegend(root, "");
   }
   
   private void printLegend(HuffmanNode t, String s) {
	   if (t.letter.length() > 1) {// t contains multiple characters
		   //t is not a leaf //go to left child
		   //System.out.println(t);
		   printLegend(t.left, s+"0");
		   printLegend(t.right, s+"1");
	   }
	   
	   else {//If t.letter is a single character, then t is a leaf node, and we print out (t.letter+"="+s);
		   System.out.println(t.letter+" = "+s); 
	   }
   }
   
   /**
    * public static BinaryHeap fileToHeap(String filename) 
    * is located in the HuffmanTree class and takes a String for the file name 
    * containing our input (letter & frequency data). 
    * The letters and frequencies are all in the first line of the file, with spaces as separators. 
    * (You may assume each separator is a single space)
    */
   public static BinaryHeap fileToHeap(String filename) throws IOException{
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
		   //System.out.println(line);
	   }
	   
	   
	   /**
	    * We create a single HuffmanNode for each letter and its frequency, 
	    * and insert each of these into a new BinaryHeap. 
	    * (Note: We don't start the Huffman algorithm just yet. 
	    * We merely call the Binary Heap's constructor that takes an array of Comparables. 
	    * Don't forget that BinaryHeaps ignore the zeroth entry!!!) .
	    */
	   
		String[] stringArray = fileString.split(" ");
		//System.out.println("length:"+stringArray.length);

		HuffmanNode[] huffArray = new HuffmanNode[stringArray.length/2];

		int z = 0;

		for (int x = 0; x < stringArray.length; x += 2) {
			//System.out.println("index: "+x);
			Double secondArg = Double.valueOf(stringArray[x+1]);
			String firstArg = stringArray[x];
			//System.out.println("1st arg: "+ firstArg+"\n2nd arg: "+secondArg);
			HuffmanNode newNode = new HuffmanNode(firstArg, secondArg);
			huffArray[z] = newNode;
			//System.out.println("NODE: "+newNode);
			z++;
		}
		//@SuppressWarnings("unchecked")
		//BinaryHeap heap = new BinaryHeap(huffArray);
		BinaryHeap<HuffmanNode> heap = new BinaryHeap<HuffmanNode>(huffArray);
		return heap;
   }


/**
    * Create from heap is located in the HuffmanTree class. 
    * We run the Huffman algorithm here. When we have only one element left in the heap, 
    * we remove it, and create a new HuffmanTree object with root set to our removed object...
    * @param b
    * @return
    */
   public static HuffmanTree createFromHeap(BinaryHeap<HuffmanNode> b) {
	   while (b.getSize() != 1){
		   HuffmanNode r = b.deleteMin();
		   HuffmanNode l = b.deleteMin();
		   HuffmanNode nextNode = new HuffmanNode (l, r);
		   b.insert(nextNode);
	   }
	   
	   HuffmanTree huffTree = new HuffmanTree(b.deleteMin());
	   return huffTree;
	   
   }

   /**
    * calls fileToHeap() on args[0], 
    * (which means we specify the name of the file to read at the command-line)
    *  and returns a BinaryHeap (bheap, for example). We then call bheap.printHeap() 
    *  on the heap. Next, we call createFromHeap(bheap) on the heap to run our Huffman 
    *  algorithm which returns a HuffmanTree, called, here, htree.
    *   Finally, we call htree.printLegend() on this HuffmanTree object to print the 
    *   binary encodings for each of the letters in our input file...
    * @param args
    * @throws IOException 
    */
   
   public static void main(String[] args) throws IOException {
		 BinaryHeap testHeap = fileToHeap("huff.txt");
		 HuffmanTree hTree = createFromHeap(testHeap);
		 hTree.printLegend();
   }
}
 
