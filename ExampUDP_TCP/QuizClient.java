import java.net.*;
import java.util.Scanner;
import java.io.*;

public class QuizClient {
	
	private final static int udpPort = 4444, tcpPort=3333;
	private final static String dcServer = "127.0.0.1";
	
	public static void main(String[] args) {
		try {
			Socket socketTCP = new Socket(dcServer,tcpPort);
			DatagramSocket socketUDP = new DatagramSocket();
			InetAddress addSrv = InetAddress.getByName(dcServer);
			
			InputStream is = socketTCP.getInputStream();
			OutputStream os = socketTCP.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap Username: ");
			String username = kb.nextLine();
			System.out.print("Nhap Password: ");
			String password = kb.nextLine();
			
			String userpass = username +" "+password;
			DatagramPacket goigui = new DatagramPacket(userpass.getBytes(),userpass.length(),addSrv,udpPort);
			socketUDP.send(goigui);
			
			//Nhan chuoi password tro choi bang UDP
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,b.length);
			socketUDP.receive(goinhan);
			
			String passGame = new String(goinhan.getData(),0,goinhan.getLength());
			System.out.println("Nhan pass game tu Server la: "+passGame);
			
			//Gui password tro cho qua TCP Server
			pw.println(passGame); pw.flush();
			
			//Nhan 5 cau hoi, moi cau 4 dap an
			for( int i = 0 ; i < 5 ; i++) {
				String question = sc.nextLine();
				System.out.println(question);
				for( int j = 0 ; j < 4 ; j++) {
					String answer = sc.nextLine();
					System.out.println(answer);
				}
				System.out.print("Cau tra loi cua ban la: ");
				String chon = kb.nextLine();
				pw.println(chon); pw.flush();
			}
			
			String result = sc.nextLine();
			System.out.println(result);
			
			socketTCP.close();
			socketUDP.close();
			kb.close();
			sc.close();
			
		}
		catch(UnknownHostException e) {
			System.out.println(e.toString());
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
	}
}