package inheritanceExample;

/**
 *
 * @author tadaki
 */
public class SubClassB extends SuperClass {

    public SubClassB(int b) {
        super(b);
    }

    @Override
    public String getResult() {
        return "B";
    }

    @Override
    public int getValue() {
        return -super.getA() * b * b;
    }

}
