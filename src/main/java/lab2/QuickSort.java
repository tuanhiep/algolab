package lab2;

public class QuickSort {
    /**
     * Do quicksort for array elements in range: [start,end]
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int[] quickSort(int[] array, int start, int end) throws Exception {

        if (start >= end) {
            return null;
        }
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);
        return array;


    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        while (start < end) {

            while (array[start] < pivot) {
                start++;
            }
            while (array[end] > pivot) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }

        }
        return start;

    }
}
