import java.net.*;
import java.util.Scanner;
import java.io.*;

public class QuizServer {

	private final static int udpPort = 4444, tcpPort=3333;
	private final static String dcServer = "127.0.0.1";
	
	public static void main(String[] args) {
		try {
			
			Question questionList[] = new Question[5];
			questionList[0] = new Question("Em an com chua ? ","Em an roi","Em chua a.","An roi hay chua ke tao","hihi","C");
			questionList[1] = new Question("Em co thich an rau den khong ? ","Da co","Da khong a.","Ke tao","hihi","A");
			questionList[2] = new Question("Di xem ENDGAME khong ? ","OK","Dut","Mua ve di","Het tien oi","D");
			questionList[3] = new Question("Gia dinh em co biet em bi dong tinh khong ? ","Co","Khong","????","Vaiiiiii","B");
			questionList[4] = new Question("Em co thich anh khong? ","hihi","hmmmmm em cung k biet nua","Co","Khong","A");
			
			ServerSocket ss_socketTCP = new ServerSocket(tcpPort);
			
			DatagramSocket socketUDP = new DatagramSocket(udpPort);
			//InetAddress addSrv = InetAddress.getByName(dcServer);
			
			//Chap nhan cho Client noi ket			
			Socket socketTCP = ss_socketTCP.accept();
			System.out.println("Da ket noi voi 1 Client port " + socketTCP.getPort());
			
			InputStream is = socketTCP.getInputStream();
			OutputStream os = socketTCP.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			//Nhan username password tu Client bang UDP, khong can kiem tra
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,b.length);
			socketUDP.receive(goinhan);
			
			//String userpass = new String(goinhan.getData(),0,goinhan.getLength());
			
			//Gui Client 1 password bat ky
			String passGame = "abc123";
			DatagramPacket goigui = new DatagramPacket(passGame.getBytes(),passGame.length(),goinhan.getAddress(),goinhan.getPort());
			socketUDP.send(goigui);
			
			//Nhan lai password bang TCP va kiem tra
			String passGame2 = sc.nextLine();
			int result=0;
			if(passGame2.equals(passGame)) {
				for(int i=0 ; i<5 ; i++) {
					String question = "Cau hoi "+(i+1)+": "+questionList[i].question;
					pw.println(question); pw.flush();
					
					for(int j=0 ; j<4 ; j++) {
						String dapan = questionList[i].answer[j];
						pw.println(dapan); pw.flush();
					}
					String chon = sc.nextLine();
					if(chon.equals(questionList[i].solution)) {
						result++;
					}
				}
			}
			String kq = "Ban da tra loi duoc: " + result + "/5 cau";
			pw.println(kq); pw.flush();
			
			System.out.println("Client o port "+socketTCP.getPort()+" da hoan thanh bai kiem tra");
			socketTCP.close();
			sc.close();
			
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server");
		}
		
	}

}
