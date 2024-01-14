package inheritanceExample;

/**
 *
 * @author tadaki
 */
public class SubClassA extends SuperClass{

    public SubClassA(int b) {
        super(b);
    }

    @Override
    public String getResult() {
        return "A";
    }
    
    @Override
    public int getValue() {
        return super.getA() * b * b;
    }
}
