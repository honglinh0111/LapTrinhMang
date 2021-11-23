import java.net.*;
import java.util.Date;
import java.io.IOException;

public class timeServer {

	public static void main(String[] args) {
		try {
			//Tao goiUDP 
			DatagramSocket s = new DatagramSocket();
			int dem=0;
			while(true) {
				//Xu ly dlieu va dong goi
				Date d = new Date();
				String kq = d.toString();
				
				byte b[] = kq.getBytes();
				int n = b.length;
				int p = 2525;
				InetAddress dc = InetAddress.getByName("226.1.2.3");
				DatagramPacket goigui = new DatagramPacket(b,n,dc,p);
				s.send(goigui);
			
				System.out.println("Gui goi thu " + ++dem);	
				Thread.sleep(3000);
			}
			//s.close();
			
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc Socket UDP");
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		catch(InterruptedException  e) {
			
		}

	}

}
