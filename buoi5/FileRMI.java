//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileRMI extends UnicastRemoteObject implements FileRMI_Itf{
	//Ham xay dung
	public FileRMI() throws RemoteException{
		super();
	}
	//Ham goi tu xa
	public int getLength(String filename) {//Lay kich thuoc file
		File f = new File(filename);
		if(f.exists() && f.isFile()) {
			int lenght = (int)f.length();
			return lenght;
		}
		return -1;
	}
	
	public byte[] getFile(String filename) {//Lay noi dung file
		try {
			File f = new File(filename);
			if(f.exists() && f.isFile()) {
				int len = (int)f.length();
				byte b[] = new byte[len];
				FileInputStream fis = new FileInputStream(filename);
				DataInputStream dis = new DataInputStream(fis);
				dis.readFully(b);
				fis.close();
				return b;
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		return null;
	}
	
}
