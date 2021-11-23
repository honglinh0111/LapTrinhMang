import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.rmi.RemoteException;

public class DiemRMI extends UnicastRemoteObject implements DiemRMI_Itf {
	//Khai bao thuoc tinh
	private int x;
	private int y;
	//Dinh nghia ham xay dung
	public DiemRMI() throws RemoteException{
		super();
		x = y = 0;
	}
	public DiemRMI(int h, int t) throws RemoteException{
		super();
		x = h;
		y = t;
	}
	public DiemRMI(int m) throws RemoteException{
		super();
		x = y = m;
	}
	//Dinh nghia cac ham cuc bo
	public void nhap() {
		Scanner kb= new Scanner(System.in);
		System.out.print("Nhap hoanh do: ");
		x = kb.nextInt();
		System.out.print("Nhap tung do: ");
		y = kb.nextInt();
	}
	public void hienThi() {
		System.out.print("(" + x + "," + y + ")");
	}
	//Dinh nghia cac ham goi tu xa
	public String layToaDo() {
		return ("(" + x + "," + y + ")");
	}
	public void ganToaDo(int h, int t) {
		x = h;
		y = t;
	}
	public void doiDiem(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
}