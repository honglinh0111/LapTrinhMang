import java.net.*;
import java.io.*;

public class server43 {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			int dem=0;
			
			while(true) {	
				FileInputStream f = new FileInputStream("D:/test.txt");
				byte b[] = new byte[60000];
				int n = f.read(b);
				InetAddress dc = InetAddress.getByName("225.2.3.4");
				int p = 7878;
				DatagramPacket goigui = new DatagramPacket(b,n,dc,p);
				
				ds.send(goigui);
				System.out.println("Da gui goi thu: "+ dem++); 
				f.close();
				Thread.sleep(30000);
				
			}
			
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		}
		catch( IOException e) {
			System.out.println("Loi nhap xuat");
		}
		catch(InterruptedException  e) {
			System.out.println(e.getMessage());
		}
	}

}
