package example0;

import java.util.Arrays;
import java.util.List;

/**
 * 基本となるMergeSortの例題
 *
 * @author tadaki
 */
public class Main0 {

    /**
     * @param args the command line arguments
     */
    static public void main(String args[]) {
        Student list[] = {
            new Student("Tom", 1, 88),
            new Student("Jane", 2, 80),
            new Student("Ray", 3, 70),
            new Student("Kim", 4, 75),
            new Student("Jeff", 5, 85),
            new Student("Ann", 6, 78),
            new Student("Beth", 7, 90)
        };
        MergeSort sort = new MergeSort(Arrays.asList(list));
        List<Student> output = sort.sort();
        if (sort.isSorted()) {//ソート済みならば結果を出力
            output.stream().forEachOrdered(s -> System.out.println(s));
        }
    }

}
