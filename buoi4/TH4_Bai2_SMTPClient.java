//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TH4_Bai2_SMTPClient {

	public static void main(String[] args) {
		try {
			String serverAddr = "smtp.saix.net";
			int port = 25;
			Socket s =new Socket(serverAddr , port);
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os,true);
			
			Scanner kb = new Scanner(System.in);
			System.out.print("From: ");
			String emailSend = kb.nextLine();
			System.out.print("To: ");
			String emailReceive = kb.nextLine();
			
			String receive = sc.nextLine();
			System.out.println(receive);
			
			String domain = emailSend.substring(emailSend.indexOf('@')+1);
//			System.out.println("Ten mien: "+domain);
			
			System.out.println("HELO "+domain);
			pw.println("HELO "+domain);
			receive = sc.nextLine();
			System.out.println(receive);
			
			System.out.println("MAIL FROM: "+emailSend);
			pw.println("MAIL FROM: "+emailSend);
			receive = sc.nextLine();
			System.out.println(receive);
			
			System.out.println("RCPT TO: "+emailReceive);
			pw.println("RCPT TO: "+emailReceive);
			receive = sc.nextLine();
			System.out.println(receive);
			
			System.out.println("DATA");
			pw.println("DATA");
			receive = sc.nextLine();
			System.out.println(receive);
			
			System.out.println("---Nhap noi dung email, va ket thuc boi dau '.' ---");
			while(true) {				
				String content = kb.nextLine();				
				pw.println(content);
				
				if(content.equals(".")) {
					System.out.println("Noi dung duoc gui la: ");
					receive = sc.nextLine();
					System.out.println(receive);
					break;				
				}					
			}
			
			System.out.println("QUIT");
			pw.println("QUIT");
			receive = sc.nextLine();
			System.out.println(receive);
			
			sc.close();
			pw.close();
			s.close();
			
		}
		catch(UnknownHostException e) {
			System.out.println("Loi: Khong tim thay dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}

}
