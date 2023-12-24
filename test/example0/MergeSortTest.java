package example0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author tadaki
 */
public class MergeSortTest {
    private final List<Student> studentList;
    private final List<Student> sortedList;
    public MergeSortTest() {
        Student[] data = {
            new Student("Tom", 0, 88),
            new Student("Jane", 1, 80),
            new Student("Ray", 2, 70),
            new Student("Kim", 3, 75),
            new Student("Jeff", 4, 85),
            new Student("Ann", 5, 78),
            new Student("Beth", 6, 90)
        };
        studentList = Arrays.asList(data);
        sortedList = new ArrayList<>();
        sortedList.add(studentList.get(2));
        sortedList.add(studentList.get(3));
        sortedList.add(studentList.get(5));
        sortedList.add(studentList.get(1));
        sortedList.add(studentList.get(4));
        sortedList.add(studentList.get(0));
        sortedList.add(studentList.get(6));
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sort method, of class MergeSort.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        MergeSort instance = new MergeSort(studentList);
        List<Student> expResult = sortedList;
        List<Student> result = instance.sort();
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isSorted method, of class MergeSort.
     */
    @Test
    public void testIsSorted() {
        System.out.println("isSorted");
        MergeSort instance = new MergeSort(studentList);
        List<Student> resultList = instance.sort();
        boolean expResult = true;
        boolean result = instance.isSorted();
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
