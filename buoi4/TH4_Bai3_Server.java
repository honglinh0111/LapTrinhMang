//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.net.*;
import java.io.*;

public class TH4_Bai3_Server {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			FileInputStream fis = new FileInputStream("D:/test.txt");
			byte b[] = new byte[60000];
			int n = fis.read(b);
			InetAddress dc = InetAddress.getByName("225.1.2.3");
			int port=8769;
			DatagramPacket goigui = new DatagramPacket(b,n,dc,port);
			int dem=0;
			while(true) {
				ds.send(goigui);
				System.out.println("Da gui goi thu: "+ dem++); 
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
		catch(SocketException e) {
			System.out.println(e);
		}
		catch(IOException u) {
			System.out.println(u);
		}
	}

}
