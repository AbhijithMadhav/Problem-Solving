package stringChain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algo.graphs.dfs.directed.StronglyConnectedComponents;
import ds.graphs.InvalidEdgeException;
import ds.graphs.ParallelEdgeExistsException;
import ds.graphs.SelfLoopExistsException;
import ds.graphs.SymbolDigraph;

/**
 * http://www.geeksforgeeks.org/informatica-internship-interview-experience/
 * Check whether an array of strings can form a cycle, i.e., last element of one node can occur anywhere in the first of other
 * @author kempa
 *
 */
public class StringChain
{

	private SymbolDigraph<String> digraph;

	public StringChain(String[] words)
	{

		digraph = new SymbolDigraph<>(words.length);
		for (int i = 0; i < words.length; i++)
		{
			String from = words[i];
			for (int j = 0; j < words.length; j++)
			{
				String to = words[j];
				if (to.equals(from))
					continue;
				if (from.charAt(from.length() - 1) == to.charAt(0))
				{
					try
					{
						digraph.addEdge(from, to);
					} catch (InvalidEdgeException | SelfLoopExistsException
							| ParallelEdgeExistsException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public boolean canChain()
	{
		StronglyConnectedComponents scc = new StronglyConnectedComponents(
				digraph.G());
		if (digraph.G().V() > 1 && scc.count() == 1)
			return true;
		return false;
	}

	public String[] chain()
	{
		return null;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("words?");
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		String[] words = new String[tokenizer.countTokens()];
		for (int i = 0; tokenizer.hasMoreTokens(); i++)
			words[i] = tokenizer.nextToken();

		StringChain hasChain = new StringChain(words);
		if (hasChain.canChain())
		{
			/*
			 * for (String word : hasChain.chain()) System.out.print(word);
			 */
			System.out.println("Given words can be chained");
		} else
			System.out.println("Cannot");

		System.out.println();

	}

}
