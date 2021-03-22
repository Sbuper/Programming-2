package AbstractThing;

import javax.swing.JOptionPane;

/**
 *
 * @author aryan1798
 */
public class OceanLiner extends Ship {

    public OceanLiner() {
        super();
    }
    
    public void tootHorn(String babaBlackSheep) {
        JOptionPane.showMessageDialog(null, "Toot");
    }
    
    public void tootHorn() {
        System.out.println("Blue");
    }
    
}
