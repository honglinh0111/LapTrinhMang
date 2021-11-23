import java.net.*;
import java.io.*;

public class EchoClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",1999);
			System.out.println("Da noi ket den Server");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true) {
				System.out.print("Nhap 1 ky tu: ");
				int ch = System.in.read();
				
				os.write(ch);
				System.in.skip(2);
				if(ch=='@') break;
				
				int ch1 = is.read();
				
				System.out.println("Nhan duoc: " + (char)ch1 );
			}
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Chua ket noi den Server");
		}
		catch(IOException e) {
			System.out.println("Loi nhap tu ban phim");
		}

	}

}
