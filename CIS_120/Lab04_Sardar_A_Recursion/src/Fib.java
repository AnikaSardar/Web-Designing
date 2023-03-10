
// ******************************************************************
//   Fib.java
//
//   A utility class that provide methods to compute elements of the
//   Fibonacci sequence.
// ******************************************************************

public class Fib {

	// --------------------------------------------------------------
	// Recursively computes fib(n)
	// --------------------------------------------------------------

	// n is a positive integer, i.e, n > 1
	//Returns the n-th number in the sequence 
	
	public static int fib1(int n) {
		// Fill in code -- this should look very much like the
		// mathematical specification
		
		
	//This statement was added to see what call was being computed. It has been
	//commented out because for fib1(15), the console can't visibly show all the recursive calls
			//System.out.println("fib1 (" + n + ") is now being computed\n"); 

		if (n == 0) {
			return 0;
		} 
		else if (n == 1) {
			return 1;
		} 
		else {
			return (fib1(n - 1) + fib1(n - 2));
		}

	}

	// --------------------------------------------------------------
	// Iteratively computes fib(n)
	// --------------------------------------------------------------
	// n is a positive integer, i.e, n > 1
	//Returns the n-th number in the sequence 
	
	public static int fib2(int n) {

		int[] array_of_integers = new int[n + 1];

		for (int i = 0; i <= n; i++) {

			if (i == 0) {
				array_of_integers[i] = 0;
			}
			else if (i == 1) {
				array_of_integers[i] = 1;
			} 
			else {
				array_of_integers[i] = array_of_integers[i - 1] + array_of_integers[i - 2];
			}

		}

		return array_of_integers[n];

	}

}