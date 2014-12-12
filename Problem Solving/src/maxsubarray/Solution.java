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
	 * @param a
	 *            Given array
	 * @return The maximum contiguous sub-array sum
	 */
	public static long contiguousMaxSubArray(long a[])
	{
		int lo = 0, hi = a.length - 1;
		return contiguousMaxSubArray(lo, hi, a);
	}
	
	private static long contiguousMaxSubArray(int l, int r, long a[])
	{
		/*
		 * Problem does not have optimal substructure
		 */
		
		
		if (l == r)
			return a[l];
		
		int mid = (l + r) / 2;
		long leftSum = contiguousMaxSubArray(l, mid, a);
		long rightSum = contiguousMaxSubArray(mid + 1, r, a);
		long midSum = contiguousMaxSubArrayCrossSum(l, r, a);
		
		return Math.max(Math.max(leftSum, rightSum), midSum);
	}
	
	private static long contiguousMaxSubArrayCrossSum(int l, int r, long[] a)
	{
		int mid = (l + r) / 2;
		
		long sum = 0, leftSum = a[mid];
		for (int i = mid; i >= l; i--) {
			sum += a[i];
			if (sum > leftSum)
				leftSum = sum;
		}
		
		sum = 0;
		long rightSum = a[mid + 1];
		for (int i = mid + 1; i <= r; i++) {
			sum += a[i];
			if (sum > rightSum)
				rightSum = sum;
		}
		
		return leftSum + rightSum;
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