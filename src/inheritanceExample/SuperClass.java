package inheritanceExample;

/**
 * Simple super class
 * 
 * @author tadaki
 */
public abstract class SuperClass {

    private int a = 1;
    protected final int b;

    public SuperClass(int b) {
        this.b = b;
    }

    public int getValue() {
        return a * b;
    }

    abstract String getResult();

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

}
