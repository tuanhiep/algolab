package lab5;

public class DynamicProgramming {


    public static void main(String[] args) {
        // Example 1
        int[] w = new int[]{4, 5, 7};
        int[] v = new int[]{2, 3, 4};
        int m = 10;
        int result = knapSackDp(w, v, m);
        System.out.println("Maximum value: " + result);
        // Example 2
        w = new int[]{2, 3, 3};
        v = new int[]{3, 1, 7};
        m = 6;
        result = knapSackDp(w, v, m);
        System.out.println("Maximum value: " + result);

    }

    /**
     * Initialize the table knapSack for memoization
     *
     * @param m
     * @param size
     * @return
     */
    private static int[][] initialize(int m, int size) {
        int[][] knapSack = new int[size + 1][m + 1];
        for (int index = 0; index < size + 1; index++) {
            for (int capacity = 0; capacity < m + 1; capacity++) {
                knapSack[index][capacity] = -1;
            }
        }
        return knapSack;
    }

    /**
     * Dynamic programming to find the maximum value with given constraint in weight
     *
     * @param w
     * @param v
     * @param maximum
     * @return
     */
    public static int knapSackDp(int[] w, int[] v, int maximum) {
        // total number of items
        int n = w.length;
        // memoization table for dynamic programming
        int[][] knapSack = initialize(maximum, n);
        return knapSackDp(w, v, maximum, n, knapSack);
    }

    private static int knapSackDp(int[] w, int[] v, int m, int n, int[][] knapSack) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (knapSack[n][m] != -1) {
            return knapSack[n][m];
        }
        if (w[n - 1] <= m) {
            knapSack[n][m] = Math.max(v[n - 1] + knapSackDp(w, v, m - w[n - 1], n - 1, knapSack), knapSackDp(w, v, m, n - 1, knapSack));
            return knapSack[n][m];
        } else {
            knapSack[n][m] = knapSackDp(w, v, m, n - 1, knapSack);
            return knapSack[n][m];
        }
    }
}

