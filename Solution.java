import java.util.Scanner;

/*
 * Experimenting with the Sieve of Eratosthenes
 */
public class Solution {

	/*
	 * Display the array of prime numbers
	 */
	static void displayPrimesArray(int[] ar) {
		System.out.println("primes: ");
		
		for (int i = 1; i <= ar.length; i++) {
			
			// **** ****
			System.out.format("%4d ", ar[i - 1]);
			
			// **** ****
			if (i % 10 == 0)
				System.out.println();
		}
		System.out.println();
	}

	
	/*
	 * Display working array disregarding entries with value 0.
	 * For the looks, entries with value 0 display as a blank string.
	 */
	static void displayIntArray(int[] ar) {
		System.out.println("ar: ");
		for (int i = 1; i < ar.length; i++) {
			
			// **** ****
			if (ar[i] != 0)
				System.out.format("%4d ", ar[i]);
			else
				System.out.print("     ");
			
			// **** ****
			if (i % 10 == 0)
				System.out.println();
		}
		System.out.println();
	}
	
	
	/*
	 * Generate list of prime numbers up to the specified one
	 */
	static int[] primeNumbers(int n) {
		
		// **** declare array of integers ****
		int[] nums = new int[n + 1];
		
		// **** generate list of integers ****
		for (int i = 0; i <= n; i++)
			nums[i] = i;
		
		// **** disregard nums[1] (not a prime) ****
		nums[1] = 0;
		
		// **** display the initial array ****
		displayIntArray(nums);

		// ***** used to set the upper limit for the loop ****
//		int srn = n;
		int srn = (int)Math.sqrt(n);
		
		// ???? ????
		System.out.println("srn: " + srn);
				
		// **** loop marking non-prime numbers ****
		for (int i = 2; i <= srn; i++) {
			
			// **** find the first number greater than i in the list that is non-zero ****
			if (nums[i] == 0)
				continue;
			
			// ???? ????
			System.out.println("i: " + i);
			
			// ***** flag multiples of this prime as non-prime ****
			for (int j = i * i; j <= n; j += i) {
				
				// ???? ????
				System.out.println("j: " + j);
				
				// **** flag as non-prime ****
				nums[j] = 0;	
			}

			// **** display the array ****
			displayIntArray(nums);
		}
		
		// **** count primes ****
		int count = 0;
		for (int i = 2; i <= n; i++)
			if (nums[i] != 0)
				count++;
		
		// ???? ????
		System.out.println("count: " + count);
		
		// **** instantiate array of primes ****
		int[] primes = new int[count];
		
		// **** populate array of primes ****
		int j = 0;
		for (int i = 2; i <= n; i++) {
			if (nums[i] != 0)
				primes[j++] = nums[i];
		}
			
		// **** return array of primes ****
		return primes;
	}
	
	
	/*
	 * Testing scaffold.
	 */
	public static void main(String[] args) {

		// **** open a scanner ****
		Scanner sc = new Scanner(System.in);
		
		// **** prompt for the specified number ****
		System.out.print("n: ");
		int n = sc.nextInt();
		
		// **** generate the list of prime numbers up to the specified number ****
		int[] primes = primeNumbers(n);
		
		// **** display the prime numbers ****
		displayPrimesArray(primes);
		
		// **** close the scanner ****
		sc.close();
	}

}
