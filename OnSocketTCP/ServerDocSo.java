import java.net.*;
import java.io.*;

public class ServerDocSo {

	public static void main(String[] args) {
		try {
			//Tao server de noi ket, lang nghe
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Da khoi tao xong Server");
			while(true) { // Phuc vu nhieu client
				//chap nhan client noi ket
				Socket s = ss.accept();
				System.out.println("Co 1 Client da noi ket");
				//lay 2 stream in-out
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				while(true) { // Client nhap nhieu lan
					//nhan dl tu client
					int ch = is.read();
					System.out.println("Nhan tu Client: "+ch);
					//kiem tra dieu kien de thoat
					if(ch=='@') break;
					//xu ly dlieu
					String kq ="Chua biet";
					switch(ch) {
						case '0': kq="Khong"; break;
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
					//gui cho client
					byte b[] = kq.getBytes();
					os.write(b);
					
				}
				//dong ket noi
				s.close();
			}
			//ss.close();
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}

	}

}
