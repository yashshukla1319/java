class Clocktest 
		{
			public static void main(String [] args)
			{

				Clock c = new Clock();
				c.setTime("1245") ;
				String tad = c.getTime();
				System.out.println("time: "+ tad);
			}
		}


class Clock 
	{
		String time;
		
		String setTime(String t)
		{
			time = t;
			return t;
		}

		String getTime()
		{
			return time;
		}
	}
		