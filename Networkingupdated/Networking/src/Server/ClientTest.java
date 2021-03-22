/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author aryan1798
 */
public class ClientTest {
    public static void main(String[] args) {
        Client application;
        
        application = new Client("207.0.0.1");
        
        application.runClient();
    }
}
