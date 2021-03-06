/*
 * Write a function that counts from 1 to 100 and prints the following output for each number: 
 * If the number is divisible by three, the word �Fizz� should be printed, 
 * If the number is divisible by 5 the word �Buzz� should be printed, 
 * If the number is divisible by 3 and 5 the word �Fizz Buzz� should be printed. 
 * If none of the above conditions are met, the number should be printed.
 */
public class FizzBuzz 
{

	/*
	 * Compute the Fizz Buzz Property for integers from 
	 * min to max
	 * 
	 * The Java remainder function "%" is key to the simplicity
	 */
	private static void FizzBuz(int min, int max)
	{
		// Run the loop once from min to max
		for (int i = min; i <= max; i ++)
		{
			
			// Print the current number
			System.out.printf("%d", i);
			
			// If divisible by three add Fizz
			if (i%3 == 0)
			{
				System.out.printf (" Fizz");
			}
			// If divisible by 5 print Buzz
			if (i%5 == 0)
			{
				System.out.printf(" Buzz");
			}
			// Complete the line
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		FizzBuz(1, 100);

	}

}
