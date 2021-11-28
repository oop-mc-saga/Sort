package example0;

import java.util.ArrayList;
import java.util.List;

/**
 * MergeSortの基本的実装
 *
 * @author tadaki
 */
public class MergeSort {

    final private List<Student> list;

    public MergeSort(List<Student> list) {
        this.list = list;
    }

    /**
     * 整列の実行
     *
     * @return 整列済みのリスト
     */
    public List<Student> sort() {
        sortSub(0, list.size());
        return list;
    }

    /**
     * 再帰的整列
     *
     * @param left リストの整列対象のうち左端のインデクス
     * @param right リストの整列対象のうち右端のインデクス＋１
     */
    private void sortSub(int left, int right) {
        if (right <= left) {
            throw new IllegalArgumentException("illegal range");
        }
        if (right > left + 1) {
            int middle = (right + left) / 2;
            //再帰呼び出し
            sortSub(left, middle);
            sortSub(middle, right);
            //リストの結合
            mergeList(left, middle, right);
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
    private void mergeList(int left, int middle, int right) {
        List<Student> tmp = new ArrayList<>();
        int leftIndex = left;
        int rightIndex = middle;
        //左右両方のリストが終了するまで繰り返す
        while (leftIndex < middle || rightIndex < right) {
            if (leftIndex >= middle) {//左側終了
                for (int k = rightIndex; k < right; k++) {
                    tmp.add(list.get(k));
                }
                break;
            }
            if (rightIndex >= right) {//右側終了
                for (int k = leftIndex; k < middle; k++) {
                    tmp.add(list.get(k));
                }
                break;
            }
            if (less(leftIndex, rightIndex)) {//左先頭<右先頭
                tmp.add(list.get(leftIndex));
                leftIndex++;
            } else {
                tmp.add(list.get(rightIndex));
                rightIndex++;
            }
        }
        //tmpListからlistへの上書き
        for (int p = 0; p < tmp.size(); p++) {
            list.set(left + p, tmp.get(p));
        }
    }

    /**
     * リストのi番の要素がj番の要素より小さい場合に真
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return (list.get(i).getRecord() < list.get(j).getRecord());
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
