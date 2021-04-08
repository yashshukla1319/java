//collections.sort()
//ArrayList with object()

import java.util.*;
import java.io.*;

public class Song
{
	//ArrayList<String> songList = new ArrayList<String>();
	ArrayList<Music> songList = new ArrayList<Music>();
	
	public static void main(String args[])
	{
		new Song().go();
	}
	public void go()
	{
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
	}
	public void getSongs()
	{
		try
		{
			File file=new File("Box.txt");
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=reader.readLine())!=null)
			{
				addSong(line);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	void addSong(String lineToParse)
	{
		String[] tokens=lineToParse.split("/");
		Music nextSong=new Music(tokens[0],tokens[1],tokens[2],tokens[3]);
		songList.add(nextSong);
	}
}