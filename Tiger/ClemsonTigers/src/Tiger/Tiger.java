package Tiger;

/**
 *
 * @author aryan1798 date Jan 11, 2017
 */
public class Tiger {

    private int age;
    private int weight;
    private String name;

    public Tiger() {
        age = 19;
        weight = 500;
        name = "Clemson";
    }

    public void speak() {
        if (age > 20) {
            System.out.println("Roar!");
        } else {
            System.out.println("Meow..");
        }
    }

    public void ageCat() {
        age++;
    }
}
