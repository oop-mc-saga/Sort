package example2;

import java.util.List;

/**
 *
 * @author tadaki
 * @param <T>
 */
public abstract class AbstractSort<T extends Comparable> {

    protected final List<T> list;

    public AbstractSort(List<T> list) {
        this.list = list;
    }

    /**
     * 整列の実行
     *
     * @return 整列済みのリスト
     */
    public abstract List<T> sort();

    protected boolean less(int i, int j) {
        return list.get(i).compareTo(list.get(j)) < 0;
    }

    protected void swap(int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
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
