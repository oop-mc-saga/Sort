package example1;

/**
 * target class for sorting
 *
 * @author tadaki
 */
public class Student implements Comparable<Student> {

    final String name;
    final int id;
    private int record;

    public Student(String name, int id, int record) {
        this.name = name;
        this.id = id;
        this.record = record;
    }

    /**
     * compare
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
        int k = record - o.record;
        if (k == 0) {
            return id - o.id;
        }
        return k;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    /**
     * convert instance to string
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(id) + ":"
                + name + ":" + String.valueOf(record);
    }

}
