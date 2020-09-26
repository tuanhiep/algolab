package excitement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSelection {

    public static void main(String[] args) {

        System.out.println("TEST CASE 1");
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(5, 6, 7));
        printList(list1, 1);
        printList(list2, 2);
        for (int k = 1; k <= list1.size() + list2.size(); k++) {
            int result = findLargestK(k, list1, list2, 0, list1.size() - 1, 0, list2.size() - 1);
            System.out.println("The " + k + "-largest element is: " + result);
        }

        System.out.println("TEST CASE 2");
        list1 = new ArrayList<Integer>(Arrays.asList(5, 6, 7));
        list2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        printList(list1, 1);
        printList(list2, 2);
        for (int k = 1; k <= list1.size() + list2.size(); k++) {
            int result = findLargestK(k, list1, list2, 0, list1.size() - 1, 0, list2.size() - 1);
            System.out.println("The " + k + "-largest element is: " + result);
        }
        // When list 1 contains only 1 element
        System.out.println("TEST EDGE CASE 1");
        list1 = new ArrayList<Integer>(Arrays.asList(4));
        list2 = new ArrayList<Integer>(Arrays.asList(2, 6, 7));
        printList(list1, 1);
        printList(list2, 2);
        for (int k = 1; k <= list1.size() + list2.size(); k++) {
            int result = findLargestK(k, list1, list2, 0, list1.size() - 1, 0, list2.size() - 1);
            System.out.println("The " + k + "-largest element is: " + result);
        }
        // When list 2 contains only 1 element
        System.out.println("TEST EDGE CASE 2");
        list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 7, 8));
        list2 = new ArrayList<Integer>(Arrays.asList(5));
        printList(list1, 1);
        printList(list2, 2);
        for (int k = 1; k <= list1.size() + list2.size(); k++) {
            int result = findLargestK(k, list1, list2, 0, list1.size() - 1, 0, list2.size() - 1);
            System.out.println("The " + k + "-largest element is: " + result);
        }
    }

    private static void printList(List<Integer> list1, int index) {
        System.out.print("List " + index + " : ");
        for (int i : list1) {
            System.out.print(i + ", ");
        }
        System.out.println("");
    }

    /**
     * Find K-largest element in the searching range of union of 2 list
     * Time complexity O(logM+logN)
     * @param k
     * @param list1
     * @param list2
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return K-largest element
     */
    private static int findLargestK(int k, List<Integer> list1, List<Integer> list2, int start1, int end1, int start2, int end2) {
        // Stopping rule
        if (k == 1) {
            return list1.get(end1) > list2.get(end2) ? list1.get(end1) : list2.get(end2);
        }
        // find the middle element index for list1
        int mid1 = (end1 + start1 + 1) / 2;
        // find the middle element index for list 2
        int mid2 = (end2 + start2 + 1) / 2;
        // find the number of element from middle to the end of each list
        int num1 = end1 - mid1 + 1;
        int num2 = end2 - mid2 + 1;

        // when k >1
        if (end1 == start1 && end2 == start2 && k == 2) {
            return list1.get(end1) < list2.get(end2) ? list1.get(end1) : list2.get(end2);
        }
        if (end1 == start1) {
            if (num1 + num2 <= k) {
                if (list1.get(mid1) < list2.get(mid2)) {
                    // certainly the right side of list 2 is out of searching range
                    return findLargestK(k - num2, list1, list2, start1, end1, start2, mid2 - 1);
                } else {
                    return list1.get(mid1) < list2.get(end2 - (k - 1) + 1) ? list1.get(mid1) : list2.get(end2 - (k - 1) + 1);
                }
            } else {
                // certainly the left side of list 2 is out of searching range
                return findLargestK(k, list1, list2, start1, end1, mid2, end2);
            }

        }
        if (end2 == start2) {

            if (num1 + num2 <= k) {
                if (list2.get(mid2) < list1.get(mid1)) {
                    // certainly the right side of list 1 is out of searching range
                    return findLargestK(k - num1, list1, list2, start1, mid1 - 1, start2, end2);
                } else {
                    return list2.get(mid2) < list1.get(end1 - (k - 1) + 1) ? list2.get(mid2) : list1.get(end1 - (k - 1) + 1);
                }
            } else {
                // certainly the left side of list 1 is out of searching range
                return findLargestK(k, list1, list2, mid1, end1, start2, end2);
            }

        }

        if (num1 + num2 <= k) {
            // We remove the right side of list 1 because they belong to the set of elements which
            // are greater then k-largest, the number k is reduced
            if (list1.get(mid1) > list2.get(mid2)) {
                // the new end of list 1 is mid1 -1 because we remove the right side of list 1
                return findLargestK(k - num1, list1, list2, start1, mid1 - 1, start2, end2);
            } else {
                // the new end of list 2 is mid2 -1 because we remove  the right side of list 2
                return findLargestK(k - num2, list1, list2, start1, end1, start2, mid2 - 1);
            }
        } else {
            if (list1.get(mid1) > list2.get(mid2)) {
                // the new start of list 2 is mid2 because we remove  the left side of list 2
                return findLargestK(k, list1, list2, start1, end1, mid2, end2);
            } else {
                // the new start of list 1 is mid1 because we remove the left side of list 1
                return findLargestK(k, list1, list2, mid1, end1, start2, end2);
            }
        }

    }

}
