package example1;

/**
 * 整列対象となるクラス
 *
 * @author tadaki
 */
public class Student implements Comparable<Student> {

    final String name;//名前
    final int id;//番号
    private int record;

    public Student(String name, int id, int record) {
        this.name = name;
        this.id = id;
        this.record = record;
    }

    /**
     * 比較
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
     * インスタンスを文字列化
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(id) + ":"
                + name + ":" + String.valueOf(record);
    }

}
