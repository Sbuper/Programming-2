/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author aryan1798
 */

public class Client extends JFrame{
    private JTextField enterField;
    private JTextArea enterArea;
    private String serveraddress;
    private String message;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket client;
    private String myMessage;

    public Client(String host){
    serveraddress = host;
}
    
    public void runClient() {
        try
        {
            connectToServer();
            getStreams();
            processConnection();
        } catch(EOFException eofException) {
            System.out.println("\nClient terminated connection");
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    
    public void connectToServer() throws IOException {
      System.out.println("Connecting to " + serveraddress);
      Socket client = new Socket("192.168.0.1", 19);
      System.out.println("I connected to " + serveraddress);
    }
    
    public void getStreams() throws IOException {
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        
        input = new ObjectInputStream(client.getInputStream());
        System.out.println("I got the streams");
    }
    
    public void processConnection() {
        String myMessage;
        do 
        {
            try 
            {
                myMessage = JOptionPane.showInputDialog("Message for server?");
                output.writeObject(myMessage);
                output.flush();
                System.out.println("I said" +myMessage);
                message = (String) input.readObject();
            } catch (ClassNotFoundException classNotFoundException) {
                System.out.println("\nUnkown object type recieved");
            }catch (IOException ioException) {
            }
        }
        while(!message.equals("SERVER>>> TERMINATE"));
    }
    
    public void closeConnection() {
        try {
            output.close();
            input.close();
            client.close();
        } catch (IOException ioException) {
        }
    }
}
