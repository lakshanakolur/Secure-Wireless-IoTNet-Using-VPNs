import java.io.*;
import java.util.concurrent.*;

class Inp
{
	public static void main(String[] args)throws InterruptedException
	{
		ConsoleInput con = new ConsoleInput(10,1,TimeUnit.SECONDS);
		String input = con.readLine();
    	System.out.println("Done. Your input was: " + input);
	}
}