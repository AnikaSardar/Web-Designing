import java.util.Scanner;

// *******************************************************************
//   DigitPlay.java
// 
//   Finds the number of digits in a positive integer.
// *******************************************************************

public class DigitPlay {

	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);

		int num; // a number

		System.out.println();
		//String has been changed to enter an id number instead of any positive number
		System.out.print("Please enter an identification number (positive integer): "); 

		if (conIn.hasNextInt())
			num = conIn.nextInt();
		else {
			System.out.println("Error: you must enter an integer.");
			System.out.println("Terminating program.");
			return;
		}
		System.out.println();

		if (num <= 0)
			System.out.println(num + " isn't positive -- start over!!");
		else {
			// Call numDigits to find the number of digits in the number
			// Print the number returned from numDigits
			System.out.println("\nThe number " + num + " contains " + +numDigits(num) + " digits.");

			// Call sumDigits to find the sum of digits in the number
			System.out.println("\nThe number " + num + " has a sum of " + sumDigits(num));

			// Check if the sum of the digits is divisible by 7 and print the result
			if (sumDigits(num) % 7 == 0) {
				System.out.println("\nThe sum of " + num + " is divisible by 7");
			} 
			else {
				System.out.println("\nError: The sum of " + num + " is not divisible by 7");
			}

			System.out.println();
		}

	}

	// -----------------------------------------------------------
	// Recursively counts the digits in a positive integer
	// -----------------------------------------------------------

	// num is a positive integer
	// Returns the number of digits in num
	public static int numDigits(int num) {
		if (num < 10)
			return (1); // a number < 10 has only one digit
		else
			return (1 + numDigits(num / 10));
	}

	// -----------------------------------------------------------
	// Recursively sums the digits in a positive integer
	// -----------------------------------------------------------

	// num is a positive integer
	// Returns the sum of digits in num
	public static int sumDigits(int num) {
		int sum = 0;

		if (num < 10) {
			return (num);
		} 
		else {
			int remainder = num % 10; // gets the remainder
			sum = sum + remainder;
			return (sum + sumDigits(num / 10));

		}

	}
}
