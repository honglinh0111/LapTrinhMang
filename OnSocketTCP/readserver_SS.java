import java.net.*;
import java.util.Scanner;
import java.io.*;

class PhucVuReadFile extends Thread{
	private Socket s;
	public PhucVuReadFile(Socket s1) {
		s = s1;
	}
	public void run() {
		try {
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			String caulenh = sc.nextLine();
			String tenfile = caulenh.substring(5);
			
			File f = new File(tenfile);
			if(f.exists() && f.isFile()) {
				int size = (int)f.length();
				pw.println(size); pw.flush();
				if(size > 0) {
					byte b[] = new byte[size];
					FileInputStream fis = new FileInputStream(tenfile);
					DataInputStream dis = new DataInputStream(fis);
					dis.readFully(b);
					System.out.println("Da doc thanh cong noi dung file");
					fis.close();
					
					DataOutputStream dos = new DataOutputStream(os);
					dos.write(b);
					System.out.println("Da gui thanh cong noi dung file");
					
				}
				pw.println(0); pw.flush();
			}
			else {
				pw.println(-1); pw.flush();
			}
			s.close();
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}

class readserver_SS {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(2222);
			System.out.println("Da khoi tao thanh cong server socket");
			
			while(true) {
				Socket s = ss.accept();
				System.out.println("Da noi ket den 1 client");
				
				PhucVuReadFile pv = new PhucVuReadFile(s);
				pv.start();
			}
			
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}

	}

}
