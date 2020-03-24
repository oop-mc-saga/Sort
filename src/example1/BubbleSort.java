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

    /**
     * リストのi番目の要素とj番目の要素を入れ替える
     * @param i
     * @param j 
     */
    private void swap(int i, int j) {

        
        
    }

    /**
     * リストのi番目の要素がj番目の要素より小さければ真
     * @param i
     * @param j
     * @return 
     */
    private boolean less(int i, int j) {



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
