import java.net.*;
import java.util.Scanner;
import java.io.*;

public class UDPFileServer {

	public static void main(String[] args) {
		try {
			//Tao UDP Socket
			DatagramSocket ds = new DatagramSocket(1999);
			//Tao goi nhan tu Client
			byte b[] = new byte[1000];
			DatagramPacket goinhan = new DatagramPacket(b,1000);
			while(true) {
				//Nhan goi yeu cau tu Client
				ds.receive(goinhan);
				//Lay thong tin tu goi 
				byte b1[] = goinhan.getData();
				int len1 = goinhan.getLength();
				InetAddress dc1 = goinhan.getAddress();
				int p1 = goinhan.getPort();
				//Xu ly yeu cau
				String yeucau = new String(b1,0,len1);
				String tenfile = yeucau.substring(8);
				System.out.println("Client yeu cau file: " + tenfile);
				File f = new File(tenfile);
				if(f.exists() && f.isFile()) {
					//file ton tai
					int len2 = (int)f.length();
					byte b2[] = new byte[len2];
					FileInputStream fis = new FileInputStream(tenfile);
					fis.read(b2);
					fis.close();
					//Dong goi
					DatagramPacket goigui=new DatagramPacket(b2,len2,dc1,p1);
					ds.send(goigui);
				}else {
					//File khong ton tai
					byte b2[] = new byte[10];
					int len2 = 0;
					DatagramPacket goigui = new DatagramPacket(b2,len2,dc1,p1);
					ds.send(goigui);
				}
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
