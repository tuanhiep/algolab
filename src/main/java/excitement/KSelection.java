package excitement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSelection {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(5, 6, 7));
        int h = 2;
        int test = findLargestK(h, list1, list2, 0, list1.size() - 1, 0, list2.size() - 1);
        System.out.println("The " + h + "-largest element is: " + test + "\n  ********");
        for (int k = 1; k <= list1.size() + list2.size(); k++) {
            int result = findLargestK(k, list1, list2, 0, list1.size() - 1, 0, list2.size() - 1);
            System.out.println("The " + k + "-largest element is: " + result);
        }
    }

    /**
     * Find K-largest element in the searching range of union of 2 list
     * @param k
     * @param list1
     * @param list2
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    private static int findLargestK(int k, List<Integer> list1, List<Integer> list2, int start1, int end1, int start2, int end2) {
        // Stopping rule
        if (k == 1) {
            return list1.get(end1) > list2.get(end2) ? list1.get(end1) : list2.get(end2);
        }
        // when k >1
        if (end1 == start1) {
            return list2.get(end2 - (k - 1) + 1);
        }
        if (end2 == start2) {
            return list1.get(end1 - (k - 1) + 1);
        }


        // find the middle element index for list1
        int mid1 = (end1 + start1) % 2 == 0 ? (end1 + start1) / 2 : (end1 + start1) / 2 + 1;
        // find the middle element index for list 2
        int mid2 = (end2 + start2) % 2 == 0 ? (end2 + start2) / 2 : (end2 + start2) / 2 + 1;
        // find the number of element from middle to the end of each list
        int num1 = end1 - mid1 + 1;
        int num2 = end2 - mid2 + 1;

        // if the total number of elements in the right side of 2 lists is smaller than K, we need to extend
        // the range to search by moving the pivot index to the left
        if (num1 + num2 < k) {
            // in this case, certainly the element in the right side of list 1 belong to the set of elements which
            // are greater then k-largest, therefore we remove these elements from the searching range, the number k
            // is reduced
            if (list1.get(mid1) > list2.get(mid2)) {
                // the new end of list 1 is mid1 -1 because we remove these elements in the right side of list 1
                // from the searching range
                return findLargestK(k - num1, list1, list2, start1, mid1 - 1, start2, end2);
            } else {
                // the new end of list 2 is mid2 -1 because we remove these elements in the right side of list 2
                // from the searching range
                return findLargestK(k - num2, list1, list2, start1, end1, start2, mid2 - 1);

            }
        }
        // if the total number of elements in the right side of 2 lists is greater than K, we need to reduce
        // the searching range  by moving the pivot index to the right
        else {
            // in this case, certainly the element in the left side of list 2 don't belong to the set of elements which
            // are greater then k-largest, therefore we remove these elements from the searching range, the number k remains
            if (list1.get(mid1) > list2.get(mid2)) {
                // the new start of list 2 is mid2 because we remove these elements in the left side of list 2
                // from the searching range
                return findLargestK(k, list1, list2, start1, end1, mid2, end2);
            } else {
                // the new start of list 1 is mid1 because we remove these elements in the left side of list 2
                // from the searching range
                return findLargestK(k, list1, list2, mid1, end1, start2, end2);
            }
        }

    }

}
