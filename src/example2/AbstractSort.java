package example2;

import java.util.List;

/**
 *
 * @author tadaki
 * @param <T>
 */
public abstract class AbstractSort<T extends Comparable<T>> {

    protected final List<T> list;

    public AbstractSort(List<T> list) {
        this.list = list;
    }

    abstract public List<T> sort();

    /**
     * True if i-th element is less than j-th one
     *
     * @param i
     * @param j
     * @return
     */
    protected boolean less(int i, int j) {
        return list.get(i).compareTo(list.get(j)) < 0;
    }

    /**
     * Swap i-th and j-th elements in the list
     *
     * @param i
     * @param j
     */
    protected void swap(int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
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
