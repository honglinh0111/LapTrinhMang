import java.net.*;
import java.io.*;

public class ClientDocSoc {

	public static void main(String[] args) {
		try {
			//Tao ra server va noi ket cong
			Socket s = new Socket("127.0.0.1",1234);
			System.out.println("Da noi ket den Server");
			//Tao ra 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true) {
				//Nhap 1 ky tu tu ban phim
				System.out.print("Nhap vao 1 ky tu (0->9):");
				int ch = System.in.read();
				System.in.skip(2);
				//Gui ky tu qua cho server
				os.write(ch);
				//Kiem tra dieu kien de thoat
				if(ch=='@') break;
				//Nhan ket qua tra ve tu server
				byte b[] = new byte[1000];
				int m = is.read(b);
				String kqua = new String(b,0,m);
				//hien thi kqua
				System.out.println("Ket qua la: "+kqua);
			}
			//dong ket noi
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Khong tim thay dia chi can noi ket");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		 
	}
	
}