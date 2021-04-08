import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
//import java.awt.event.EventListener;

class Chatclient extends JFrame
{
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	
	public static void main(String args[])
	{
		Chatclient client = new Chatclient();
		client.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame("Client ");
		JPanel mainpanel = new JPanel();
		Button sendButton = new Button();
		incoming=new JTextArea(15,50);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qscoller = new JScrollPane(incoming);
		qscoller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qscoller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		outgoing= new JTextField(20);
		
		//sendButton.addActionListener();
		
		mainpanel.add(qscoller);
		mainpanel.add(outgoing);
		mainpanel.add(sendButton);
		setUpNetworking();
		
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		
		frame.getContentPane().add(BorderLayout.CENTER, mainpanel);
		frame.setSize(400,500);
		frame.setVisible(true);
	}
	private void setUpNetworking()
	{
			try
			{
				sock = new Socket("127.0.0.1",5000);
				InputStreamReader streamReader= new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(streamReader);
				writer = new PrintWriter(sock.getOutputStream());
				System.out.println("networking established");
			}
			catch(IOException ex)
			{
					ex.printStackTrace();
			}
	}
	
	public class SendButtonListner implements ActionListener
	{
			public void actionPerformed(ActionEvent ev)
			{
				try{
						writer.println(outgoing.getText());
						writer.flush();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			outgoing.setText(" ");
			outgoing.requestFocus();
			}
	}
	public class IncomingReader implements Runnable
	{
			public void run()
			{
				String msg;
				try
				{
					while((msg=reader.readLine())!=null)
					{
						System.out.println("Read"+msg);
						incoming.append(msg+"\n");
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
	}
}