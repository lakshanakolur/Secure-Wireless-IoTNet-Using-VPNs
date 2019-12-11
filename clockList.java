import java.time.format.DateTimeFormatter;  
import java.time.*; 
import java.util.*;  
class clockList
{
	public static void main(Dictionary ipaddr)
	{
		try
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   			LocalDateTime now = LocalDateTime.now();  
   			System.out.println(dtf.format(now));
   			System.out.println(ipaddr.get("B1104")); 
   			while(LocalTime.now().isBefore(LocalTime.parse("16:00")))
   			{
   				Thread.sleep(1000);
   			}
   		}
   		catch(InterruptedException e)
   		{

   		}
	}
}