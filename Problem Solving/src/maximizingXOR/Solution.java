package maximizingXOR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/maximizing-xor
 * @author kempa
 *
 */
public class Solution
{

	static int maxXOR(int l, int r)
	{
		int max = l ^ r;
		for(int i = l; i <= r ; i++)
			for (int j = i; j <= r; j++)
			{
				if ((i ^ j) > max)
					max = i ^j;
			}
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		int r = Integer.parseInt(br.readLine());
		System.out.println(maxXOR(l, r));
	}
}
