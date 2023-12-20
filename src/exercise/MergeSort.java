package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * MergeSort
 *
 * @author tadaki
 * @param <T> class template for target
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

    public MergeSort(List<T> list) {
        super(list);
    }

    /**
     * entry for sorting
     *
     * @return sorted list
     */
    @Override
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
        if (right == left + 1) {//completed?
            return;
        }
        int middle = (right + left) / 2;
        //recursive call
        sortSub(left, middle);
        sortSub(middle, right);
        //merge two sorted list
        List<T> tmpList = mergeList(left, middle, right);
        ///copy tmpList into list
        for (int p = 0; p < tmpList.size(); p++) {
            list.set(left + p, tmpList.get(p));
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
    private List<T> mergeList(int left, int middle, int right) {
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
            return tmp;
        }
        if (rightIndex >= right) {//right list completed
            for (int k = leftIndex; k < middle; k++) {
                tmp.add(list.get(k));
            }
            return tmp;
        }
        return tmp;
    }

}
