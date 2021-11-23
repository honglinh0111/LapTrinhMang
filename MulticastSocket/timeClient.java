import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.io.IOException;

public class timeClient {

	public static void main(String[] args) {
		try {
			//Tao mot multicastSocket
			MulticastSocket s = new MulticastSocket(2525);
			//Tham gia vao nhom dia chi
			InetAddress gr = InetAddress.getByName("226.1.2.3");
			s.joinGroup(gr);
			
			//Nhan kqua tu Serv
			byte b[] = new byte[1000];
			DatagramPacket goinhan = new DatagramPacket(b,1000);
			s.receive(goinhan);
			
			byte b1[] = goinhan.getData();
			int n1 = goinhan.getLength();
			String kq = new String(b1,0,n1);
			System.out.println("Bay gio la: " + kq ); 
			
			s.leaveGroup(gr);
			s.close();
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		

	}

}
