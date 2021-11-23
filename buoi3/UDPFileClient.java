import java.net.*;
import java.util.Scanner;
import java.io.*;

public class UDPFileClient {
	
	public static void main(String[] args) {
		try {
			//Tao UDP Socket
			DatagramSocket ds = new DatagramSocket();
			
			//Nhap vao dia chi SER va ten file can lay
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap dia chi Srv: ");
			String dcSrv = kb.nextLine();
			System.out.print("Nhap ten file tren server can lay ve: ");
			String tenfile = kb.nextLine();
			//Dong goi gui yeu cau
			String yeucau = "READUDP "+tenfile;
			byte b[] = yeucau.getBytes();
			int len = b.length;
			InetAddress dc = InetAddress.getByName(dcSrv);
			int p = 1999;
			DatagramPacket goigui = new DatagramPacket(b,len,dc,p);
			//Gui yeu cau qua cho SER
			ds.send(goigui);
			//Nhan goi tra loi tu SER
			byte b1[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b1,60000);
			ds.receive(goinhan);
			//Kiem tra goi nhan ve
			byte b2[] = goinhan.getData();
			int len2 = goinhan.getLength();
			if(len2 == 0)
				System.out.println("File khong ton tai hoac file rong.");
			else {
				//Luu thanh file
				System.out.print("Nhap ten file luu: ");
				String tenfileluu = kb.nextLine();
				FileOutputStream fos = new FileOutputStream(tenfileluu);
				fos.write(b2,0,len2);
				fos.close();
				System.out.println("Da ghi file thanh cong");
			}
			
			//Dong Socket
			ds.close();			
		}
		catch(SocketException s) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(UnknownHostException u) {
			System.out.println("Sai dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
