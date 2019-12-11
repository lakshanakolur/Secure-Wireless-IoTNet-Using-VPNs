import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;
import java.util.concurrent.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.*;

class Server
{
    public static void main(String[] args)throws IOException,InterruptedException
    {
        Hashtable<String,String> ipaddr = new Hashtable<String,String>();
        ipaddr.put("B1104B","192.168.31.150");
        // Step 1 : Create a socket to listen at port 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];

        Handler ch = new FileHandler("default.log", true);
        ch.setFormatter(new SimpleFormatter());
        Logger logger = Logger.getLogger("Secure IoT");
        logger.setUseParentHandlers(false);
        logger.addHandler(ch);

        FileWriter fw=new FileWriter("output.log",true);
        DatagramPacket DpReceive = null;
        int i = 0;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new gui().guiShow(ipaddr);
            }
        });

        while (true)
        {
            DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);
            logger.info(data(receive).toString());
            receive = new byte[65535];
            if(LocalTime.now().isAfter(LocalTime.parse("17:00")))
            {
                DatagramSocket ds1 = new DatagramSocket();
                byte buf[] = "LOCK".getBytes();
                for (String key : ipaddr.keySet())
                {
                    DatagramPacket DpSend = new DatagramPacket(buf, buf.length, InetAddress.getByName(ipaddr.get(key)), 1234);
                    ds1.send(DpSend);
                }
            }
        }
    }

    // A utility method to convert the byte array
    // data into a string representation.
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
