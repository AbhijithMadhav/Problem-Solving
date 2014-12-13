package maxsubarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
	/**
	 * Calculate the maximum contiguous sub-array sum of the given array
	 * 
	 * @param a Given array
	 * 
	 * @return The maximum contiguous sub-array sum
	 */	
	private static long contiguousMaxSubArray(long a[])
	{
		/*
		 * Kadane's algorithm
		 * One iteration per element of the array
		 * At each iteration the max contiguous sum ending at that particular element(maxEndingHere) is calculated
		 * The max of these(maxSoFar) is kept track of
		 */
		
		long maxEndingHere = a[0];
		long maxSoFar = a[0];
		
		for (int i = 1; i < a.length; i++)
		{
			if (maxEndingHere + a[i] > a[i])
				maxEndingHere += a[i];
			else
				maxEndingHere = a[i];
			
			if (maxEndingHere > maxSoFar)
				maxSoFar = maxEndingHere;
		}
		return maxSoFar;
	}
	
	public static long nonContiguousMaxSubArray(long a[])
	{
		long sum = 0;
		boolean nonNegative = false; // Are there any non-negative numbers?
		long maxNegative = Long.MIN_VALUE;

		// Don't include negative numbers to the sum
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] >= 0)
			{
				nonNegative = true;
				sum += a[i];
			}
			else if (maxNegative < a[i])
				maxNegative = a[i]; // Biggest negative number
		}

		// If there are negative numbers return the sum else return the largest
		// negative number
		if (nonNegative)
			return sum;
		else
			return maxNegative;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			long a[] = new long[n];
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			for (int k = 0; tokenizer.hasMoreTokens(); k++) {
				a[k] = Integer.parseInt(tokenizer.nextToken());
			}
			System.out.println(contiguousMaxSubArray(a) + " " + nonContiguousMaxSubArray(a));
		}
	}
}