package com.skyscraper.construction;

public class MergeSort {

		int order;
		int iter=0;

		public int[] sort(int[] arr, int order) {
			int left = 0;
			int right = arr.length-1;
			this.order = order;
			
			if(order!=1 && order!=2) {
				System.err.println("Sorting order incorrect!");
				return arr;
			}
			
			mergeSort(arr, left, right);

			return arr;
		}
		
		public void mergeSort(int[] arr, int left, int right) {
			if (left < right) {
				int mid = (left+right)/2;
				mergeSort(arr, left, mid);
				mergeSort(arr, mid+1, right);
				
				if(order==1) {
					merge1(arr, left, mid, right);

				}
				if(order==2) {
					merge2(arr, left, mid, right);		

				}		
			}
		}
		// Method for ascending order sorting
		public void merge1(int[] arr, int left, int mid, int right) {
			
			int len1 = mid-left+1;
			int len2 = right-mid;
			int[] leftArr = new int[len1];
			int[] rightArr = new int[len2];
			
			for (int i =0 ; i<len1 ; i++) {   // Filling leftArr with left part of array
				leftArr[i] = arr[left+i];
			}
			
			for (int j =0 ; j<len2 ; j++) {   // Filling rightArr with right part of array
				rightArr[j] = arr[mid+1+j];
			}
			
			int i, j, k;
			i=0;          // for pointer at Left side array
			j=0;          // for pointer at right side array
			k=left;          // for pointer at merged array
			
			while(i < len1 && j < len2) {       // Loop to merge the elements by comparing left & Right side divided arrays
				if (leftArr[i] <= rightArr[j]) {  // checking if leftArr[i] element is lesser than or equal to rightArr[j] element
					arr[k] = leftArr[i];        // putting the leftArr[i] element in arr[k]
					i++;                        // moving the pointer of leftArr to next position 
				}
				
				else {                          // if above condition false than rightArr[j] element is lesser than or equal to leftArr[i] element
					arr[k] = rightArr[j];       // putting the rightArr[j] element in arr[k]
					j++;                        // moving the pointer of rightArr to next position 
				}
				k++;
			}              
			
			while(i<len1) {            // If i runs less than len1 size 
				arr[k] = leftArr[i];
				i++;
				k++;
			}
			while(j<len2) {           // If j runs less than len2 size
				arr[k] = rightArr[j];
				j++;
				k++;
			}		
		}
	// Method for descending order sorting	
	public void merge2(int[] arr, int left, int mid, int right) {
			
			int len1 = mid-left+1;
			int len2 = right-mid;
			int[] leftArr = new int[len1];
			int[] rightArr = new int[len2];
			
			for (int i =0 ; i<len1 ; i++) {   // Filling leftArr with left part of array
				leftArr[i] = arr[left+i];
			}
			
			for (int j =0 ; j<len2 ; j++) {   // Filling rightArr with right part of array
				rightArr[j] = arr[mid+1+j];
			}
			
			int i, j, k;
			i=0;          // for pointer at Left side array
			j=0;          // for pointer at right side array
			k=left;          // for pointer at merged array
			
			while(i < len1 && j < len2) {       // Loop to merge the elements by comparing left & Right side divided arrays
				if (leftArr[i] >= rightArr[j]) {  // checking if leftArr[i] element is lesser than or equal to rightArr[j] element
					arr[k] = leftArr[i];        // putting the leftArr[i] element in arr[k]
					i++;                        // moving the pointer of leftArr to next position 
				}
				
				else {                          // if above condition false than rightArr[j] element is lesser than or equal to leftArr[i] element
					arr[k] = rightArr[j];       // putting the rightArr[j] element in arr[k]
					j++;                        // moving the pointer of rightArr to next position 
				}
				k++;
			}               
			
			while(i<len1) {            // If i runs less than len1 size 
				arr[k] = leftArr[i];
				i++;
				k++;
			}
			while(j<len2) {           // If j runs less than len2 size
				arr[k] = rightArr[j];
				j++;
				k++;
			}		
		}

	}

