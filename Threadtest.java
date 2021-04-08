class Mythread implements Runnable
{
	public void run()
	{
		go();
	}
	public void go()
	{
		domore();
	}
	public void domore()
	{
		System.out.println("New thread");
	}
}
class Testthread
{
	public static void main(String args[])
	{
		Runnable r=new Mythread();
		Thread mt=new Thread(r);
		mt.start();
		System.out.println("Inside main thread");
	}
}