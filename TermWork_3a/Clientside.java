
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

public class Clientside 
{ 
	public static void main(String args[]) throws IOException 
	{ 
		Scanner sc = new Scanner(System.in); 

		// Create the socket object for 
		
		DatagramSocket ds = new DatagramSocket(); 

		InetAddress ip = InetAddress.getLocalHost(); 
		byte buf[] = null; 

		System.out.println("Enter the message: ");
		// loop while user not enters "bye" 
		while (true) 
		{ 
			
			String inp = sc.nextLine(); 

			// convert the String input into the byte array. 
			buf = inp.getBytes(); 

			 
			DatagramPacket DpSend = 
				new DatagramPacket(buf, buf.length, ip, 1234); 

			
			ds.send(DpSend); 

			
			if (inp.equals("bye")) 
			
				break; 
		} 
			sc.close();
			ds.close();
	} 
}