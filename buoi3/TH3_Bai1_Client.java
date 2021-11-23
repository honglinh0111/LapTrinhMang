//Ho ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class TH3_Bai1_Client {

	public static void main(String[] args) {
		try {
			//Tao Socket UDP
			DatagramSocket ds = new DatagramSocket();
			
			//Nhap DL
			Scanner kb = new Scanner(System.in);
			while(true) {
				System.out.print("Nhap noi dung yeu cau: ");
				String str = kb.nextLine();
				if(str.equals("EXIT")) break;
				//Tao goi gui và gui DL
				byte b[] = str.getBytes();
				int n = b.length;
				InetAddress dc = InetAddress.getByName("localhost");
				int p = 7878;
				DatagramPacket goigui = new DatagramPacket(b,n,dc,p);
				ds.send(goigui);
				//Tao goi nhan va nhan DL
				byte b1[] = new byte[60000];
				DatagramPacket goinhan = new DatagramPacket(b1,60000);
				ds.receive(goinhan);
				//Xu ly ket qua va hien thi
				byte b2[] = goinhan.getData();
				int n2 = goinhan.getLength();
				String kq = new String(b2,0,n2);
				System.out.println("Ket qua nhan duoc: "+kq);
			}
			
			//Dong noi ket
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
