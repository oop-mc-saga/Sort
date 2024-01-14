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
    
}
