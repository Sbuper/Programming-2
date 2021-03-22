package Tiger;

/**
 *
 * @author aryan1798
 */
public class TigerTest {

    public static void main(String[] args) {
        Tiger myTiger = new Tiger();
        for (int counter = 0; counter < 5; counter++) {

            myTiger.ageCat();
            myTiger.speak();
        }
    }
}
