package example2;

import java.util.List;

/**
 * MergeSort
 *
 * @author tadaki
 * @param <T>
 */
public class BubbleSort<T extends Comparable> extends AbstractSort<T>{

    public BubbleSort(List<T> list) {
        super(list);
    }

    /**
     * 整列の実行
     *
     * @return 整列済みのリスト
     */
    @Override
    public List<T> sort() {
        int n = list.size();
        for (int i = n - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (!less(j, j + 1)) {
                    swap(j, j + 1);
                }
            }
        }
        return list;
    }



}
