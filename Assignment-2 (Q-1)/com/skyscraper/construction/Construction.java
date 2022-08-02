package com.skyscraper.construction;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

//Using Deque Linked List & Stacks
public class Construction {
	int size;
	Stack<Integer> stack = new Stack<Integer>();
	Deque<Integer> dq = new LinkedList<Integer>();

	// Method to store user input into deque
	public void createFloor(int size, Scanner sc) {
		this.size = size;
		for(int i = 0 ; i < size ; i++) {
			System.out.print("Enter floor size on day - " + (i + 1) + " : ");
			int temp = sc.nextInt();
			boolean flag = discardDuplicates(dq, temp);  // flag to check Duplicate values
			if (flag) { 						// No Duplicate value entered
				System.out.println("Duplicate floor size, enter again");
				--i;
			}
			else if (temp <= 0 && !flag) {            // Checking condition for Invalid entry zero or negative
				System.out.println("Invalid floor size, enter again");
				--i;
			}
			else if(temp > 0 && !flag) {
				dq.add(temp);
			}
		}
	}
	// Method to assemble the floors as per size & day constraints
	public void assemble() {

		SortingDequeIntoStack(dq);  // Calling method to fill stack in descending order sorted elements of deque

		int index = -1;  // This will maintain index value in every iteration of deque

		for(int i = 0 ; i < size ; i++) {


			Iterator<Integer> dequeItr = dq.iterator();
			int j = 0;	// Temporary variable to store the iteration counting
			while(dequeItr.hasNext()) {
				int tempdq = dequeItr.next();
				if(tempdq != stack.peek() && j > index){
					System.out.println("\nDay-"+(j+1)+": ");
					j++;
				}

				else if(tempdq == stack.peek()){

					if (j > index) {
						index = j;
						System.out.println("\nDay-" + (j + 1) + ": ");
						System.out.print(" " + tempdq + " ");
						stack.pop();
						j++;
					}
					else if(j < index){
						System.out.print(" " + tempdq + " ");
						stack.pop();
						j++;
					}
					else{
						j++;
					}

					break;

				}
				else {
					j++;
				}
			}
		}

	}

	// Method to discard duplicate values
	public boolean discardDuplicates(Deque<Integer> dq, int value){

		Iterator<Integer> dqIter2 = dq.iterator();
		while(dqIter2.hasNext()) {
			int tempDuplicate = dqIter2.next();
			if(tempDuplicate == value) {
				return true;  // Duplicate value entered
			}
		}
		return false;  // No duplicates
	}

	// Method to create temporary deque dq1 and inserting descending order sorted elements in stack
	public void SortingDequeIntoStack(Deque<Integer> dq){

		Deque<Integer> dq1 = new LinkedList<Integer>();  // temporary deque dq1

		Iterator<Integer> dqIt = dq.iterator();
		while(dqIt.hasNext()) {
			dq1.addLast(dqIt.next());
		}

		for(int i = 0 ; i < size ; i++){
			int tempMin = Integer.MAX_VALUE;
			Iterator<Integer> dq1It = dq1.iterator();
			while(dq1It.hasNext()) {
				int tempdq1 = dq1It.next();
				if(tempdq1 < tempMin) {  // checking for min value in temporary deque dq1
					tempMin = tempdq1;
				}
			}
			stack.push(tempMin);    // pushing minimum values first in stack
			dq1.remove(tempMin);    // removing minimum value from temporary deque dq1
		}
	}
}


