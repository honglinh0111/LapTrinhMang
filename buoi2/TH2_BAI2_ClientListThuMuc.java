//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class TH2_BAI2_ClientListThuMuc {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("localhost",8888);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is); // Nhan du lieu tu Server
			PrintWriter pw = new PrintWriter(os); // Gui du lieu cho Server
			
			Scanner kb = new Scanner(System.in);
			System.out.println("Nhap ten thu muc o Server can list: ");
			String tenthumuc = kb.nextLine();
			
			pw.println("LIST "+tenthumuc); pw.flush();
			
			String chuoisoluong = sc.nextLine();
			int n = Integer.parseInt(chuoisoluong);
			
			if(n == -1) {
				System.out.println("Thu muc "+ tenthumuc+ " khong ton tai.");
			}
			else {
				if(n == 0) {
					System.out.println("Thu muc "+ tenthumuc + " rong.");
				}
				else {
					// Nhan n dong tiep theo
					System.out.println("Thu muc "+tenthumuc+ " bao gom: ");
					try {
						for(int i=0; i<=n; i++) {
							String kq = sc.nextLine();
							System.out.println(kq);
						}
					}
					catch(NoSuchElementException e) {
						System.out.println(e);
					}
					
				}
			}
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Khong tim thay dia chi Server noi ket");
		}
		catch(IOException e){
			System.out.println("Khong tao duoc Socket Client");
		}
		
		
	}
}	