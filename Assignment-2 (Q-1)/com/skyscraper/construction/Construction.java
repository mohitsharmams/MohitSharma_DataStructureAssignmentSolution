package com.skyscraper.construction;

import java.util.Scanner;

public class Construction {

	int []floor;
	int []temparr;
	int size;

	public int[] createFloor(int size, Scanner sc) {
		this.size = size;
		floor = new int[size];
		//temparr = new int[size];

		for (int i=0; i<size; i++) {
			System.out.print("Enter floor size on day - "+(i+1)+" : ");
			int temp = sc.nextInt();
			if(temp <= 0) {				// Checking condition for Invalid entry zero or negative
				System.out.println("Invalid floor size, enter again");
				--i;
			}
			else {
				floor[i] = temp;        // Filling User input in array
				//temparr[i] = floor[i];  // Filling temporary array
			}
		}
		return floor;
	}

	public void assemble() {
		
		temparr = floor.clone();
		// Sorting temporary array in descending order using mergesort
		MergeSort ms = new MergeSort();
		temparr = ms.sort(temparr,2);
		
		int index = -1;  // Index to set the pointer on current values in floor array

		for(int i = 0 ; i < size ; i++){

			for(int j = 0 ; j < size ; j++){

				if(temparr[i] != floor[j] && j > index){
					System.out.println("\nDay-"+(j+1)+": ");
				}

				else if(temparr[i] == floor[j]){

					if (j > index) {
						index = j;
						System.out.println("\nDay-" + (j + 1) + ": ");
						System.out.print(" " + floor[j] + " ");

					}
					else{
						System.out.print(" " + floor[j] + " ");
					}
					break;
				}
			}
		}

	}

}
