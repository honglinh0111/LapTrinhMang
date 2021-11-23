import java.io.*;
import java.net.*;

public class nhiphanServer {

	public static void main(String[] args) {
		try {
			//Tao sockerserver
			ServerSocket ss = new ServerSocket(4567);
			System.out.println("Da khoi tao thanh cong socket server");
			while(true) {//phuc vu nhieu client
				//Chap nhan noi ket
				Socket s = ss.accept();
				System.out.println("Da noi ket 1 client");
				//Tao 2 stream
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				while(true) {
					//nhan dlieu tu client
					byte b[] = new byte[1000];
					int n = is.read(b);
					String chuoi = new String(b,0,n);
					System.out.println("Nhan tu Client: "+chuoi);
					//kiem tra dlien thoat
					if(chuoi.equals("EXIT")) break;
					//xu ly yeu cau
					int so = Integer.parseInt(chuoi);
					String nhiphan = Integer.toBinaryString(so);
					//gui kqua cho client
					byte b1[] = nhiphan.getBytes();
					os.write(b1);
				}
				//dong noi ket
				s.close();
			}
			//ss.close();
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}

}
