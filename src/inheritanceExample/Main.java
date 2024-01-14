package inheritanceExample;
/**
 *
 * @author tadaki
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SuperClass a = new SubClassA(2);
        SubClassB b = new SubClassB(3);
        
        System.out.println("A:"+a.getResult()+" B:"+b.getResult());
        System.out.println("A:"+ a.getValue()+" B:"+b.getValue());
    }
    
}
