import java.io.*;
import java.net.*;
import java.util.Scanner;

public class readServer {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(7799);
			
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,60000);
			while(true) {
				ds.receive(goinhan);
				
				byte b1[] = goinhan.getData();
				int n1 = goinhan.getLength();
				int p1 = goinhan.getPort();
				InetAddress dc1 = goinhan.getAddress();
				
				String caulenh = new String(b1,0,n1);
				String tenfile = caulenh.substring(8);
				
				File f = new File(tenfile);
				if(f.exists() && f.isFile()) {
					int len = (int)f.length();
					byte b2[] = new byte[len];
					FileInputStream fis = new FileInputStream(tenfile);
					fis.read(b2);
					fis.close();
					System.out.println("Doc thanh cong noi dung file");
					
					DatagramPacket goigui = new DatagramPacket(b2,len,dc1,p1);
					ds.send(goigui);
				}
				else {
					byte b2[] = new byte[10];
					int len = 0;
					DatagramPacket goigui = new DatagramPacket(b2,len,dc1,p1);
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
