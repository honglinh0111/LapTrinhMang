import java.net.*;
import java.util.Scanner;
import java.io.*;

public class client43 {

	public static void main(String[] args) {
		try{
			//Tao Multicast Socket
			MulticastSocket s = new MulticastSocket(7878);
			//Gia nhap vao nhom dia chi
			InetAddress gr = InetAddress.getByName("225.2.3.4");
			s.joinGroup(gr);
			
		    byte b[] = new byte[60000];
		    DatagramPacket goinhan = new DatagramPacket(b,60000);
		    s.receive(goinhan);
		    
		    byte b1[] = goinhan.getData();
		    int n1 = goinhan.getLength();
		    
		    System.out.print("Nhap ten file luu o cuc bo: ");
		    Scanner kb = new Scanner(System.in);
		    String tenfileluu = kb.nextLine();
		    
		    FileOutputStream f = new FileOutputStream(tenfileluu);
		    f.write(b1,0,n1);
		    System.out.println("Luu file thanh cong");
		    
		    f.close();
		    s.close();
		    kb.close();
		    s.leaveGroup(gr);
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}

}
