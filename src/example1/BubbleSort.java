package example1;

import java.util.List;

/**
 * Bubble Sort
 *
 * @author tadaki
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> {

    final private List<T> list;

    public BubbleSort(List<T> list) {
        this.list = list;
    }

    /**
     * entry for sorting
     *
     * @return sorted list
     */
    public List<T> sort() {







        return list;
    }

    /**
     * Swap i-th and j-th elements in the list
     * @param i
     * @param j 
     */
    private void swap(int i, int j) {

        
        
    }


    /**
     * True if i-th element is less than j-th one
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {


		return true;//you have to change this line
    }

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
