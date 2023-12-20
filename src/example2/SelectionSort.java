package example2;

import java.util.List;

/**
 * Bubble Sort
 *
 * @author tadaki
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> {

    public SelectionSort(List<T> list) {
        super(list);
    }

    /**
     * entry for sorting
     *
     * @return sorted list
     */
    @Override
    public List<T> sort() {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int m = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(m)) < 0) {
                    m = j;
                }
            }
            if (!(m == i)) {
                swap(i, m);
            }
        }
        return list;
    }

}
