package BenchmarkingProject.src;

import java.util.*;


public class Sorting {

    public static int[] randomArray(int inputSizes) {
        
        int[] arr = new int[inputSizes];
        for (int i = 0; i<inputSizes; i++){
                arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }
    public static int[] copyArr(int[] src){
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
    

    public static void bubble(int [] arr) {
            for (int i = 0; i<arr.length-1; i++){ 
                for (int j=0; j<arr.length-i-1; j++){  
                    //Compare the adjacent elements                  
                    if (arr[j]>arr[j+1]){
                        //swap temp and cloned[i]
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        //System.out.println(Arrays.toString(cloned));
                    }                
                }
            }
    }
    
           
    
          


    public static void selection(int[] arr) {
        //moving the boundary of the unsorted subarray
        for (int i = 0; i<arr.length-1; i++){
            int min = i;
            //Find the minimum element in the array
            for (int j = i+1; j<arr.length; j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            //Swap the found minimum element with the first element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
               // System.out.println(Arrays.toString(cloned));
        }
    }


    

    public static void insertion(int [] arr) {
        //moving the boundary of the unsorted subarray
            for (int i = 1; i<arr.length; i++){
            //assigning a reference key variable
                int key = arr[i];
                int j = i-1;
                //comparing the elements and creating space for any insertion
                while ( j>=0 && (arr[j]>key)){
                    arr[j+1] = arr[j];                  
                    //System.out.println(Arrays.toString(cloned));  
                    j--;             
                }
                arr[j+1] = key;
            }    
        
    }

    public static void mergeSort(int[] arr) {
            if (arr.length>1){
                //Finding the middle of the array
                int mid = arr.length/2;
                //Creating the left and right subarrays
                int[] left = Arrays.copyOfRange(arr, 0, mid);
                int[] right = Arrays.copyOfRange(arr, mid, arr.length);
                //Sorting the left and right subarrays
                mergeSort(left);
                mergeSort(right);
                //Merging the left and right subarrays
                merge(arr, left, right);                
            }
    } 

    public static void merge(int[]arr, int[] left, int[] right){
        int i = 0;
        int j = 0;
        int result = 0;
        //Comparing the elements of the left and right subarrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[result] = left[i];
                i++;
                result++;
            } else {
                arr[result] = right[j];
                j++;
                result++;
            }
        }
        //Copying the remaining elements of the left subarray   
        while (i < left.length) {
            arr[result] = left[i];
            i++;
            result++;
        }
        //Copying the remaining elements of the right subarray
        while (j < right.length) {
            arr[result] = right[j];
            j++;
            result++;
        }
    }
 
    public static void counting(int[] arr) {
            //Finding the largest number in the array
        int max = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (arr[i]>max)
                max = arr[i];
            }
            //initialising the count array with the 0 needed
            int[] count = new int [max+1];
            for (int i = 0; i<max; i++){
                    count[i] = 0;
            }
            //Storing the count of each element
            for (int i = 0; i<arr.length; i++){
                count[arr[i]]++;
            }
            //Accumulating the count of the array and storing it
            for (int i= 1; i<=max; i++){
                    count[i] += count[i-1];
            }
            //Finding the index of each element of the array and putting 
            //them in the output array
            int[] output = new int[arr.length];
            for (int i= arr.length-1; i>=0; i--){
                output[count[arr[i]]-1] = arr[i];
                count[arr[i]]--;
            }
            //copying the output array into the original array
            for (int i = 0; i<arr.length; i++){
                    arr[i] = output[i];
            }
    }
                
                  
                
                  
                    public static void main(String[] args) {
                        // Array sizes to test
                        int[] arraySizes = {100, 250, 500, 750, 1000, 1250, 3750, 5000, 6250, 7500, 8750, 10000};
                        int reps = 10;
                
                        // Print table header
                        System.out.println("Array Size | Bubble Sort | Selection Sort | Insertion Sort | Merge Sort | Counting Sort");
                
                        // Perform repetitions for each array size
                        for (int size : arraySizes) {
                            double totalBubble = 0;
                            double totalSelection = 0;
                            double totalInsertion = 0;
                            double totalMergeSort = 0;
                            double totalCounting = 0;
                
                            // Perform repetitions
                            for (int i = 0; i < reps; i++) {
                                int[] arr = randomArray(size);
                                long startTime, endTime;
                
                                // Bubble Sort
                                int[] cloned = copyArr(arr);
                                startTime = System.nanoTime();
                                bubble(cloned);
                                endTime = System.nanoTime();
                                totalBubble += (endTime - startTime) / 1000000.0;
                
                                // Selection Sort
                                cloned = copyArr(arr);
                                startTime = System.nanoTime();
                                selection(cloned);
                                endTime = System.nanoTime();
                                totalSelection += (endTime - startTime) / 1000000.0;
                
                                // Insertion Sort
                                cloned = copyArr(arr);
                                startTime = System.nanoTime();
                                insertion(cloned);
                                endTime = System.nanoTime();
                                totalInsertion += (endTime - startTime) / 1000000.0;
                
                                // Merge Sort
                                cloned = copyArr(arr);
                                startTime = System.nanoTime();
                                mergeSort(cloned);
                                endTime = System.nanoTime();
                                totalMergeSort += (endTime - startTime) / 1000000.0;
                
                                // Counting Sort
                                cloned = copyArr(arr);
                                startTime = System.nanoTime();
                                counting(cloned);
                                endTime = System.nanoTime();
                                totalCounting += (endTime - startTime) / 1000000.0;
                            }
                
                            // Print results for each array size
                            System.out.printf("%10d | %11.3f | %14.3f | %15.3f | %9.3f | %12.3f\n", size,
                                    totalBubble / reps, totalSelection / reps, totalInsertion / reps,
                                    totalMergeSort / reps, totalCounting / reps);
                        }
                    }
                }
                