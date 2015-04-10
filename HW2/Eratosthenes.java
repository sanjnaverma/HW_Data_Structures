package hw2;
//Queue Programming Assignment
//
//This assignment will help you further understand how and when to use queues. 
//You will write a program that computes all the prime numbers up to some number n. 
//For this purpose, you will use an algorithm developed by Eratosthenes (276 BC), a Greek mathematician, poet and astronomer. 
//This algorithm is known as the Sieve of Eratosthenes.
//
//The following pseudocode describes the algorithm:
//
//Instantiate a queue, call this "numbers" and fill it with all integers from 2 to n
//Instantiate a second queue, call this "primes"
//Let p = First value of queue of numbers
//While (p <= sqrt(n))
//Push p into "primes"
//Go through "numbers" and eliminate numbers divisible by p (you might want to use an additional queue for this)
//Add allt he elements of "number" to "primes". These should all be prime numbers.
//These are the requirements:
//
//You should use the Queue implementation of the book.
//You should write a class called Sieve. You should be able to construct a Sieve object by calling: Sieve newSieve = new Sieve();
//The sieve class should have a "void primesTo(int n)" method. It should print all the primes from 2 to n to System.out. 
//please format the result so that the primes are separated by a space or a comma.
//You should read in the input from the user via stdin (scanner)
//Feel free to write other helper methods.
//Please check that if the user tries to call primesTo(int n) with n < 2, a proper Exception/Error message is thrown.
//Here are some sample runs of the program (user input in italics):
//
//Please enter upper bound 
//20
//Primes up to 20 are: 2, 3, 5, 7, 11, 13, 17, 19
//
//Please enter upper bound 
//2
//Primes up to 2 are: 2
//
//Please enter upper bound 
//0
//Error: Input must be a number greater than 2.

import java.util.Scanner;
public class Eratosthenes implements BoundedQueueInterface{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the upper bound: ");
		int upperBound = scan.nextInt();
		
		
	}

	@Override
	public Object dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enqueue(Object element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
