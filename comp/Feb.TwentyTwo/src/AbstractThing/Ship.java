package AbstractThing;

/**
 *
 * @author aryan1798
 */
public abstract class Ship {
    private String name;
    private int speed;
    
    public Ship() {
        name = "undefined";
        speed = 0;
    }
    
    public void speedUp(){
        speed += 5;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public abstract void tootHorn();
    
    
}
