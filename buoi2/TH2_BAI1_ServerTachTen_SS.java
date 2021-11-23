//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.io.*;
import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

class PhucVucTachTen extends Thread {
	
	private Socket s;
	public PhucVucTachTen(Socket s1) {
		s = s1;
	}
	public void run() {
		try {
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			while(true) { // Cho 1 Client nhap nhieu lan
				String chuoihoten = sc.nextLine();
				if(chuoihoten.equals("EXIT")) break;
				// Xu Ly yeu cau
				String t = chuoihoten.trim(); // Loai bo khoang trang du thua
				int i = t.lastIndexOf(' '); // Vi tri cua khoang trang cuoi cung
				String ten = t.substring(i+1); // Lay ten ra
				
				pw.println(ten); pw.flush();
			}
			// dong ket noi
			s.close();
			System.out.println("Dong ket noi 1 Client");
		}
		catch(IOException e) {
			System.out.println("Loi khi phuc vu 1 Client");
		}
	}
}

class TH2_BAI1_ServerTachTen_SS {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(2345);
			System.out.println("Da khoi tao xong Server cong 2345");
			
			while(true){ // phuc vu nhieu Client
				try {
					Socket s = ss.accept();
					System.out.println("Da ket noi voi 1 Client");
					PhucVucTachTen pvtt = new PhucVucTachTen(s);
					pvtt.start();
				}
				catch(IOException e) {
					System.out.println("Loi khi phuc vu 1 Client");
				}
			}
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server Socket");
		}

	}

}
