import java.io.*;
import java.net.*;
import java.util.Scanner;

public class talkServer {

	public static void main(String[] args) {
		try {
			//Tao Socket UDP
			DatagramSocket ds = new DatagramSocket(6565);
			
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,60000);
			while(true) {
				ds.receive(goinhan);
				
				byte b1[] = goinhan.getData();
				int n1= goinhan.getLength();
				String send = new String(b1,0,n1);
				System.out.print("Client: "+send+"\n");
				
				if(send.equals("bye")) break;
				
				Scanner kb = new Scanner(System.in);
				System.out.print("Server: ");
				String receive = kb.nextLine();
				
				byte b2[] = receive.getBytes();
				int n2 = b2.length;
				InetAddress dc = goinhan.getAddress();
				int p = goinhan.getPort();
				DatagramPacket goigui = new DatagramPacket(b2,n2,dc,p);
				ds.send(goigui);
			}
			ds.close();
		}
		catch(SocketException s) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}

}
