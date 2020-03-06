package example2;

import java.util.ArrayList;
import java.util.List;

/**
 * MergeSort
 *
 * @author tadaki
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {


    public MergeSort(List<T> list) {
        super(list);
    }

    /**
     * 整列の実行
     *
     * @return 整列済みのリスト
     */
    @Override
    public List<T> sort() {
        sortSub(0, list.size());
        return list;
    }

    /**
     * 再帰的整列
     *
     * @param left リストの整列対象のうち左端のインデクス
     * @param right リストの整列対象のうち右端のインデクス＋１
     */
    protected void sortSub(int left, int right) {
        if (right <= left) {
            throw new IllegalArgumentException("illegal range");
        }
        if (right == left + 1) {
            return;
        }
        int middle = (right + left) / 2;
        //再帰呼び出し
        sortSub(left, middle);
        sortSub(middle, right);
        //リストの結合
        List<T> tmpList = mergeList(left, middle, right);
        for (int p = 0; p < tmpList.size(); p++) {
            list.set(left + p, tmpList.get(p));
        }
    }

    /**
     * リストの結合
     *
     * @param left 左端
     * @param middle 右側要素の先頭
     * @param right 右側要素の終端＋１
     * @return
     */
    protected List<T> mergeList(int left, int middle, int right) {
        List<T> tmp = new ArrayList<>();
        int leftIndex = left;
        int rightIndex = middle;
        while (leftIndex < middle || rightIndex < right) {
            if (leftIndex >= middle) {//左側終了
                for (int k = rightIndex; k < right; k++) {
                    tmp.add(list.get(k));
                }
                return tmp;
            }
            if (rightIndex >= right) {//右側終了
                for (int k = leftIndex; k < middle; k++) {
                    tmp.add(list.get(k));
                }
                return tmp;
            }
            if (less(leftIndex, rightIndex)) {
                tmp.add(list.get(leftIndex));
                leftIndex++;
            } else {
                tmp.add(list.get(rightIndex));
                rightIndex++;
            }
        }
        return tmp;
    }


}
