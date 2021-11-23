import java.net.*;
import java.util.Scanner;
import java.io.*;

public class client42 {

	public static void main(String[] args) {
		
		try {
			String addSrv = "smtp.saix.net";
			Socket s = new Socket(addSrv,25);
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			Scanner kb = new Scanner(System.in);
			System.out.print("From: ");
			String emailSend = kb.nextLine();
			System.out.print("To: ");
			String emailReceive = kb.nextLine();
			
			String recevie = sc.nextLine();
			System.out.println(recevie);
			
			String domain = emailSend.substring(emailSend.indexOf('@') + 1);
			
			System.out.println("HELO "+domain);
			pw.println("HELO "+domain); pw.flush();
			recevie = sc.nextLine();
			System.out.println(recevie);
			
			System.out.println("MAIL FROM:"+emailSend);
			pw.println("MAIL FROM:"+emailSend); pw.flush();
			recevie = sc.nextLine();
			System.out.println(recevie);
			
			System.out.println("RCPT TO:"+emailReceive);
			pw.println("RCPT TO:"+emailReceive); pw.flush();
			recevie = sc.nextLine();
			System.out.println(recevie);
			
			System.out.println("DATA");
			pw.println("DATA"); pw.flush();
			recevie = sc.nextLine();
			System.out.println(recevie);
			
			System.out.println("Nhap noi dung email, ket thuc bang dau '.' ");
			while(true) {
				String content;
				content = kb.nextLine();
				pw.println(content); pw.flush();
				
				if(content.equals(".")) {
					System.out.println("Noi dung vua nhap la: ");
					recevie = sc.nextLine();
					System.out.println(recevie);
					break;
				}
			}

			System.out.println("QUIT");
			pw.println("QUIT"); pw.flush();
			recevie = sc.nextLine();
			System.out.println(recevie);
			
			sc.close();
			pw.close();
			s.close();
			kb.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Khong tim thay dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		
	}
}