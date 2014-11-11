package redJohnBack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/red-john-is-back
 * @author kempa
 *
 */
public class Solution
{
	
	public static int wallRecursive(int nCols)
	{
		if (nCols < 1)
			return 0;
		if (nCols < 4)
			return 1;
		if (nCols == 4)
			return 2;
		return wall(nCols - 1) + wall(nCols - 4);
	}
	
	public static int wall(int nCols)
	{
		
		if (nCols <= 0)
			return 0;
		if (nCols < 4)
			return 1;
		
		int col[] = new int[nCols];
		col[0] = 1;
		col[1] = 1;
		col[2] = 1;
		col[3] = col[3 - 1] + 1;
		for (int i = 4; i < nCols; i++)
			col[i] = col[i - 1] + col[i - 4];
		return col[nCols - 1];
	}

	public static int prime(int n)
	{
		boolean sieve[] = new boolean[n + 1];

		sieve[0] = true;
		sieve[1] = true;

		int nPrime = 0;
		for (int prime = 2; prime <= n;)
		{
			nPrime++;

			// Mark the number divisible by this prime
			for (int i = prime; i <= n; i += prime)
				sieve[i] = true;

			// Find the next prime within n
			prime = n + 1;
			for (int i = 0; i <= n; i++)
				if (sieve[i] == false)
				{
					prime = i;
					break;
				}
		}
		return nPrime;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int nCols = Integer.parseInt(br.readLine());
			System.out.print(prime(wall(nCols)) + " : ");
			//System.out.print(wallRecursive(nCols));
			//System.out.println();
		}
			
	}

}
