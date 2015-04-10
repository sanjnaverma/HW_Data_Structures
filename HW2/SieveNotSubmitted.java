package hw2;

import java.util.Scanner;
import hw2.*;

public class SieveNotSubmitted{
	public static final int PRIME1 = 2;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the upper bound: ");
		int upperBound = scan.nextInt();
		if (upperBound >= 2){
			primesTo(upperBound);
		}
		else{
			System.out.println("Error: Input must be a number greater than 2");
		}
	}
	
	public static boolean isPrime(int n){
		int count = 0;
		boolean verdict = true;
		for( int i = 1; i <= Math.pow(n, 0.5); i++)
		{
			if (n == i){
				continue;
			}
			else if(n % i == 0)
			{
				verdict = false;
			}
			else{
				verdict = true;
			}
		}
		return verdict;
		
	}

	
	public static void primesTo(int n){
		UnboundedQueueInterface<Integer> primes = new ArrayUnbndQueue<Integer>();
		UnboundedQueueInterface<Integer> temp = new ArrayUnbndQueue<Integer>();
		
		BoundedQueueInterface<Integer> numbers = new ArrayBndQueue<Integer>();
		for (int element = 2; element <= n; element++){
			numbers.enqueue(element);
			System.out.println("Read"+element);
			temp.enqueue(element);
		}
		
		
		int p = temp.dequeue();
		while (p <= (int)Math.pow(n, 0.5)){
			

			//primes.enqueue(p);
			while (!numbers.isEmpty()){
				System.out.println("Lets check with p: "+p);
				int div = numbers.dequeue();
				if (div == p){
					continue;
				}
				else if (div%p == 0){
					System.out.println(div+" is not prime because of divisibility by "+p);
				}
				else if (div%p != 0){
					System.out.println(div+" is not divisible by "+p);
					primes.enqueue(div);
				}
				//p = temp.dequeue();
				div = numbers.dequeue();
			}
			//p++;
			//p = numbers.dequeue();
			
		}
		//primes = temp; 
		System.out.println("The primes are: ");
		while (!primes.isEmpty()){
			int myPrime = primes.dequeue();
			System.out.println(myPrime);//primes.dequeue());
		}
	}
	//Instantiate a queue, call this "numbers" and fill it with all integers from 2 to n
	//Instantiate a second queue, call this "primes"
	//Let p = First value of queue of numbers
	//While (p <= sqrt(n))
	//Push p into "primes"
	//Go through "numbers" and eliminate numbers divisible by p (you might want to use an additional queue for this)
	//Add allt he elements of "number" to "primes". These should all be prime numbers.
	//These are the requirements:

}
