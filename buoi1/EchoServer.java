import java.net.*;
import java.io.*;

public class EchoServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(1999);
			System.out.println("Da khoi tao xong Server");
			
			while(true) { 
				try {
					Socket s = ss.accept();
					System.out.println("Co 1 Client" + s.getInetAddress() + " cong "+s.getPort() + " noi ket");
					
					InputStream is = s.getInputStream();
					OutputStream os = s.getOutputStream();
					
					while(true) { 
						int ch = is.read();
						System.out.println("Nhan duoc" + ch);
						
						if(ch=='@') break;
						
						int ch1 = ch;
						
						os.write(ch1);
					}
					s.close();
				}
				catch(IOException ie) {
					System.out.print("Loi khi phuc vu 1 client");
				}	
			}
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server");
		}

	}

}
