package example2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * MergeSort
 *
 * @author tadaki
 * @param <T>
 */
public class MergeSortWithList<T extends Comparable<T>> extends AbstractSort<T> {

    public MergeSortWithList(List<T> list) {
        super(list);
    }

    @Override
    public List<T> sort() {
        List<List<T>> superList = Collections.synchronizedList(new ArrayList<>());
        //全ての要素をリストにして待ち行列へ
        for (T t : list) {
            List<T> tt = new ArrayList<>();
            tt.add(t);
            superList.add(tt);
        }
        //二つ毎にマージ
        while (superList.size() > 1) {
            superList=mergeListWithList(superList);
            System.out.println(superList.size());
        }
        List<T> output = superList.get(0);
        System.out.println(output.size());
        for (int i = 0; i < output.size(); i++) {
            list.set(i, output.get(i));
        }
        return list;
    }

    protected List<List<T>> mergeListWithList(List<List<T>> input) {        
        List<List<T>> output = Collections.synchronizedList(new ArrayList<>());
        int r = input.size()%2;
        int length = input.size()-r;
        for(int i=0;i<length-1;i+=2){
        List<T> t1 = input.get(i);
        List<T> t2 = input.get(i+1);
            List<T> merged = mergeList(t1, t2);
            output.add(merged);
        }
        if(r==1){
            output.add(input.get(length));
        }
        return output;
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
