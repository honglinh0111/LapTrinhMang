import java.net.*;
import java.io.*;

public class EchoClient1 {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",1888);
			System.out.println("Da noi ket den server.");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			while(true) { // 1 client duoc nhap nhieu lan
				System.out.print("Nhap 1 ky tu: ");
				int ch = System.in.read();
				System.in.skip(2);
				
				os.write(ch);
				
				if(ch=='@') break;
				
				int ch1 = is.read();
				
				System.out.println("Ket qua nhan duoc la: "+(char)ch1);
				
			}
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.print(e);
		}
		catch(IOException e) {
			System.out.print(e);	
		}
	}

}
