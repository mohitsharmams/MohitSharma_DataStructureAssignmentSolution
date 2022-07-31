package com.transactions.BST;

public class RightSkewedBST {
	Node rootNew = null;
	CreateBST ctr = new CreateBST();
	
	public Node rightskew(Node root) {
		
		rightSkew(root);
		return rootNew;
		
	}
	
	// Method to create new BST rootNew by Right skewing the original root
	// This is inorder algo with inserting the nodes in place of printing
	public void rightSkew(Node root) {

		if(root == null) {
			return;
		}

		else {
			rightSkew(root.left);
			// inserting root elements in rootNew
			if(rootNew == null) {
				rootNew = ctr.insertNode(rootNew, root.key);
			}
			else {
				ctr.insertNode(rootNew, root.key);
			}
			
			rightSkew(root.right);
		}
		
	}
	
	public void inorderBST(Node rootNew) {
		if(rootNew == null) {
			return;
		}

		else {
			inorderBST(rootNew.left);
			System.out.print(rootNew.key+" ");
			inorderBST(rootNew.right);
		}

	}
	
	public void preorderBST(Node rootNew) {
		if(rootNew == null) {
			return;
		}

		else {
			System.out.print(rootNew.key+" ");
			preorderBST(rootNew.left);
			preorderBST(rootNew.right);
		}

	}
	
	public void postorderBST(Node rootNew) {
		if(rootNew == null) {
			return;
		}

		else {
			postorderBST(rootNew.left);
			postorderBST(rootNew.right);
			System.out.print(rootNew.key+" ");
		}

	}
	
	

}
