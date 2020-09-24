package excitement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSelection {
    public static void main(String[] args) throws Exception {
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(4, 6, 7));
        int h=5;
        int test = findLargestK(h, list1, list2, 0, list1.size() - 1, 0, list2.size() - 1);
        System.out.println("The " + h + "-largest element is: " + test+"\n  ********");
        for (int k = 1; k <= list1.size() + list2.size(); k++) {
            int result = findLargestK(k, list1, list2, 0, list1.size() - 1, 0, list2.size() - 1);
            System.out.println("The " + k + "-largest element is: " + result);
        }
    }

    private static int findLargestK(int k, List<Integer> list1, List<Integer> list2, int start1, int end1, int start2, int end2) throws Exception {
        if (k < 1) {
            throw new Exception("k must be a positive integer k>=1 and k<= m+n-1)");
        }
        if (end1 == start1) {
            return k == 1  ?  list1.get(start1): list2.get(end2 -(k-1) + 1);
        }
        if (end2 == start2) {
            return k == 1  ?  list2.get(start2): list1.get(end1 -(k-1) + 1);
        }
        int mid1 = (end1 + start1) / 2;
        int mid2 = (end2 + start2) / 2;

        if ((end1 - mid1 + 1) + (end2 - mid2 + 1) < k) {
            if (list1.get(mid1) > list2.get(mid2)) {
                return findLargestK(k - (end1 - mid1 + 1), list1, list2, start1, mid1 - 1, 0, end2);
            } else {
                return findLargestK(k - (end2 - mid2 + 1), list1, list2, 0, end1, start2, mid2 - 1);

            }
        } else {
            if (list1.get(mid1) > list2.get(mid2)) {
                return findLargestK(k, list1, list2, start1, end1, mid2 + 1, end2);
            } else {
                return findLargestK(k, list1, list2, mid1 + 1, end1, start2, end2);
            }
        }

    }

}
