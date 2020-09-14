package lab2;

import java.util.Random;

public class Main {

    private static int MIN = 0;
    private static int MAX = 10000;

    /**
     * Test algorithms BubbleSort, MergeSort, QuickSort
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] sizes = new int[]{512, 1024, 2048, 4096};
//        int[] sizes = new int[]{100};

        for (int s : sizes) {
            int[] array = generateRandomly(s);
            System.out.println("\n*** TEST WITH ARRAY SIZE " + s+ " ***");
            // Test BubbleSort
            System.out.println("\nI.BubbleSort");
            int[] bsTarget = array.clone();
            int[] bsResult = BubbleSort.bubbleSort(bsTarget);
            checkSorted(bsResult);
            printResult(bsResult);

            // Test MergeSort
            System.out.println("\nII.MergeSort");
            int[] msTarget = array.clone();
            int[] msResult = MergeSort.mergeSort(msTarget);
            checkSorted(msResult);
            printResult(msResult);

            // Test QuickSort
            System.out.println("\nIII.QuickSort");
            int[] qsTarget = array.clone();
            int[] qsResult = QuickSort.quickSort(qsTarget, 0, qsTarget.length - 1);
            checkSorted(qsResult);
            printResult(qsResult);

        }
    }

    private static void checkSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                System.out.println("\nArray is not sorted !");
                return;
            }
        }
        System.out.println("\nArray is sorted !");
    }

    /**
     * Print the first 5 and last 5 elements
     *
     * @param result
     */
    private static void printResult(int[] result) {
        System.out.println("\nFirst 5 elements: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("\nLast 5 elements: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(result[result.length - 5 + i] + " ");
        }
        System.out.println("\n");
    }

    /**
     * Generate an array with random integer between MIN and MAX
     *
     * @param size
     * @return
     */
    private static int[] generateRandomly(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt((MAX - MIN) + 1) + MIN;
        }
        return array;

    }
}
