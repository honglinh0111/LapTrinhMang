import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class readClient {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap dia chi server: ");
			String dcsrv = kb.nextLine();
			while(true) {
				System.out.print("Nhap ten file can lay tren Server: ");
				String tenfile = kb.nextLine();
				if(tenfile.equals("EXIT")) break;
				String caulenh = "READUDP "+tenfile;
				
				byte b[] = caulenh.getBytes();
				int n = b.length;
				InetAddress dc = InetAddress.getByName(dcsrv);
				int p = 7799;
				DatagramPacket goigui = new DatagramPacket(b,n,dc,p);
				ds.send(goigui);
				
				byte b1[] = new byte[60000];
				DatagramPacket goinhan = new DatagramPacket(b1,60000);
				ds.receive(goinhan);
				
				byte b2[] = goinhan.getData();
				int n2 = goinhan.getLength();
				
				if(n2==-1 || n2==0) {
					System.out.println("File khong ton tai hoac file rong");
				}
				else {
					System.out.print("Nhap ten file luu o cuc bo: ");
					String tenfileluu = kb.nextLine();
					FileOutputStream fos = new FileOutputStream(tenfileluu);
					fos.write(b2);
					fos.close();
					System.out.println("Luu file thanh cong");
				}
			}
			ds.close();
			kb.close();
		}
		catch(SocketException e) {
			System.out.println("Loi khong khoi tao duoc UDP Socket");
		}
		catch(UnknownHostException  e) {
			System.out.println("Loi khong tim thay dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}

	}

}
