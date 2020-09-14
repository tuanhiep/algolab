package lab2;

public class BubbleSort {

    /**
     * Algorithm to do the BubbleSort for an array
     *
     * @param array
     * @return sorted array
     */
    public int[] bubbleSort(int[] array) {

        if (array.length <= 0) return null;
        // sort the array array in the ascending order
        for (int j = 1; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - j - 1; i++) {
                int temp;
                if (array[i] > array[i + 1]) {
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }

        }

        return array;
    }

}
