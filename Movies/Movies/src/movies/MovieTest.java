package movies;

/**
 *
 * @author aryan1798
 * Jan 18
 */
public class MovieTest {
    public static void main(String[] args) {
     Movies batman = new Movies("Keaton", "Michelle", 1000, 1.0, "PG-13");
     Movies starWars = new Movies();
     
     double stars[] = new double[5];
     
     System.out.println(batman.getLeading_man());
     
     batman.setLeading_man("Dean Bushey");
     
     System.out.println(batman.getLeading_man());
     
     
     batman.setStars(-0.1);
     starWars.setStars(4.5);
     
     
     stars[0] = batman.getStars();
     stars[1] = starWars.getStars();
    }
}
