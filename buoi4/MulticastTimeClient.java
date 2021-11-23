import java.io.*;
import java.net.*;

public class MulticastTimeClient {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			//Tao ra Multicast Socket cong 9013
			MulticastSocket ms = new MulticastSocket(9013);
			//Tham gia vao nhom dia chi 230.0.0.1
			InetAddress dc = InetAddress.getByName("230.0.0.1");
			ms.joinGroup(dc);
			//Nhan goi UDP
			byte b[] = new byte[1000];
			DatagramPacket goinhan = new DatagramPacket(b,1000);
			ms.receive(goinhan);
			//Hien thi thong tin
			byte b1[] = goinhan.getData();
			int n1 = goinhan.getLength();
			String kq = new String(b1,0,n1);
			System.out.println("Bay gio la: "+kq);
			//Roi khoi nhom
			ms.leaveGroup(dc);
			//Dong Socket lai
			ms.close();
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		
	}	

}