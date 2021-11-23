//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.net.*;
import java.io.*;

public class TH4_Bai3_Client {

	public static void main(String[] args) {
		try {
			//Tao ra Multicast Socket cong
			MulticastSocket ms = new MulticastSocket(8769);
			//Tham gia vao nhom dia chi
			InetAddress dc = InetAddress.getByName("225.1.2.3");
			ms.joinGroup(dc);
			
			//Nhan goi phuc vu
			byte b[]= new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,b.length);
			ms.receive(goinhan);
			
			//Hien thi thong tin
			byte b1[] = goinhan.getData();
			int n1 = goinhan.getLength();
			FileOutputStream f = new FileOutputStream("D:/ketqua.txt");
			f.write(b1,0,n1);
			System.out.println("Nhan file thanh cong");
			f.close();
			ms.leaveGroup(dc);
			
		}
		catch(SocketException e) {
			System.out.println("Loi: khong tao duoc client socket");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}

	}

}
