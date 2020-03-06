package example2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * MergeSort
 *
 * @author tadaki
 * @param <T>
 */
public class MergeSortWithQueue<T extends Comparable<T>> extends AbstractSort<T> {

    public MergeSortWithQueue(List<T> list) {
        super(list);
    }

    @Override
    public List<T> sort() {
        Queue<List<T>> queue = new ConcurrentLinkedQueue<>();
        //全ての要素をリストにして待ち行列へ
        for (T t : list) {
            List<T> tt = new ArrayList<>();
            tt.add(t);
            queue.add(tt);
        }
        //二つ毎にマージ
        while (queue.size() > 1) {
            mergeListWithStack(queue);
        }
        List<T> output = queue.poll();
        for (int i = 0; i < output.size(); i++) {
            list.set(i, output.get(i));
        }
        return list;
    }

    protected void mergeListWithStack(Queue<List<T>> queue) {
        List<T> t1 = queue.poll();
        List<T> t2 = queue.poll();
        queue.add(mergeList(t1, t2));
    }

    /**
     * 二つのリストのmerge
     *
     * @param a
     * @param b
     * @return
     */
    protected List<T> mergeList(List<T> a, List<T> b) {
        List<T> c = new ArrayList<>();
        while ((!a.isEmpty()) || (!b.isEmpty())) {
            int k = checkEmptyness(a, b);
            switch (k) {
                case 3://(!a.isEmpty()) && (!b.isEmpty())
                    if (a.get(0).compareTo(b.get(0)) < 0) {
                        c.add(a.remove(0));
                    } else {
                        c.add(b.remove(0));
                    }
                    break;
                case 2://(!a.isEmpty()) && (b.isEmpty())
                    c.addAll(a);
                    return c;
                case 1://(a.isEmpty()) && (!b.isEmpty())
                    c.addAll(b);
                    return c;
                default:
            }
        }
        return c;
    }

    /**
     * 二つのリストが空であるか否かを確認
     *
     * @param <T>
     * @param a
     * @param b
     * @return 0:両方が空、 1:aは空、bは空でない、2:aは空でない、bは空、
     *
     * 3:両方が空でない
     */
    private int checkEmptyness(List<T> a, List<T> b) {
        int k = 0;
        if (!a.isEmpty()) {
            k += 2;
        }
        if (!b.isEmpty()) {
            k += 1;
        }
        return k;
    }

}
