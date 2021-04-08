import java.io.*;
import java.net.*;
import java.util.*;

class Chatserver
{
	ArrayList ClientOutputStreams;
	
	public class ClientHandler implements Runnable 
	{
		BufferedReader reader;
		Socket sock;

		public ClientHandler(Socket clientSocket)throws IOException
		{
			try
			{
				InputStreamReader rder = new InputStreamReader(sock.getInputStream());
				sock=clientSocket;
				
				reader=new BufferedReader(rder);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		public void run()
		{
			String msg;
			try
			{
				while((msg = reader.readLine())!=null)
				{
					System.out.println("read"+msg);
					tellEveryone(msg);
				}
			}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
		}
	}
	
	public static void main(String args[])
	{
		new Chatserver().go();
	}
	public void go()
	{
		ClientOutputStreams = new ArrayList();
		try
		{
			ServerSocket serversock=new ServerSocket(5000);
			
			while(true)
			{
				Socket clientSocket=serversock.accept();
				PrintWriter writer= new PrintWriter(clientSocket.getOutputStream());
				ClientOutputStreams.add(writer)
				Thread t=new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("Got a connection");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void tellEveryone(String msg)
	{
		Iterator itr = ClientOutputStreams.iterator();
		while(itr.next()!=null)
		{
			try
			{
				PrintWriter writer= (PrintWriter)itr.next();
				writer.println(msg);
				writer.flush();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
			
			
			