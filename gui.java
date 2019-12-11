import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException; 
import java.net.*;
import java.util.*; 
import java.io.*;
import java.util.concurrent.*;

class gui {
    public static void guiShow(Hashtable ipaddr) {
        try{
        DatagramSocket dserv = new DatagramSocket(1237);
        DatagramPacket DpReceive = null;
        //Creating the Frame
        JFrame frame = new JFrame("Under Lock and Key");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Room No");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton lock = new JButton("Lock");
        JButton off = new JButton("Power Off");
        JButton on = new JButton("Power On");
        JButton un = new JButton("Unlock");
        panel.add(label); // Components Added using Flow Layout
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(lock);
        panel.add(off);
        panel.add(on);
        panel.add(un);

        // Text Area at the Center
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea); 
        textArea.setEditable(false);
        lock.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //System.out.println(tf.getText());
                byte[] receive = new byte[65535];
                tf.selectAll();
                String ipadr = "";
                String resp = "";
                try
                {
                    DatagramSocket ds = new DatagramSocket();
                    InetAddress ip = InetAddress.getLocalHost();
                    byte buf[] = null; 
                    buf = "LOCK".getBytes();
                    ipadr = (String)ipaddr.get(tf.getText());
			System.out.println(tf.getText());
			if(!tf.getText().equals("B1104B"))
			{
				textArea.append("Invalid Input\n");
				return;
			}
                    tf.setText("");
                    DatagramPacket DpSend = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.31.236"), 1234);
                    ds.send(DpSend);
                    while(true)
                    {
                        System.out.println("123");
                        DatagramPacket DpReceive = new DatagramPacket(receive, receive.length); 
                        dserv.receive(DpReceive); 
                        resp = data(receive).toString();
                        System.out.println(resp);
                        textArea.append(resp);
			textArea.append(" - Lock\n");
                        if(resp.charAt(0)=='D' || resp.charAt(0)=='E')
                            break;
                    }
                }
                catch(IOException exp)
                {}
            }
        });

        off.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //System.out.println(tf.getText());
                byte[] receive = new byte[65535];
                tf.selectAll();
                String ipadr = "";
                String resp = "";
                try
                {
                    DatagramSocket ds = new DatagramSocket();
                    InetAddress ip = InetAddress.getLocalHost();
                    byte buf[] = null; 
                    buf = "SWITCH OFF".getBytes();
                    ipadr = (String)ipaddr.get(tf.getText());
System.out.println(tf.getText());
			if(!tf.getText().equals("B1104B"))
			{
				textArea.append("Invalid Input\n");
				return;
			}
                    tf.setText("");
                    DatagramPacket DpSend = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.31.236"), 1234);
                    ds.send(DpSend);
                    while(true)
                    {
                        System.out.println("123");
                        DatagramPacket DpReceive = new DatagramPacket(receive, receive.length); 
                        dserv.receive(DpReceive); 
                        resp = data(receive).toString();
                        System.out.println(resp);
                        textArea.append(resp);
			textArea.append("- Power Off\n");
                        if(resp.charAt(0)=='D' || resp.charAt(0)=='E')
                            break;
                    }
                }
                catch(IOException exp)
                {}
            }
        });


        on.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //System.out.println(tf.getText());
                byte[] receive = new byte[65535];
                tf.selectAll();
                String ipadr = "";
                String resp = "";
                try
                {
                    DatagramSocket ds = new DatagramSocket();
                    InetAddress ip = InetAddress.getLocalHost();
                    byte buf[] = null; 
                    buf = "POWER ON".getBytes();
                    ipadr = (String)ipaddr.get(tf.getText());
System.out.println(tf.getText());
			if(!tf.getText().equals("B1104B"))
			{
				textArea.append("Invalid Input\n");
				return;
			}
                    tf.setText("");
                    DatagramPacket DpSend = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.31.236"), 1234);
                    ds.send(DpSend);
                    while(true)
                    {
                        System.out.println("123");
                        DatagramPacket DpReceive = new DatagramPacket(receive, receive.length); 
                        dserv.receive(DpReceive); 
                        resp = data(receive).toString();
                        System.out.println(resp);
                        textArea.append(resp);
			textArea.append("- Power On\n");
                        if(resp.charAt(0)=='D' || resp.charAt(0)=='E')
                            break;
                    }
                }
                catch(IOException exp)
                {}
            }
        });

        un.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //System.out.println(tf.getText());
                byte[] receive = new byte[65535];
                tf.selectAll();
                String ipadr = "";
                String resp = "";
                try
                {
                    DatagramSocket ds = new DatagramSocket();
                    InetAddress ip = InetAddress.getLocalHost();
                    byte buf[] = null; 
                    buf = "UNLOCK".getBytes();
                    ipadr = (String)ipaddr.get(tf.getText());
System.out.println(tf.getText());
			if(!tf.getText().equals("B1104B"))
			{
				textArea.append("Invalid Input\n");
				return;
			}
                    tf.setText("");
                    DatagramPacket DpSend = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.31.236"), 1234);
                    ds.send(DpSend);
                    while(true)
                    {
                        System.out.println("123");
                        DatagramPacket DpReceive = new DatagramPacket(receive, receive.length); 
                        dserv.receive(DpReceive); 
                        resp = data(receive).toString();
                        System.out.println(resp);
                        textArea.append(resp);
			textArea.append(" - Unlock\n");
                        if(resp.charAt(0)=='D' || resp.charAt(0)=='E')
                            break;
                    }
                }
                catch(IOException exp)
                {}
            }
        });

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        //frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.add(textArea);
        //frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
        }
        catch(IOException e)
        {}
    }
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