package lab2;

import java.util.Random;

public class Main {

    private static int MIN = 0;
    private static int MAX = 1000;

    /**
     * Test algorithms BubbleSort, MergeSort, QuickSort
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] sizes = new int[]{512, 1024, 2048, 4096};
        String runtimeBubbleSort = "";
        String runtimeMergeSort = "";
        String runtimeQuickSort = "";
        String inputSize = "";
        for (int s : sizes) {
            inputSize += s + ",";
            int[] array = generateRandomly(s);
            System.out.println("\n*** TEST WITH ARRAY SIZE " + s + " ***");
            // Test BubbleSort
            System.out.println("\nI.BubbleSort");
            int[] bsTarget = array.clone();
            // start measuring runtime
            long startTime = System.nanoTime();
            int[] bsResult = BubbleSort.bubbleSort(bsTarget);
            // end measuring runtime
            long endTime = System.nanoTime();
            runtimeBubbleSort += (endTime - startTime) + ",";
            checkSorted(bsResult);
            printResult(bsResult);

            // Test MergeSort
            System.out.println("\nII.MergeSort");
            int[] msTarget = array.clone();
            // start measuring runtime
            startTime = System.nanoTime();
            int[] msResult = MergeSort.mergeSort(msTarget);
            // end measuring runtime
            endTime = System.nanoTime();
            runtimeMergeSort += (endTime - startTime) + ",";
            checkSorted(msResult);
            printResult(msResult);

            // Test QuickSort
            System.out.println("\nIII.QuickSort");
            int[] qsTarget = array.clone();
            // start measuring runtime
            startTime = System.nanoTime();
            int[] qsResult = QuickSort.quickSort(qsTarget, 0, qsTarget.length - 1);
            // end measuring runtime
            endTime = System.nanoTime();
            runtimeQuickSort += (endTime - startTime) + ",";
            checkSorted(qsResult);
            printResult(qsResult);

        }
        System.out.println("Summary:");
        System.out.println("For input size is: " + inputSize);
        System.out.println("Runtime (nanoseconds) of BubbleSort is: " + runtimeBubbleSort);
        System.out.println("Runtime (nanoseconds) of MergeSort is: " + runtimeMergeSort);
        System.out.println("Runtime (nanoseconds) of QuickSort is: " + runtimeQuickSort);
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
