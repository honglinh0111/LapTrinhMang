import java.net.*;
import java.io.*;

public class EchoServer1 {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(1888);
		System.out.println("Da khoi tao xong Server");
		
		while(true) { // phuc vu nhieu client
			Socket s = ss.accept();
			System.out.println("Co mot Client "+s.getInetAddress() + " cong "+s.getPort()+" noi ket");
		
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true) { // cho nhieu client nhap nhieu lan
				int ch = is.read();
				System.out.println("Nhan duoc: "+ch);
				
				if(ch=='@') break;
				
				int ch1 = ch;
				
				os.write(ch1);
			}
			s.close();
		}
		//ss.close();
	}

}