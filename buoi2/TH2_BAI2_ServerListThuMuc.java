import java.io.*;
import java.net.*;
import java.util.Scanner;

class TH2_BAI2_ServerListThuMuc {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("Da khoi tao xong Server cong 8888");
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			// Nhan cau lenh LIST + tenthumuc tu Client
			String caulenh = sc.nextLine();
			String tenthumuc = caulenh.substring(5); // Lay ten thu muc tu vi tri thu 5
			File f = new File(tenthumuc);
			if (f.exists() && f.isDirectory()) {
				String kq[] = f.list(); // Mang cac String
				int n = kq.length;
				pw.println(n); pw.flush(); // Gui so luong file + thumuc
				// Gui n dong tiep theo la ten file va thu muc con
				for(int i=0; i<=n; i++) {
					try {
						File temp = new File(tenthumuc + "/" + kq[i]);
						if(temp.isFile()) {
							pw.println(kq[i]); pw.flush();
						}
						else {
							pw.println("[" + kq[i] + "]"); pw.flush();
						}
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println(e);
					}
				}
			}
			else{
				pw.println(-1); pw.flush();
			}
			//dong noi ket
			s.close();
		}
		catch(IOException e) {
			System.out.println("Khong tao duoc Server Socket");
		}
		
	}
}	