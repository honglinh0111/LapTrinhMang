import java.net.*;
import java.util.Date;
import java.io.*;

public class dateServer {

	public static void main(String[] args) {
		try {
			//Tao UDP socket cong 1577
			DatagramSocket ds = new DatagramSocket(1577);
			//Tao goi nhan dlieu va nhan dlieu
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,60000);
			while(true) {
				ds.receive(goinhan);
				//Xu ly yeu cau
				Date dd = new Date();
				String kq = dd.toString();
				//Dong goi gui va gui dlieu
				byte b1[] = kq.getBytes();
				int n1 = b1.length;
				int p1 = goinhan.getPort();
				InetAddress dc1 = goinhan.getAddress();
				DatagramPacket goigui = new DatagramPacket(b1,n1,dc1,p1);
				ds.send(goigui);
			}
			
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP socket");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}

}
