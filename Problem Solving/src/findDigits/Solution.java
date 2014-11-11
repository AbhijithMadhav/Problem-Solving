package findDigits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/find-digits
 * @author kempa
 *
 */
public class Solution
{
	
	private static int findDigits(long num)
	{
		int n = 0;
		long tmp = num;
		for (tmp = num; tmp != 0; tmp = tmp / 10)
		{
			int digit = (int) (tmp % 10);
			if (digit != 0 && num % digit == 0)
				n++;
		}
		return n;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++)
		{
			System.out.println(findDigits(Long.parseLong(br.readLine())));
		}
	}

}
