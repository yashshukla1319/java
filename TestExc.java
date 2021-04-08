class TestExc
{
	public static void main(String args[])
	{
		String test="yes";
		try
		{
			System.out.println("start try"); 
			doRisky(test); 
			System.out.println("end try"); 
			
			
		}
		catch(Exception se)
		{
			System.out.println("scary exception");
			
			
		}
		
		
		
	}
	

	  static void doRisky(String test) throws Exception
	{
		System.out.println("Start risky");
		if ("yes".equals(test)) 
		{
			System.out.println("Uend riskyN"); 
			throw new Exception();
			
		}
	}
}
		