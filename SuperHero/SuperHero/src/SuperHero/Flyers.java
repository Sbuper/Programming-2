package SuperHero;

import javax.swing.JOptionPane;

/**
 *
 * @author aryan1798
 */

public class Flyers extends SuperHero{
    private int altitude;
    
    public Flyers(){

        System.out.println("In the flyer constructor");
        
        altitude = 0;
    }
    
    public void sayHello() {
        super.sayHello();
        System.out.println("In the Flyer Class");
        JOptionPane.showMessageDialog(null, "Bawk Super Chicken");
    }
    
    
}
