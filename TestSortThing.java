import java.util.*;
import java.lang.*;

/**
 * Class for QuickSort Investigation, exploring how changing
 * the switch to insertion sort affects runtime. Note that
 * there are many private methods here for how quicksort works.
 * (You won't need to consider all of them, especially fillAndShuffle().)
 * You'll modify main, and you're welcome to add any additional
 * methods you'd like. You will likely need to modify the way in which
 * the insertionSort threshold (currently set with MIN_SIZE) is
 * specified.
 *
 * @author Anna Rafferty
 * @author Layla Oesper
 * @author Eric Alexander
 * @author Titus Klinge
 * @author Sneha Narayan
 * @author Anika Rajbhandary and Aimee Yuan
 */
public class CompareSorts {

    /**
     * Helper function you may decide to use to print out a given array to the console.
     *
     * @param arr the array to print
     */
    private static void printArr(int[] arr) {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < arr.length; i++) {
            sj.add(Integer.toString(arr[i]));
        }
        System.out.println(sj.toString());
    }

    /**
     * Generates a pseudo-random permutation of the integers from 0 to a.length - 1.
     * See p. 139 of "Seminumerical Algorithms, 2nd edition," by Donald Knuth.
     */
    public static void fillAndShuffle(int[] a) {
        // Fill the array with the integers from 0 to a.length - 1.
        int k;
        for (k = 0; k < a.length; k++) {
            a[k] = k;
        }

        // Shuffle.
        for (k = a.length - 1; k > 0; k--) {
            int swapIndex = (int)Math.floor(Math.random() * (k + 1));
            int temp = a[k];
            a[k] = a[swapIndex];
            a[swapIndex] = temp;
        }
    }
    //Creates an array of length a that has items sorted in descending order
    public static void fillReverse(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - 1 - i;
        }
    }
    //Creates an array of length a that has items sorted in asending order (presorted)
    public static void fill(int[] a) {
        // Fill the array with the integers from 0 to a.length - 1.
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }

    //Bubble Sort algorithm that compares the current and next item, and swaps them if the current is larger than the next item
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    static void reverseArray(int a[], int n) 
    { 
        int[] b = new int[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
  
        // printing the reversed array 
        System.out.println("Reversed array is: \n"); 
        for (int k = 0; k < n; k++) { 
            System.out.println(b[k]); 
        } 
    } 

    //Testing the to sorting methods (comment out one when testing the other)
    public static void main(String[] args) {
        int[] standardSortArray = new int[10];
        //Beginning with a reverse sorted array that is an array of items from decending order
        fillReverse(standardSortArray);
        //Beginning with a random, shuffled array
        //fillAndShuffle(standardSortArray);
        //Beginning with a presorted array (all items are in ascending order)
        //fill(standardSortArray);
        //Starting the timer
        printArr(standardSortArray);
        long startTime = System.currentTimeMillis();
        //Arrays.sort(standardSortArray);
        bubbleSort(standardSortArray);
        //Ending the timer
        long endTime = System.currentTimeMillis();
        printArr(standardSortArray);
        System.out.println("Array length: " + standardSortArray.length + "; time to sort (ms): " + (endTime-startTime));

    }
    
}
