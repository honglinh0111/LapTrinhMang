//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.io.*;
import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

class TH2_BAI1_ServerTachTen {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(2345);
			System.out.println("Da khoi tao xong Server cong 2345");
			
			Socket s = ss.accept();
			System.out.println("Da ket noi voi 1 Client");
			
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
			
			s.close();
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server Socket");
		}
		
		

	}

}
