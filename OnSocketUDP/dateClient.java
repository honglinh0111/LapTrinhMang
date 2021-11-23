import java.net.*;
import java.util.Scanner;
import java.io.*;

public class dateClient {

	public static void main(String[] args) {
		try {
			//Tao UDP socket
			DatagramSocket ds = new DatagramSocket();
			while(true) {
				//Nhap mot noi dung rong
				Scanner kb = new Scanner(System.in);
				System.out.print("Nhap noi dung can gui: ");
				String str = kb.nextLine();
				//Kiem tra dkien de thoat
				if(str.equals("EXIT")) break;
				
				//Tao ra goi gui va gui
				byte b[] = str.getBytes();
				int n = b.length;
				InetAddress dc = InetAddress.getByName("localhost");
				int p = 1577;
				DatagramPacket goigui = new DatagramPacket(b,n,dc,p);
				ds.send(goigui);
				
				//Tao ra goi nhan va nhan
				byte b1[] = new byte[10000];
				int n1 = b1.length;
				DatagramPacket goinhan = new DatagramPacket(b1,n1);
				ds.receive(goinhan);
				
				//hien thi ket qua
				byte b2[] = goinhan.getData();
				int n2 = goinhan.getLength();
				String kq = new String(b2,0,n2);
				System.out.println("Ket qua nhan duoc la: "+kq);
			}
			//Dong UDP socket lai
			ds.close();
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP socket");
		}
		catch(UnknownHostException  e) {
			System.out.println("Loi khong tim thay dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}

}