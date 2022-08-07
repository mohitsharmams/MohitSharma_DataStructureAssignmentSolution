package com.transactions;

import com.transactions.BST.*;

import java.util.Scanner;

public class ModifyTransactions {
	static Node root=null, tempNode, rootRightSkewed=null;
	static int elementNum, count=0;
	static int key;

	public static void main(String[] args) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter total number of transactions: ");
		elementNum = sc.nextInt();
		if(elementNum <1) {
			System.err.println("Invalid transactions number");
			flag = false;
		}

		CreateBST ct = new CreateBST();

		while(elementNum > 0 && flag) {
			count++;
			System.out.println("Enter transaction no. "+count+" value");
			key = sc.nextInt();
			if(key < 0) {
				System.out.println("Transaction value can not be negative");
				count--;
				continue;
			}
			if(root == null) {
				root = ct.insertNode(root, key);
				elementNum--;
			}
			else {
				tempNode = ct.insertNode(root, key);
				if(tempNode.key != key) {
					elementNum--;	// If distinct value then decrement
				}
				else {
					count--;
					continue;
				}
			}
			System.out.println("BST inorder after inserting value- "+key+" :");
			ct.inorderBST(root);
			System.out.println("");
		}
		
		System.out.println("\n*************************************\n");
		
		System.out.print("User Input BST inorder : [ ");
		ct.inorderBST(root);
		System.out.print("]\n");
		
		System.out.print("User Input BST preorder : [ ");
		ct.preorderBST(root);
		System.out.print("]\n");
		
		System.out.print("User Input BST postorder : [ ");
		ct.postorderBST(root);
		System.out.print("]\n");
		
		
		System.out.println("\n*****BST after Right Skewing*****");

		RightSkewedBST rsbst = new RightSkewedBST();

		rootRightSkewed = rsbst.rightskew(root);
		
		System.out.print("Right Skewed BST inorder : [ ");
		rsbst.inorderBST(rootRightSkewed);
		System.out.print("]\n");
		
		System.out.print("Right Skewed BST preorder : [ ");
		rsbst.preorderBST(rootRightSkewed);
		System.out.print("]\n");
		
		System.out.print("Right Skewed BST postorder : [ ");
		rsbst.postorderBST(rootRightSkewed);
		System.out.print("]\n");
		
		sc.close();
	}

}
