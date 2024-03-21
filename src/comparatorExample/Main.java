package comparatorExample;

import example0.Student;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author tadaki
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static public void main(String args[]) {
        Student list[] = {
            new Student("Tom", 0, 88),
            new Student("Jane", 1, 80),
            new Student("Ray", 2, 70),
            new Student("Kim", 3, 75),
            new Student("Jeff", 4, 85),
            new Student("Ann", 5, 78),
            new Student("Beth", 6, 90)
        };
        Comparator<Student> comparator
                = (s1, s2) -> s1.getRecord() - s2.getRecord();
        MergeSort<Student> sort
                = new MergeSort<>(Arrays.asList(list), comparator);
        List<Student> output = sort.sort();
        if (sort.isSorted()) {//show sorted result
            output.stream().forEachOrdered(s -> System.out.println(s));
        }
    }

}
