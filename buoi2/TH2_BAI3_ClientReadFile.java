// Ho Ten: Pham Thi Hong Linh
// MSSV: B1809365

import java.io.*;
import java.net.*;
import java.util.Scanner;

class TH2_BAI3_ClientReadFile {

	public static void main(String[] args) {
		
		try {
			Scanner kb = new Scanner(System.in);
//			System.out.println("Nhap dia chi Server: ");
//			String dcSrv = kb.nextLine();
			System.out.print("Nhap ten file can doc: ");
			String tenfile = kb.nextLine();
			System.out.print("Nhap ten file can luu: ");
			String luufile = kb.nextLine();
			
			Socket s = new Socket("localhost",1993);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			String caulenh = "READ " + tenfile;
			pw.println(caulenh); pw.flush();
			
			String kq = sc.nextLine();
			int n =Integer.parseInt(kq); // chieu dai file
			
			if(n==-1) {
				System.out.println(tenfile+" khong ton tai!");
			}
			else
				if(n==0) {
					System.out.println(tenfile+" la file rong!");
				}
				else {
					// tao ra mang byte de nhan noi dung tu server
					byte b[] = new byte[10000];
					int dodai = 0;
					// tao lop ghi file ra
					FileOutputStream f = new FileOutputStream(luufile);
					while(true) {
						//nhan vao so phan tu mang byte
						int k = is.read(b, 0, 10000);
						f.write(b);
						dodai = dodai + k; // do dai mang byte
						if(dodai == n) break; // doc toi phan tu cuoi cung
					}
					f.close();
					System.out.println("Luu file thanh cong");
				}
			s.close();	
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Socket Client");
		}
		
	}

}
