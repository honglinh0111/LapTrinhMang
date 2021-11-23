import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ListServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			System.out.println("Da khoi tao thanh cong Server Socket");
			
			Socket s = ss.accept();
			System.out.println("Da noi ket voi 1 Client");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			String caulenh = sc.nextLine();
			String thumuc = caulenh.substring(5);
			
			File f = new File(thumuc);
			if(f.isDirectory() && f.exists()) {
				String kq[] = f.list();
				int n = kq.length;
				pw.println(n); pw.flush();
				
				for(int i=0; i<=n; i++) {
					try {
						File tmp = new File(thumuc + "/" + kq[i]);
						if(tmp.isFile()) {
							pw.println(kq[i]); pw.flush();
						}
						else {
							pw.println("[ " + kq[i]+ "]"); pw.flush();
						}
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			else {
				pw.println(-1); pw.flush();
			}
			s.close();
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}

	}

}
