import java.io.IOException; 
import java.net.*;
import java.util.*; 
import java.io.*;
import java.util.concurrent.*;
  
public class Client
{ 
    public static void main(String[] args)throws IOException
    { 
        // Step 1:Create the socket object for 
        // carrying the data. 
        DatagramSocket ds = new DatagramSocket(); 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
  
        // loop while user not enters "bye" 
        while (true) 
        { 
            String inp = "Hello"; 
  
            // convert the String input into the byte array. 
            buf = inp.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, 1234); 
  
            // Step 3 : invoke the send call to actually send 
            // the data. 
            ds.send(DpSend); 
  
            // break the loop if user enters "bye" 
            if (inp.equals("bye")) 
                break; 
        } 
    } 
} 