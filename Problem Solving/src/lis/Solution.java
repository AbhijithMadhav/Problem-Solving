package lis;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent
 * 
 * @author kempa
 */
public class Solution
{

	// O(n^2) solution
	public static int LIS(int[] a)
	{
		// DP[i] contains the length of the longest increasing subsequence
		// ending with a[i]
		int[] DP = new int[a.length];

		DP[0] = 1;
		int maxLength = DP[0];
		for (int i = 1; i < a.length; i++)
		{
			
			// Now find the LIS whose last element is less than a[i]
			int maxLengthUntilNow = 0;
			for (int j = 0; j < i; j++)
			{
				if (a[j] >= a[i])
					continue;
				if (DP[j] > maxLengthUntilNow)
					maxLengthUntilNow = DP[j];
			}
			
			DP[i] = maxLengthUntilNow + 1;
			if (DP[i] > maxLength)
				maxLength = DP[i];
		}

		return maxLength;
	}

	// O(n log(n))
	public static int efficientLIS(int[] a)
	{
		// DP[i] contains the smallest integer which is the last element of an
		// LIS of length i + 1
		ArrayList<Integer> DP = new ArrayList<Integer>();
		DP.add(a[0]);

		// The solution is got by determining the smallest integer that is the
		// last element of LIS's of all possible lengths

		// Construct DP by iterating through each subproblem, a[0..i].
		for (int i = 1; i < a.length; i++)
		{	
			int index = binarySearch(DP, 0, DP.size() - 1, a[i]);

			if (a[i] == DP.get(index))
				continue;
			else if (a[i] < DP.get(index))
				DP.set(index, a[i]);
			else
			{
				if (index == DP.size() - 1)
					DP.add(a[i]);
				else
					DP.set(index + 1, a[i]);
			}
		}
		
		// The length of the LIS is the length of DP as DP has one entry per
		// each possible length of IS's
		return DP.size();
	}

	public static int binarySearch(ArrayList<Integer> DP, int lo, int hi, int item)
	{
		if (lo == hi)
			return lo;

		int mid = (lo + hi) / 2;
		if (DP.get(mid) == item)
			return mid;
		if (DP.get(mid) < item)
			return binarySearch(DP, mid + 1, hi, item);
		else
			return binarySearch(DP, lo, mid, item);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++)
			a[i] = Integer.parseInt(br.readLine());
		System.out.println(efficientLIS(a));
	}
}
