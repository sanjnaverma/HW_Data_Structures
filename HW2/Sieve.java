package hw2;

import java.util.Scanner;

import hw2.*;

public class Sieve{
	public static void primesTo(int n){
ArrayBndQueue<Integer> numbers = new ArrayBndQueue<Integer>();
		
		
		for (int element = 2; element <= n; element++){
			numbers.enqueue(element);
			//System.out.println("Read: "+element);
		}
		
		//Instantiate a second queue, call this "primes"
		ArrayBndQueue<Integer> primes = new ArrayBndQueue<Integer>();
		
		//set a number = sqrt(n)
		int squareRoot = (int) Math.pow(n, 0.5);
		
		//set p = to first number in numbers
		int p = numbers.dequeue();
		while (p <= squareRoot) {
				ArrayBndQueue<Integer> temp = new ArrayBndQueue<Integer>();
				primes.enqueue(p);
				
				while(!numbers.isEmpty()){
					//charlie is the variable to compare divisibility
					int charlie = numbers.dequeue();
					if (charlie%p != 0){
						temp.enqueue(charlie);
					}
					
				}
				
				numbers = temp;
				primes.enqueue(numbers.dequeue());
				p = numbers.dequeue();
				
				
		}
		while (!numbers.isEmpty()){
			primes.enqueue(numbers.dequeue());
		}
		
		System.out.println("\nPrimes:");
		while (!primes.isEmpty()){
			System.out.println(primes.dequeue());
		}
		
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the upper bound: ");
		int userInput = scan.nextInt();
		
		primesTo(userInput);
		
	}

}
