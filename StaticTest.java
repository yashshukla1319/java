

public class StaticTest extends StaticSuper
{

	static int rand;
	public static void main(String args[]) 
	{
		System.out.println("in main");
		StaticTest st = new StaticTest();
	}
	
	static 
	{
		rand = (int) (Math.random() * 6);
		System.out.println("static block n" + rand);
	}
	
	void StaticTests() 
	{
		System.out.println("constructor");
	}

	
}
class StaticSuper
{
	static 
	{
		System.out.println("super static block");
	}
	
	 void StaticSuper()
	{
		System.out.println("super constructor");
	}
}