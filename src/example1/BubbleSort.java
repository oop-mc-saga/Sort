package example1;

import java.util.List;

/**
 * MergeSort
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
     * 整列の実行
     *
     * @return 整列済みのリスト
     */
    public List<T> sort() {







        return list;
    }

    private void swap(int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    private boolean less(int i, int j) {
        return (list.get(i).compareTo(list.get(j)) < 0);
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
