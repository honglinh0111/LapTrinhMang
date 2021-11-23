import java.net.*;
import java.io.*;

public class UDPEchoServer {
	public static void main(String[] args) {
		try {
			//Tao ra UDP Socket
			DatagramSocket ds = new DatagramSocket(7777);
			//Tao ra goi de nhan
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,60000);
			while(true) {
				ds.receive(goinhan);
				//Xu ly yeu cau
				byte b2[] = goinhan.getData();
				int n2 = goinhan.getLength();
				String str = new String(b2,0,n2);
				System.out.println("Nhan yeu cau tu Client: "+str);
				String kq = str.toUpperCase();
				//Dong goi ket qua
				byte b3[] = kq.getBytes();
				int n3 = b3.length;
				InetAddress dc3 = goinhan.getAddress();
				int p3 = goinhan.getPort();
				DatagramPacket goigui = new DatagramPacket(b3,n3,dc3,p3);
				//Gui goi ket qua cho Client
				ds.send(goigui);
			}
		}
		catch(SocketException s) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		
	}
}
