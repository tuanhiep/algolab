package lab2;

import java.util.Random;

public class QuickSort {
    /**
     * Do quicksort for array elements in range: [low,high]
     *
     * @param array
     * @param low
     * @param high
     * @return sorted array
     */
    public static int[] quickSort(int[] array, int low, int high) throws Exception {

        if (low < high) {
            int pivotIndex = partitionLeftmostPivot(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
            return array;
        }
        return array;

    }


    /**
     * partition method for quicksort with pivot is the leftmost element
     * @param array
     * @param low
     * @param high
     * @return index which separate array into 2 parts: greater than pivot and less than pivot
     */
    private static int partitionLeftmostPivot(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low, j = high;
        while (i < j) {

            while (i < high && array[i] <= pivot) {
                i++;
            }
            while (j > low && array[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }

        }
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;
        return j;

    }

    /**
     * partition method for quicksort with pivot is the rightmost element
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int partitionRightmostPivot(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot) {
                i++;

                // swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**
     * partition method for quicksort with pivot is a random element
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int partitionRandomPivot(int[] array, int low, int high) {
        Random rand = new Random();
        int pivotIndex=rand.nextInt((high - low) + 1) + low;
        int temp = array[pivotIndex];
        array[pivotIndex] = array[low];
        array[low] = temp;
        return partitionLeftmostPivot(array, low, high);


    }
}
