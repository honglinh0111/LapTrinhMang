// Ho Ten: Pham Thi Hong Linh
// MSSV: B1809365

import java.io.*;
import java.net.*;
import java.util.Scanner;

class TH2_BAI3_ServerReadFile {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(1993);
			System.out.println("Da khoi tao xong Server cong 1993");
			
			Socket s = ss.accept();
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
				//Nhan dau vao la mang byte cua 1 File duoc gui tu Client
				FileInputStream fis = new FileInputStream(tenfile);
				//Nhan file de doc du lieu file
				DataInputStream dis = new DataInputStream(fis);
				dis.readFully(b);
				fis.close();
				// Gui noi dung file da doc duoc
				DataOutputStream dos = new DataOutputStream(os);
				dos.write(b);
				
			}
			s.close();
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server Socket");
		}

	}

}
