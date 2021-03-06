import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

public class MulticastTimeServer {
	public static void main(String[] args) {
		try {
			//Tao UDP Socket
			DatagramSocket ds = new DatagramSocket();
			int dem=0;
			while(true) {
				//Lay thong tin thoi gian ve
				Date d = new Date();
				String ketqua = d.toString();
				//Dong goi UDP
				byte b[]=ketqua.getBytes();
				int n = b.length;
				InetAddress dc = InetAddress.getByName("230.0.0.1");
				int port = 9013;
				DatagramPacket goigui = new DatagramPacket(b,n,dc,port);
				//Gui den nhom dc, cong
				ds.send(goigui);
				System.out.println("Gui den nhom dia chi" + ++dem);
				Thread.sleep(1000);
			}			
			
		}
		catch( SocketException e ) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch( UnknownHostException e) {
			System.out.println("Sai dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		catch(InterruptedException e) {
			System.out.println("Loi xay ra khi tam dung CT");
		}
		
	}	

}