//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.net.*;
import java.io.*;

class PhucVuDocSo extends Thread {
	private Socket s;
	public PhucVuDocSo(Socket s1) {
		s = s1;
	}
	public void run() {
		try {
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true) { // cho nhieu client nhap nhieu lan
				int ch = is.read();
				System.out.println("Nhan duoc: "+ch);
				
				if(ch=='@') break;
				
				String kq="Khong biet";
				switch(ch) {
					case '0': kq="Khong"; 	break;
					case '1': kq="Mot"; 	break;
					case '2': kq="Hai"; 	break;
					case '3': kq="Ba"; 		break;
					case '4': kq="Bon"; 	break;
					case '5': kq="Nam"; 	break;
					case '6': kq="Sau"; 	break;
					case '7': kq="Bay"; 	break;
					case '8': kq="Tam"; 	break;
					case '9': kq="Chin";
				}
				//chuyen string sang byte
				byte b[] = kq.getBytes();
				os.write(b);
			}
			s.close();
			System.out.println("Da dong noi ket voi 1 Client");
		}
		catch(IOException e) {
			System.out.println("Co loi khi dang phuc vu 1 Client");
		}
	}
}

class ServerDocSo_SS{

	public static void main(String[] args)  {
		
		try {
			ServerSocket ss = new ServerSocket(999);
			System.out.println("Da khoi tao xong Server cong 999");
			
			while(true) { // phuc vu nhieu client
				try {	
					Socket s = ss.accept();
					System.out.println("Co 1 Client noi ket");
					PhucVuDocSo pv1 = new PhucVuDocSo(s);
					pv1.start();
				}
				catch(IOException e) {
					System.out.println("Co loi khi chap nhan noi ket cua 1 Client");
				}
			}
			//ss.close();				
		}
		catch(IOException e) {
			System.out.println("Khong tao duoc Socket Server");
		}
		
	}

}

