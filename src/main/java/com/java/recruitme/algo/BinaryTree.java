package com.java.recruitme.algo;

class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
		Integer.valueOf(10);
	}
}

public class BinaryTree {
	// Root of the Binary Tree
	Node root;

	public BinaryTree() {
		root = null;
	}

	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = h; i >= 1; i--)
			printGivenLevel(root, i);
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);

			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight) {
				//System.out.println("lheight : " + lheight + " rheight : " + rheight + " root data : " + root.data);
				return (lheight + 1);
			} else {
				//System.out.println("lheight : " + lheight + " rheight : " + rheight + " root data : " + root.data);
				return (rheight + 1);
			}
		}
	}

	int maxSum = 0;
	
	int maxSumPath(Node root, int maxSum) {
		
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = maxSumPath(root.left, maxSum);

			int rheight = maxSumPath(root.right, maxSum);

			// Max path for parent call of root. This path must
	        // include at-most one child of root
	        int max_single = Math.max(Math.max(lheight, rheight) + root.data,
	                                  root.data);
	 
	 
	        // Max Top represents the sum when the Node under
	        // consideration is the root of the maxsum path and no
	        // ancestors of root are there in max sum path
	        int max_top = Math.max(max_single, lheight + rheight + root.data);
	 
	        // Store the Maximum Result.
	        maxSum = Math.max(maxSum, max_top);
	 
	        return max_single;
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(-25);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.right = new Node(4);
		System.out.println("maximum path sum is : " + tree.maxSumPath(tree.root, tree.maxSum));
		
		/*
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		*/

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
		
		System.out.println("In order traversal of binary tree is ");
		tree.printInOrder(tree.root);

		System.out.println("Post order traversal of binary tree is ");
		tree.printPostOrder(tree.root);

		System.out.println("Pre order traversal of binary tree is ");
		tree.printPreOrder(tree.root);
	}

	private void printPreOrder(Node root) {
		if (null == root)
			return;
		System.out.println(root.data);
		printPreOrder(root.left);

		printPreOrder(root.right);
	}

	private void printPostOrder(Node root) {
		if (null == root)
			return;
		printPostOrder(root.left);

		printPostOrder(root.right);

		System.out.println(root.data);
	}

	private void printInOrder(Node root) {

		if (null == root)
			return;

		printInOrder(root.left);
		System.out.println(root.data);
		printInOrder(root.right);
	}
}
