package serviceLane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/service-lane
 * @author kempa
 *
 */
public class Solution
{
	private int width[];

	public Solution(int[] width)
	{
		super();
		this.width = width;
	}

	private int getVehicleType(int i, int j)
	{
		int vehicle_width = 3;
		for (int segment = i; segment <= j; segment++)
		{
			if (width[segment] < vehicle_width)
				vehicle_width = width[segment];
			if (vehicle_width == 1)
				break;
		}
		return vehicle_width;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int width[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; st.hasMoreTokens(); i++)
			width[i] = Integer.parseInt(st.nextToken());

		Solution serviceLane = new Solution(width);
		for (int i = 0; i < t; i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(serviceLane.getVehicleType(start, end));
		}
	}
}
