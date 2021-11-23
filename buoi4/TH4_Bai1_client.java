//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TH4_Bai1_client {
	public static void main(String[] args) {
		try {
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap dia chi web server: ");
			String diachi = kb.nextLine();
			System.out.print("Nhap ten tai nguyen: ");
			String tentainguyen=kb.nextLine();
			
			Socket s = new Socket(diachi,8077);
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			pw.println("GET /"+tentainguyen+" HTTP/1.1");
			pw.println("Host: "+diachi);
			pw.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; rv:81.0) Gecko/20100101 Firefox/81.0");
			pw.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			pw.println("Accept-Language: en-US,en;q=0.5");
			pw.println("Accept-Encoding: gzip, deflate");
			pw.println("Upgrade-Insecure-Requests: 1");
			pw.println();
			pw.flush();
			FileOutputStream f = new FileOutputStream("ketqua.html");
			while(true) {
				int ch=is.read();
				if(ch==-1)	break;
				f.write(ch);
			}
			f.close();
			s.close();
			System.out.println("Da ghi file thanh cong");
		}
		catch(IOException e) {
			System.out.println("Loi: Khong tao duoc client socket");
		}
	}
}
