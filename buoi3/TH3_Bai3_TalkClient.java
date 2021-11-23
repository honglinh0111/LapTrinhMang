//Ho ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class TH3_Bai3_TalkClient {

	public static void main(String[] args) {
		try {
			//Tao UDP Socket
			DatagramSocket ds = new DatagramSocket();
			//Nhap noi dung can gui cho Server
			while(true) {
				Scanner kb = new Scanner(System.in);
				System.out.print("Send: ");
				String c = kb.nextLine();
				if(c.equals("Bye")) break;
				//Dong goi yeu cau va gui
				byte b[] = c.getBytes();
				int n = b.length;
				InetAddress dc = InetAddress.getByName("localhost");
				int p = 4567;
				DatagramPacket goigui = new DatagramPacket(b,n,dc,p);
				ds.send(goigui);
				//Nhan goi tra loi va nhan
				byte b1[] = new byte[60000];
				DatagramPacket goinhan = new DatagramPacket(b1,60000);
				ds.receive(goinhan);
				//Xu ly va Hien thi cau tra loi tu Server
				byte b2[] = goinhan.getData();
				int n2 = goinhan.getLength();
				String kq = new String(b2,0,n2);
				System.out.println("Receive: "+kq);
			}
			//Dong noi ket
			ds.close();
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(UnknownHostException u) {
			System.out.println("Sai dia chi");
		}
		catch(IOException i) {
			System.out.println("Loi nhap xuat");
		}
	} 

}
