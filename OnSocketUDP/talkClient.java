import java.io.*;
import java.net.*;
import java.util.Scanner;
public class talkClient {

	public static void main(String[] args) {
		try {
			//Tao UDP Socket
			DatagramSocket ds = new DatagramSocket();
			while(true) {
				Scanner kb = new Scanner(System.in);
				System.out.print("Client: ");
				String send = kb.nextLine();
				
				
				byte b[] = send.getBytes();
				int n = b.length;
				InetAddress dc = InetAddress.getByName("127.0.0.1");
				int p = 6565;
				DatagramPacket goigui = new DatagramPacket(b,n,dc,p);
				ds.send(goigui);
				
				if(send.equals("bye")) break;
				
				byte b1[] = new byte[60000];
				DatagramPacket goinhan = new DatagramPacket(b1,60000);
				ds.receive(goinhan);
				
				byte b2[] = goinhan.getData();
				int n2 = goinhan.getLength();
				String receive = new String(b2,0,n2);
				System.out.println("Server: "+receive);
			}
			ds.close();
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
