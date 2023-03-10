
// ******************************************************************
//   TestFib.java
//
//   A simple driver that uses the Fib class to compute the
//   nth element of the Fibonacci sequence.
// ******************************************************************
import java.util.*;

public class TestFib {
	public static void main(String[] args) {
		int n, fib;

		Scanner conIn = new Scanner(System.in);

		System.out.println();
		System.out.print("Please enter a positive integer: ");

		if (conIn.hasNextInt())
			n = conIn.nextInt();
		else {
			System.out.println("Error: you must enter an integer.");
			System.out.println("Terminating program.");
			return;
		}
		System.out.println();
		
		
	
		
		System.out.println("The first " + n + " Fibonacci numbers using iterative formula are as follows:  \n");

		long startTime_for_iterative = System.nanoTime();
		//Loops through the iterative method to get the first n numbers
		//For the assignment requirement, n = 15 
		for (int i = 0; i < n; i++) {

			System.out.print(Fib.fib2(i) + ", ");
		}
		
		long elapsedTime_for_iterative = System.nanoTime() - startTime_for_iterative;
		
		System.out.println(" \n\n\n" + "The elapsed time for the iterative version is " + elapsedTime_for_iterative + " nanoseconds");
		
		System.out.println("\n----------------------------------------------------------------\n");
		
		
		System.out.println("The first " + n + " Fibonacci numbers using recursive formula are as follows: \n");
		
		long startTime_for_recursive = System.nanoTime();
		//Loops through the recursive method to get the first n numbers
		//For the assignment requirement, n = 15 
		for (int i = 0; i < n; i++) {

			System.out.print(Fib.fib1(i) + ", ");
		}
		
		long elapsedTime_for_recursive = System.nanoTime() - startTime_for_recursive;

		System.out.println(" \n\n\n" + "The elapsed time for the recursive version is " + elapsedTime_for_recursive + " nanoseconds");

		System.out.println("\n----------------------------------------------------------------\n");

		
		
		System.out.println("The difference between the two elapsed time (recursive version minus iterative version) " + "is " + (elapsedTime_for_recursive - elapsedTime_for_iterative) + " nanoseconds\n\n\n");
		

		fib = Fib.fib2(n);
		System.out.println("Using iterative formula: Fib(" + n + ") is " + fib);

		fib = Fib.fib1(n);
		System.out.println("Using recursive formula: Fib(" + n + ") is " + fib);
		
	}

}
