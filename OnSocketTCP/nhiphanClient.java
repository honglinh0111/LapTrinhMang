import java.io.*;
import java.net.*;
import java.util.Scanner;

public class nhiphanClient {

	public static void main(String[] args) {
		try {
			//Tao noi ket den Ser cong..
			Socket s = new Socket("localhost",4567);
			System.out.print("Da noi ket den server");
			//Tao 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true) {//Client nhap nhieu lan
				//Nhap vao mot chuoi so nguyen
				System.out.print("Nhap vao chuoi so nguyen: ");
				Scanner kb = new Scanner(System.in);
				String str = kb.nextLine();
				//Gui qua server
				os.write(str.getBytes());
				//Kiem tra dkien thoat
				if(str.equals("EXIT")) break;
				//Nhan kqua tu server
				byte b[] = new byte[1000];
				int n = is.read(b);
				String kq = new String(b,0,n);
				System.out.println("Ket qua chuyen sang chuoi nhi phan: "+kq);
			}
			//dong noi ket
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.print("Khong tim thay dia chi server de noi ket");
		}
		catch(IOException e) {
			System.out.print("Loi nhap xuat: Dau vao phai la mot chuoi so nguyen");
		}
	}

}
