//Ho ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.net.*;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class TH3_Bai1_Server {

	public static void main(String[] args) {
		try {
			//Tao UDP socket
			DatagramSocket ds = new DatagramSocket(7878);
			//Tao goi nhan va nhan DL
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,60000);
			while(true) {
				ds.receive(goinhan);
				//Xu ly du lieu
				Date dd = new Date();
				String str = dd.toString();
				//Tao goi gui va gui DL
				byte b2[] = str.getBytes();
				int n2 = b2.length;
				InetAddress dc = goinhan.getAddress();
				int p = goinhan.getPort();
				DatagramPacket goigui = new DatagramPacket(b2,n2,dc,p);
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
