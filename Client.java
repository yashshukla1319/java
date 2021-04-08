import java.io.*;
import java.net.*;
class Client
{
	public static void main(String []args)
	{
		try
		{
			System.out.println("Setting up connection");
		
			Socket s = new Socket("127.0.0.1",1868);
			System.out.println("connection successful");
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("Response from server");
			System.out.println("connection successful"+br.readLine());
			s.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
		
}