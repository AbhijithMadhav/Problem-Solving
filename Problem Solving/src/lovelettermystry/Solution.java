package lovelettermystry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 * @author kempa
 *
 */
public class Solution
{
	static int nOps(char[] string)
	{
		int n = 0;
		for (int i = 0, j = string.length - 1; i < j; i++, j--)
		{
			if (string[i] == string[j])
				continue;
			if (string[i] > string[j])
				while(string[i] != string [j])
				{
					string[i]--;
					n++;
				}
			else
				while(string[j] != string [i])
				{
					string[j]--;
					n++;
				}
		}
		return n;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++)
		{
			String s = br.readLine();
			System.out.println(nOps(s.toCharArray()));
			
		}
	}
}
