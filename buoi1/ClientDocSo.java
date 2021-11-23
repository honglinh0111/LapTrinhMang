//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.net.*;
import java.io.*;

public class ClientDocSo {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",999);
			System.out.println("Da noi ket den server.");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			while(true) { // 1 client duoc nhap nhieu lan
				System.out.print("Nhap 1 ky tu (0-9): ");
				int ch = System.in.read();
				System.in.skip(2);
				
				os.write(ch);
				
				if(ch=='@') break;
				//Ben Server gui qua mang byte => tao mang byte de luu => chuyen sang String => in ra
				byte b[] = new byte[1000];
				int n = is.read(b); // so ky tu cua mang byte
				//Chuyen byte thanh dang string
				String ch1 = new String(b,0,n);
				System.out.println("Ban da nhap so : "+ch1);
				
			}
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.print("Chua ket noi den Server");
		}
		catch(IOException e) {
			System.out.print("Loi nhap tu ban phim");	
		}
	}

}
