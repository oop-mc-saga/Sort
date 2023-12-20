package exercise;

import java.util.List;

/**
 *
 * @author tadaki
 */
public abstract class AbstractSort<T extends Comparable<T>> {
    
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

    /**
     * リストのi番の要素がj番の要素より小さい場合に真
     *
     * @param i
     * @param j
     * @return
     */
    protected boolean less(int i, int j) {
        return list.get(i).compareTo(list.get(j)) < 0;
    }

    /**
     * リストが整列済みかを判定
     *
     * @return 整列済みならばtrue
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
