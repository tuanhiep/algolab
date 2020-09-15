package lab2;

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
            int pivotIndex = partitionRightmostPivot(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
            return array;
        }
        return array;

    }


    /**
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


    static int partitionRightmostPivot(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
