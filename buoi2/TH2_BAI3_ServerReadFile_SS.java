// Ho Ten: Pham Thi Hong Linh
// MSSV: B1809365

import java.io.*;
import java.net.*;
import java.util.Scanner;

class PhucVuReadFile extends Thread {
	Socket s;
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
			int size = (int)f.length(); // kich thuoc file
			
			if(f.exists()==false || f.isDirectory()) {
				pw.println(-1); pw.flush();
			}
			else {
				pw.println(size); pw.flush();
				//tao mang byte den nhan du lieu dau vao
				byte b[] = new byte[size];
				FileInputStream fis = new FileInputStream(tenfile);
				DataInputStream dis = new DataInputStream(fis);
				dis.readFully(b);
				fis.close();
				// Gui noi dung file da doc duoc
				DataOutputStream dos = new DataOutputStream(os);
				dos.write(b);
				
			}
			s.close();
			System.out.println("Dong noi ket 1 Client");
		}
		catch(IOException e) {
			System.out.println("Loi khi phuc vu 1 Client");
		}
	}
}

class TH2_BAI3_ServerReadFile_SS {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(1993);
			System.out.println("Da khoi tao xong Server cong 1993");
			try {
				while(true) { // phuc vu nhieu Client
					Socket s = ss.accept();
					System.out.println("Da ket noi voi 1 Client");
					PhucVuReadFile pvrf = new PhucVuReadFile(s);
					pvrf.start();
				}
				
			}
			catch(IOException e) {
				System.out.println("Loi khi phuc vu 1 Client");
			}
			
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server Socket");
		}

	}

}
