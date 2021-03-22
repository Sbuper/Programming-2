package SuperHero;

import javax.swing.JOptionPane;

/**
 *
 * @author aryan1798
 */
public class SuperHero {
    private String name;
    private String power;
    
    public SuperHero(){
        System.out.println("in no arg superclass");
        power = "Bald head";
        name = "Donald Trump";
    }
    public SuperHero(String theName) {
        System.out.println("In the super constructor");
        name = theName;
        power = "Invisibility";
        
    }
    
    public void sayHello() {
        System.out.println("In the Super Class");
        JOptionPane.showMessageDialog(null, "I'm a super hero.");
    }

    public String getName() {
        return name;
    }

    public String getPower() {
        return power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(String power) {
        this.power = power;
    }
    
    
}
