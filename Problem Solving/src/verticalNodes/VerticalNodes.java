package verticalNodes;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/informatica-internship-interview-experience/
 * Round 3 : 3
 * @author kempa
 *
 */
public class VerticalNodes {
	private Node root;
	private LinkedHashMap<Integer, List<Node>> verticalList;
	private int max, min;
	
	public VerticalNodes(Node root) {
		this.root = root;
		verticalList = new LinkedHashMap<>();
	}
	
	private void mark(Node node, int hd)
	{
		if (node == null)
			return;
		node.hd = hd;
		
		max = (hd > max) ? hd : max;
		min = (hd < min) ? hd : min;
		
		if (node.left != null)
			mark(node.left, node.hd - 1);
		if (node.right != null)
			mark(node.right, node.hd + 1);
	}
	
	private void classify(Node node) {
		if (node == null)
			return;
		
		// Traverse inorder so that the left most line comes first
		if (node.left != null)
			classify(node.left);
		
		List<Node> hdList = verticalList.get(node.hd);
		if (hdList == null) {
			List<Node> list = new LinkedList<>();
			list.add(node);
			verticalList.put(node.hd, list);
		}
		else {
			hdList.add(node);
		}
		
		
		if (node.right != null)
			classify(node.right);
	}
	
	
	
	public void classify() {
		max = 0;
		min = 0;
		mark(root, 0);
		classify(root);
		
		for (int hd = min; hd <= max; hd++) {
			System.out.print(hd + " : ");
			for (Node node : verticalList.get(hd)) {
				System.out.print(node.val + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		
		VerticalNodes verticalNodes = new VerticalNodes(root);
		verticalNodes.classify();
	}
	
	private static class Node {
		int val;
		Node right;
		Node left;
		int hd; // horizontal distance
		
		public Node(int val) {
			this.val = val;
			right = null;
			left = null;
		}
	}
	
}

