readMe.txt

Huffman Code Assignmnet #5 
Sanjna Verma

Supplemental class files:
BinaryHeap.java
HuffmanConverter.java
HuffmanNode.java

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

    