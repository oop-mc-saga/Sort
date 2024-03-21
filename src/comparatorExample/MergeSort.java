package comparatorExample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * MergeSort: implementation with Comparator
 *
 * @author tadaki
 * @param <T>
 */
public class MergeSort<T> {

    final private List<T> list;
    final private Comparator<T> comparator;

    /**
     * 
     * @param list the target list to be sorted
     * @param comparator defining how to compare two instances
     */
    public MergeSort(List<T> list, Comparator<T> comparator) {
        this.list = list;
        this.comparator = comparator;
    }

    /**
     * Start sorting
     *
     * @return sorted list
     */
    public List<T> sort() {
        sortSub(0, list.size());
        return list;
    }

    /**
     * recursive sort algorithm
     *
     * @param left left-most index of target list
     * @param right right-most index of target list plus 1
     */
    private void sortSub(int left, int right) {
        if (right <= left) {
            throw new IllegalArgumentException("illegal range");
        }
        if (right > left + 1) {
            int middle = (right + left) / 2;
            //recursive call
            sortSub(left, middle);
            sortSub(middle, right);
            //merge two sorted list
            mergeList(left, middle, right);
        }
    }

    /**
     * merge two sorted list
     *
     * @param left left-most index
     * @param middle start index of right part
     * @param right right-most index ＋１
     * @return
     */
    private void mergeList(int left, int middle, int right) {
        List<T> tmp = new ArrayList<>();
        int leftIndex = left;
        int rightIndex = middle;
        //repeat until end of both lists 
        while (leftIndex < middle && rightIndex < right) {
            if (less(leftIndex, rightIndex)) {//head of left < head of right
                tmp.add(list.get(leftIndex));
                leftIndex++;
            } else {
                tmp.add(list.get(rightIndex));
                rightIndex++;
            }
        }
        if (leftIndex >= middle) {//left list completed
            for (int k = rightIndex; k < right; k++) {
                tmp.add(list.get(k));
            }
        }
        if (rightIndex >= right) {//right list completed
            for (int k = leftIndex; k < middle; k++) {
                tmp.add(list.get(k));
            }
        }
        //copy tmpList into list
        for (int p = 0; p < tmp.size(); p++) {
            list.set(left + p, tmp.get(p));
        }
    }

    /**
     * True if i-th element is less than j-th one
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return (comparator.compare(list.get(i), list.get(j)) < 0);
    }

    /**
     * Confirm the target is sorted
     *
     * @return true if sorted
     */
    public boolean isSorted() {
        boolean b = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (!less(i, i + 1)) {
                return false;
            }
        }
        return b;
    }
}
