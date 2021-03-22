package Ducks;

import com.sun.istack.internal.logging.Logger;
import java.util.Random;
import java.util.logging.Level;

/**
 *
 * @author aryan1798
 */
public class Quack implements Runnable {
    private String name;
    Random ranum = new Random();
    private int numquacks;
    private int sleeptime;
    
    public Quack(String Duck) {
        name = Duck;
        numquacks = ranum.nextInt(50);
        sleeptime = ranum.nextInt(3000);
    }
    
    public void run() {
        for(int i=0; i<numquacks; i++) {
            System.out.println("Quack Quack from duck " + name + " " + Thread.currentThread().getId());
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }

        }
    }
}
