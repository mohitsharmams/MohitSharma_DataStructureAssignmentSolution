package com.skyscraper;

import java.util.Scanner;
import com.skyscraper.construction.Construction;

public class Assembling {

	public static void main(String[] args) {
		int size = 0;
		boolean status = true;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter total number of floors in building: ");
			int temp = sc.nextInt();
			if(temp<=0) {
				count++;
				if(count<2) {
					System.err.println("Invalid size, please try again!");
				}
				status = false;
			}
			else {
				size = temp;
				status = true;
			}
		}while(!status && count<2);

		if(status) {
			Construction co = new Construction();
			co.createFloor(size, sc);

			System.out.println("The order of construction is as follow: ");
			co.assemble();
		}

		else {
			System.err.println("Invalid input entered 2 times, program is exiting!");
		}
		sc.close();

	}

}
