//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.net.*;
import java.io.*;

public class ServerDocSo {

	public static void main(String[] args)  {
		
		try {
			ServerSocket ss = new ServerSocket(999);
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
			}
			//ss.close();
		}
		catch(IOException e) {
			System.out.print("Khong tao duoc Socket Server");
		}
		
	}

}

