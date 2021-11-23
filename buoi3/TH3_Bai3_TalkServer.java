//Ho ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class TH3_Bai3_TalkServer {

	public static void main(String[] args) {
		try {
			//Tao UDP Socket
			DatagramSocket ds = new DatagramSocket(4567);
			//Tao goi nhan va nhan tin tu Client
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,60000);
			while(true) {
				ds.receive(goinhan);
				//Xu ly va Hien thi tin cua Client
				byte b1[] = goinhan.getData();
				int n1 = goinhan.getLength();
				String c = new String(b1,0,n1);
				System.out.println("Receive: "+c);
				//Nhap cau tra loi
				Scanner kb = new Scanner(System.in);
				System.out.print("Send: ");
				String s = kb.nextLine();
				if(s.equals("Bye")) break;
				//Tao goi gui va gui cau tra loi cho Client
				byte b2[] = s.getBytes();
				int n2 = b2.length;
				InetAddress dc = goinhan.getAddress();
				int p = goinhan.getPort();
				DatagramPacket goigui = new DatagramPacket(b2,n2,dc,p);
				ds.send(goigui);
			}
			ds.close();
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(IOException i) {
			System.out.println("Loi nhap xuat");
		}
		

	}

}
