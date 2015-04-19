readMe.txt

Huffman Code Assignmnet #5 
Sanjna Verma

Supplemental class files:
BinaryHeap.java
HuffmanConverter.java
HuffmanNode.java


PROBLEMS: 
Huffman code reads the “a” has “nullA” and runs a nullpointerexception. However, other files run the same results. If i solve it before hand, I will send another submission and take one of my 5 days. 

Thanks, 
Sanjna

HuffmanTree-------
	/**
    * public static BinaryHeap fileToHeap(String filename) 
    * is located in the HuffmanTree class and takes a String for the file name 
    * containing our input (letter & frequency data). 
    * The letters and frequencies are all in the first line of the file, with spaces as separators. 
    * (You may assume each separator is a single space)
    */

    /**
    * We create a single HuffmanNode for each letter and its frequency, 
    * and insert each of these into a new BinaryHeap. 
    * (Note: We don't start the Huffman algorithm just yet. 
    * We merely call the Binary Heap's constructor that takes an array of Comparables. 
    * Don't forget that BinaryHeaps ignore the zeroth entry!!!) .
    */

    
The heap's role is basically to help you organize the HuffmanNodes in ascending order. By building a heap, you are guaranteeing that the HuffmanNode with least frequency will be at the top. This way, when you use deleteMin() or getMin() you will know that you are extracting the node with least frequency.

The fileToHeap() method will create the heap by creating a new HeapNode and inserting it into the binary heap.

The createFromHeap() method will use the heap (as I described above) to create the Huffman Tree.