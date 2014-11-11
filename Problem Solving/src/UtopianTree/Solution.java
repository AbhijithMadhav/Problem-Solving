package UtopianTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{

	static int height(int n)
	{
		int height = 1;
		boolean spring = true;
		for (int i = 0; i < n; i++)
		{
			if (spring)
			{
				height = 2 * height;
				spring = false;
			}
			else
			{
				height++;
				spring = true;
			}
		}
		return height;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			System.out.println(height(n));
		}

	}

}
