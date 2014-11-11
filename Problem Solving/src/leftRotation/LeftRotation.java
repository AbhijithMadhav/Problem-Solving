package leftRotation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class LeftRotation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("N = ?");
		int N = Integer.parseInt(br.readLine());
		int a[] = new int[N];
		System.out.println("Left rotated sorted array with numbers seperated by spaces");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
		{
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println("Rotated " + findNRotate(a) + " times");
	}
	
	public static int findNRotate(int a[])
	{
		int n = 0;
		for (int i = a.length - 1; i > 0 && a[0] > a[i]; i--, n++)
		;
		return n;
	}
}
