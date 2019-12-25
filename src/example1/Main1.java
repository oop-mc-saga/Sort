package example1;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tadaki
 */
public class Main1 {

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
//        BubbleSort<Student> sort = new BubbleSort<>(Arrays.asList(list));
        MergeSort<Student> sort = new MergeSort<>(Arrays.asList(list));
        List<Student> output = sort.sort();
        if (sort.isSorted()) {
            output.stream().forEachOrdered(s -> System.out.println(s));
        }
    }
}
