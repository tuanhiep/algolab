package lab2;

public class MergeSort {

    /**
     * Algorithm to do MergeSort for an array
     * @param array
     * @return sorted array
     */
    public static int[] mergeSort(int[] array) {
        int size = array.length;
        // finished condition
        if (size == 1) return array;
        int middle = size / 2;
        // first part of array to be sorted
        int[] firstInput = new int[middle];
        System.arraycopy(array, 0, firstInput, 0, middle);
        int[] firstPart = mergeSort(firstInput);
        // the rest of array to be sorted
        int[] secondInput = new int[size - middle];
        System.arraycopy(array, middle, secondInput, 0, size - middle);
        int[] secondPart = mergeSort(secondInput);
        // merge two parts to get the result
        return mergeArray(firstPart, secondPart);

    }

    protected static int[] mergeArray(int[] firstPart, int[] secondPart) {
        int[] result = new int[firstPart.length + secondPart.length];
        int i = 0;
        int j = 0;
        int z = 0;
        while (i < firstPart.length || j < secondPart.length) {
            if (i == firstPart.length && j < secondPart.length) {
                result[z] = secondPart[j];
                z++;
                j++;
                continue;
            }
            if (j == secondPart.length && i < firstPart.length) {
                result[z] = firstPart[i];
                z++;
                i++;
                continue;
            }
            if (firstPart[i] < secondPart[j]) {
                result[z] = firstPart[i];
                z++;
                i++;
            } else {
                result[z] = secondPart[j];
                z++;
                j++;
            }

        }

        return result;
    }
}
