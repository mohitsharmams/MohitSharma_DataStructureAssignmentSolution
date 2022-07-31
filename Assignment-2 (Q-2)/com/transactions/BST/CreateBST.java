package com.transactions.BST;

public class CreateBST {

	private Node createNode(int key){
		Node newNode = new Node();
		newNode.key = key;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}
	public Node insertNode(Node root, int key){

		Node newNode = createNode(key);

		Node x = root;  // Assign root to temporary pointer x
		Node y = null;  // y maintain the pointer to x

		while(x != null) {
			y = x;           // y maintain the current parent (non null node)
			if(key < x.key){
				x = x.left;
			}
			else if(key > x.key){
				x = x.right;
			}
			else {
				System.out.println("Value alreay exist");
				return newNode;
			}
		}
		// If root is empty
		if(y == null) {
			y = newNode;
		}
		// If key is less than current node, assign to left child
		else if(key < y.key) {
			y.left = newNode;
		}
		// If key is greater than current node, assign to right child
		else {
			y.right = newNode;
		}
		return y;
	}

	public void inorderBST(Node root) {
		if(root == null) {
			return;
		}

		else {
			inorderBST(root.left);
			System.out.print(root.key+" ");
			inorderBST(root.right);
		}

	}
	
	public void preorderBST(Node root) {
		if(root == null) {
			return;
		}

		else {
			System.out.print(root.key+" ");
			preorderBST(root.left);
			preorderBST(root.right);
		}

	}
	
	public void postorderBST(Node root) {
		if(root == null) {
			return;
		}

		else {
			postorderBST(root.left);
			postorderBST(root.right);
			System.out.print(root.key+" ");
		}

	}

}
