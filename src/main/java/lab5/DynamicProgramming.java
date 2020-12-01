package lab5;

import java.util.Arrays;

public class DynamicProgramming {


    public static void main(String[] args) {
        System.out.println("I>TEST FUNCTION");
        // Test 1
        System.out.println("* Test 1");
        int[] w = new int[]{4, 5, 7};
        int[] v = new int[]{2, 3, 4};
        int m = 10;
        printData(w, v, m);
        knapSackDp(w, v, m);
        knapSackGa(w, v, m);

        // Test 2
        System.out.println("* Test 2");
        w = new int[]{6, 5, 7, 3, 1};
        v = new int[]{7, 3, 4, 4, 3};
        m = 13;
        printData(w, v, m);
        knapSackDp(w, v, m);
        knapSackGa(w, v, m);

        // Test 3
        System.out.println("* Test 3");
        w = new int[]{2, 3, 5, 5, 3, 7};
        v = new int[]{3, 4, 10, 9, 6, 13};
        m = 15;
        printData(w, v, m);
        knapSackDp(w, v, m);
        knapSackGa(w, v, m);

        // Test 4
        System.out.println("* Test 4");
        w = new int[]{10, 13, 17, 15};
        v = new int[]{21, 17, 30, 23};
        m = 30;
        printData(w, v, m);
        knapSackDp(w, v, m);
        knapSackGa(w, v, m);

        // Test 5
        System.out.println("* Test 5");
        w = new int[]{5, 4, 7, 6, 3, 4, 2, 1, 7, 6};
        v = new int[]{3, 1, 3, 2, 1, 3, 2, 3, 1, 4};
        m = 30;
        printData(w, v, m);
        knapSackDp(w, v, m);
        knapSackGa(w, v, m);
        System.out.println("II> RUNTIME COMPARISON");

    }

    /**
     * print out given data
     *
     * @param w
     * @param v
     * @param m
     */
    private static void printData(int[] w, int[] v, int m) {
        System.out.println("Given:");
        // print out w[]
        System.out.print("w={");
        for (int weight : w) {
            System.out.print(weight + ",");
        }
        System.out.println("}");
        System.out.print("v={");
        // print out v[]
        for (int value : v) {
            System.out.print(value + ",");
        }
        System.out.println("}");
        System.out.println("Maximum weight limit of knapsack is " + m);

    }

    private static void knapSackGa(int[] w, int[] v, int m) {
        System.out.println("2.Greedy approach:");
        Item[] items = new Item[w.length];

        for (int i = 0; i < w.length; i++) {
            items[i] = new Item(w[i], v[i], i);
        }

        Arrays.sort(items);
        int maximum = 0;
        int space = m;
        for (Item i : items) {
            if (space >= i.weight) {
                maximum += i.value;
                space -= i.weight;
                System.out.println("Item " + i.index + " : " + ": w = " + w[i.index] + " v = " + v[i.index]);
            }
        }
        if (maximum == 0) {
            System.out.println("No items was chosen !");
            return;
        }
        System.out.println("were chosen and the total value is " + maximum);


    }

    /**
     * Initialize the table knapSack for memoization
     *
     * @param m:    maximum weight of knapSack
     * @param size: total number of items
     * @return
     */
    private static int[][] initialize(int m, int size) {
        int[][] knapSack = new int[size][m + 1];
        for (int index = 0; index < size; index++) {
            for (int capacity = 0; capacity < m + 1; capacity++) {
                knapSack[index][capacity] = -1;
            }
        }
        return knapSack;
    }

    /**
     * Dynamic programming to find the maximum value with given constraint in weight
     *
     * @param w:      item weights
     * @param v:      item values
     * @param maximum value
     * @return
     */
    public static void knapSackDp(int[] w, int[] v, int maximum) {
        // total number of items
        int n = w.length;
        System.out.println("1.Dynamic Programming - Tabulation - Bottom-up approach:");
        int[][] knapSack = initialize(maximum, n);
        int result = knapSackDp(w, v, maximum, n - 1, knapSack);
        outputSelected(w, v, maximum, n - 1, knapSack, result);

    }


    /**
     * Dynamic Programming algorithm to find maximum value
     *
     * @param w:         item weights
     * @param v:         item values
     * @param maxWeight: maximum weight of knapSack
     * @param indexItem: total number of items
     * @param knapSack
     * @return maximum value
     */
    private static int knapSackDp(int[] w, int[] v, int maxWeight, int indexItem, int[][] knapSack) {
        int i, c;
        // Build table knapSack in bottom up manner
        for (i = 0; i <= indexItem; i++) {
            for (c = 0; c <= maxWeight; c++) {
                if (c == 0 || (i == 0 && c < w[i])) {
                    knapSack[i][c] = 0;
                } else if (i == 0 && c >= w[i]) {
                    knapSack[i][c] = v[i];
                } else if (w[i] <= c)
                    knapSack[i][c] = Math.max(v[i] + knapSack[i - 1][c - w[i]], knapSack[i - 1][c]);
                else
                    knapSack[i][c] = knapSack[i - 1][c];
            }
        }
        return knapSack[indexItem][maxWeight];
    }

    /**
     * Output the selected items for 0/1 knapSack problem
     *
     * @param w
     * @param v
     * @param maxWeight
     * @param indexItem
     * @param knapSack
     * @param result
     */
    private static void outputSelected(int[] w, int[] v, int maxWeight, int indexItem, int[][] knapSack, int result) {
        if (result == 0) {
            System.out.println("No items was chosen !");
            return;
        }
        int remProfit = result;
        int j = maxWeight;
        int i = indexItem;
        while (remProfit > 0) {
            while (i > 0 && knapSack[i][j] == knapSack[i - 1][j]) {
                i = i - 1;
            }
            System.out.println("Item " + i + ": w = " + w[i] + " v = " + v[i]);
            remProfit = remProfit - v[i];
            if (i > 0) {
                i = i - 1;
            }
            while (knapSack[i][j] > remProfit) {
                j = j - 1;
            }

        }
        System.out.println("were chosen and the total value is " + result);
    }

}

