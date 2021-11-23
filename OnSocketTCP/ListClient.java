import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1",6666);
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			System.out.print("Nhap then thu muc can list danh sach: ");
			Scanner kb=new Scanner(System.in);
			String tenthumuc = kb.nextLine();
			String caulenh = "LIST "+tenthumuc;
			
			pw.println(caulenh); pw.flush();
			
			String soluong = sc.nextLine();
			int n = Integer.parseInt(soluong);
			
			if(n==-1) {
				System.out.println("Thu muc " + tenthumuc + " khong ton tai");
			}
			else
				if(n==0) {
					System.out.println("Thu muc " + tenthumuc + " rong");
				}
				else {
					System.out.println("Thu muc " +tenthumuc+ " bao gom: ");
					try {
						for(int i=0; i<=n; i++) {
							String kqua = sc.nextLine();
							System.out.println(kqua);
						}
					}
					catch(NoSuchElementException e) {
						System.out.println(e.getMessage());
					}
				}
		}
		catch(UnknownHostException e) {
			System.out.println("Loi khong tim thay dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		

	}

}
