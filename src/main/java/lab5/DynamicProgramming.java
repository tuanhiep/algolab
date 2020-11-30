package lab5;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {


    public static void main(String[] args) {
        // Example 1
        int[] w = new int[]{4, 5, 7};
        int[] v = new int[]{2, 3, 4};
        int m = 10;
        knapSackDp(w, v, m);
        knapSackGa(w, v, m);

        // Example 2
        w = new int[]{2, 3, 3};
        v = new int[]{3, 1, 7};
        m = 6;
        knapSackDp(w, v, m);
        knapSackGa(w, v, m);

    }

    private static void knapSackGa(int[] w, int[] v, int m) {

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
        // Solution 1
        System.out.println("Solution 1:");
        int[][] knapSack1 = initialize(maximum, n);
        int result = knapSackDp1(w, v, maximum, n - 1, knapSack1);
        outputSelected1(w, v, maximum, n - 1, knapSack1, result);

        // Solution 2
        System.out.println("Solution 2:");
        int[][] knapSack2 = initialize(maximum, n);
        List<Integer> selected = new ArrayList<>();
        int result2 = knapSackDp2(w, v, maximum, n - 1, knapSack2, selected);
        outputSelected2(w, v, selected, result2);

    }


    /**
     * Solution 1: Dynamic Programming algorithm to find maximum value
     *
     * @param w:         item weights
     * @param v:         item values
     * @param maxWeight: maximum weight of knapSack
     * @param indexItem: total number of items
     * @param knapSack
     * @return maximum value
     */
    private static int knapSackDp1(int[] w, int[] v, int maxWeight, int indexItem, int[][] knapSack) {
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
    private static void outputSelected1(int[] w, int[] v, int maxWeight, int indexItem, int[][] knapSack, int result) {
        int remProfit = result;
        int j = maxWeight;
        int i = indexItem;
        while (remProfit > 0) {
            while (i > 0 && knapSack[i][j] == knapSack[i - 1][j] && knapSack[i][j] != -1) {
                i = i - 1;
            }
            System.out.println("Item " + i + ": w = " + w[i] + " v = " + v[i]);
            remProfit = remProfit - v[i];
            while (knapSack[i][j] == -1 || knapSack[i][j] > remProfit) {
                j = j - 1;
            }

        }
        System.out.println("were chosen and the total value is " + result);
    }


    /**
     * Solution 2: Dynamic Programming algorithm to find maximum value and list of selected items
     *
     * @param w
     * @param v
     * @param maxWeight
     * @param indexItem
     * @param knapSack
     * @param selected
     * @return
     */
    private static int knapSackDp2(int[] w, int[] v, int maxWeight, int indexItem, int[][] knapSack, List<Integer> selected) {
        if (indexItem == -1 || maxWeight == 0) {
            return 0;
        }
        if (knapSack[indexItem][maxWeight] != -1) {
            return knapSack[indexItem][maxWeight];
        }
        if (w[indexItem] <= maxWeight) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int option1 = v[indexItem] + knapSackDp2(w, v, maxWeight - w[indexItem], indexItem - 1, knapSack, list1);
            int option2 = knapSackDp2(w, v, maxWeight, indexItem - 1, knapSack, list2);
            if (option1 > option2) {
                selected.add(indexItem);
                selected.addAll(list1);
                knapSack[indexItem][maxWeight] = option1;
            } else {
                selected.addAll(list2);
                knapSack[indexItem][maxWeight] = option2;
            }

        } else {
            List<Integer> list = new ArrayList<>();
            knapSack[indexItem][maxWeight] = knapSackDp2(w, v, maxWeight, indexItem - 1, knapSack, list);
            selected.addAll(list);
        }
        return knapSack[indexItem][maxWeight];
    }

    /**
     * Output the selected items for 0/1 knapSack problem
     *
     * @param w
     * @param v
     * @param selected
     * @param total
     */
    private static void outputSelected2(int[] w, int[] v, List<Integer> selected, int total) {
        if (selected.size() == 0) {
            System.out.println("No items was chosen !");
            return;
        }

        for (int item : selected) {
            System.out.println("Item " + item + ": w = " + w[item] + " v = " + v[item]);
        }
        System.out.println("were chosen and the total value is " + total);
    }

}

