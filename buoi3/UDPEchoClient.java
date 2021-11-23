import java.net.*;
import java.util.Scanner;
import java.io.*;

public class UDPEchoClient {

	public static void main(String[] args) {
		try {
			//Tao UDP Socket
			DatagramSocket ds = new DatagramSocket();
			Scanner kb = new Scanner(System.in);
			while(true) {//1 client duoc yeu cau nhieu lan
				//Nhap vao 1 chuoi tu ban phim
				System.out.print("Nhap vao 1 chuoi: ");
				String str = kb.nextLine();
				//Kiem tra dieu kien de thoat
				if(str.equals("EXIT")) break;
				//Tao ra goi tin de gui co noi dung la chuoi String
				byte b[] = str.getBytes();
				int n = b.length;
				InetAddress dc = InetAddress.getByName("localhost");
				int p = 7777;
				DatagramPacket goigui = new DatagramPacket(b,n,dc,p); // dl byte, dodai, dcIP, port
				//Gui goi UDP qua Server
				ds.send(goigui);
				//Tao goi UDP de nhan
				byte b1[] = new byte[60000];
				DatagramPacket goinhan = new DatagramPacket(b1,60000);
				//Nhan goi tra ve tu Server
				ds.receive(goinhan);
				//Hien thi thong tin
				byte kq[] = goinhan.getData();
				int n1 = goinhan.getLength();
				String ketqua = new String(kq,0,n1);
				System.out.println("Ket qua nhan ve: "+ketqua);
			}
			//Dong UDP Socket lai
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