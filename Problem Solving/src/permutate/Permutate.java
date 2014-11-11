package permutate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Provides functionality to permutate a given string. The string should have
 * unique characters else duplicate permutations are thrown up.
 * 
 * @author kempa
 *
 */
public class Permutate
{

	private Set<String> permutatedStrings = new HashSet<>();

	/**
	 * Prints all possible permutations of the string
	 * 
	 * @param s
	 *            The string to be permutated
	 * @param pos
	 *            The position from where the permutation must happen
	 */
	public void permutate(String s, int pos)
	{
		if (pos == s.length() - 1)
		{
			if (!permutatedStrings.contains(s))
			{
				permutatedStrings.add(s);
				System.out.println(s);
			}
			return;
		}

		for (int i = pos; i < s.length(); i++)
		{
			String permutatedString = swapChar(s, pos, i);
			permutate(permutatedString, pos + 1);
		}
	}

	/**
	 * Swap the characters at the given positions in the string
	 * 
	 * @param s
	 *            Given string
	 * @param i
	 *            First position
	 * @param j
	 *            Second position
	 * @return A new string with the required characters swapped
	 */
	String swapChar(String s, int i, int j)
	{
		if (i >= s.length() || j >= s.length())
			throw new RuntimeException("Invalid swap positions : " + i
					+ " and " + j);

		StringBuilder swappedString = new StringBuilder(s);
		swappedString.replace(i, i + 1, new Character(s.charAt(j)).toString());
		swappedString.replace(j, j + 1, new Character(s.charAt(i)).toString());

		return swappedString.toString();
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("word?");
		String s = br.readLine();
		Permutate p = new Permutate();
		p.permutate(s, 0);

	}
}
