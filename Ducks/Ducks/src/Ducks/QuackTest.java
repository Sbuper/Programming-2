package Ducks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author aryan1798
 */
public class QuackTest {
    public static void main(String[] args) {
        Quack Duck1 = new Quack("Huey");
        Quack Duck2 = new Quack("Louie");
        Quack Duck3 = new Quack("Douey");
        Quack Duck4 = new Quack("Donald");
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(Duck1);
        executorService.execute(Duck2);
        executorService.execute(Duck3);
        executorService.execute(Duck4);
        
        executorService.shutdown();
    }
}
