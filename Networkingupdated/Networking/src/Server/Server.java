package Server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.SwingUtilities;

public class Server 
{

   private ObjectOutputStream output; // output stream to client
   private ObjectInputStream input; // input stream from client
   private ServerSocket server; // server socket
   private Socket connection; // connection to client
   private int counter = 1; // counter of number of connections



   // set up and run server 
   public void runServer()
   {
      try // set up server to receive connections; process connections
      {
         server = new ServerSocket(19); // create ServerSocket

         while (true) 
         {
            try 
            {
               waitForConnection(); // wait for a connection
               getStreams(); // get input & output streams
               processConnection(); // process connection
            } 
            catch (EOFException eofException) 
            {
               displayMessage("\nServer terminated connection");
            } 
            finally 
            {
               closeConnection(); //  close connection
               ++counter;
            } 
         } 
      } 
      catch (IOException ioException) 
      {
         ioException.printStackTrace();
      } 
   }

   // wait for connection to arrive, then display connection info
   private void waitForConnection() throws IOException
   {
      displayMessage("Waiting for connection\n");
      connection = server.accept(); // allow server to accept connection            
      displayMessage("Connection " + counter + " received from: " + connection.getInetAddress().getHostName());
   }

   // get streams to send and receive data
   private void getStreams() throws IOException
   {
      // set up output stream for objects
      output = new ObjectOutputStream(connection.getOutputStream());
      output.flush(); // flush output buffer to send header information

      // set up input stream for objects
      input = new ObjectInputStream(connection.getInputStream());

      displayMessage("\nGot I/O streams\n");
   }

   // process connection with client
   private void processConnection() throws IOException
   {
      String message = "Welcome to the Bushey Server...";
      String response = "";
      sendData(message); // send connection successful message


      do // process messages sent from client
      { 
         try // read message and display it
         {
            message = (String) input.readObject(); // read new message
            displayMessage("\n" + message); // display message
            
            response = message.substring(9).toUpperCase()+ "Cubs win";
            sendData(response);
           
         } 
         catch (ClassNotFoundException classNotFoundException) 
         {
            displayMessage("\nUnknown object type received");
         } 

      } while (!message.equals("CLIENT>>> TERMINATE"));
   }

   // close streams and socket
   private void closeConnection() 
   {
      displayMessage("\nTerminating connection\n");

      try 
      {
         output.close(); // close output stream
         input.close(); // close input stream
         connection.close(); // close socket
      } 
      catch (IOException ioException) 
      {
         ioException.printStackTrace();
      } 
   }

   // send message to client
   private void sendData(String message)
   {
      try // send object to client
      {
         output.writeObject("SERVER>>> " +message.toUpperCase() );
         output.flush(); // flush output to client
         displayMessage("\nSERVER>>> " + message.toUpperCase());
      } 
      catch (IOException ioException) 
      {
         System.out.println("\nError writing object");
      } 
   }

   // manipulates displayArea in the event-dispatch thread
   private void displayMessage(final String messageToDisplay)
   {
      SwingUtilities.invokeLater(
         new Runnable() 
         {
            public void run() // updates displayArea
            {

                System.out.println(messageToDisplay); // append message               
//                System.out.println("Merry Christmas\n");
            } 
         } 
      ); 
   } 


} 