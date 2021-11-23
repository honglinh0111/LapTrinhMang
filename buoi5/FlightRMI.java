//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class FlightRMI extends UnicastRemoteObject implements FlightRMI_Itf{
	//Khai bao thuoc tinh
	private int sohieu;
	private String ngay, gio;
	private String noiDi, noiDen;
	private int tongSoGhe, slGheDaBan;
	//Ham xay dung
	public FlightRMI() throws RemoteException{
		super();
		sohieu = 0;
		ngay = "";
		gio = "";
		noiDi = "";
		noiDen = "";
		tongSoGhe = slGheDaBan = 0;
	}
	public FlightRMI(int sh, String d, String h, String ndi, String nden, int x, int y ) throws RemoteException{
		super();
		sohieu = sh;
		ngay = new String(d);
		gio = new String(h);
		noiDi = new String(ndi);
		noiDen = new String(nden);
		tongSoGhe = x;
		slGheDaBan = y;
	}
	//Ham cuc bo
	public void nhap() {
		Scanner kb= new Scanner(System.in);
		System.out.print("Nhap so hieu chuyen bay: ");
		sohieu = kb.nextInt(); kb.nextLine();
		System.out.print("Nhap ngay bay: ");
		ngay = kb.nextLine();
		System.out.print("Nhap gio bay: ");
		gio = kb.nextLine(); 
		System.out.print("Nhap noi di: ");
		noiDi = kb.nextLine();
		System.out.print("Nhap noi den: ");
		noiDen = kb.nextLine(); 
		System.out.print("Nhap tong so ghe: ");
		tongSoGhe = kb.nextInt();
		System.out.print("Nhap so luong ghe da ban: ");
		slGheDaBan = kb.nextInt();
	}
	public void hienThi() {
		System.out.print("\n----Thong tin chuyen bay----\nSo hieu chuyen bay: " + sohieu); System.out.print("\n");
		System.out.print("Thoi gian ngay " + ngay + "  luc " + gio); System.out.print("\n");
		System.out.print("Di tu: " + noiDi + " den: " + noiDen); System.out.print("\n");
		System.out.print("Tong so ghe: " + tongSoGhe); System.out.print("\n");
		System.out.print("So luong ghe da ban: " + slGheDaBan);System.out.print("\n");
		System.out.print("So luong ghe con trong: " + (int)(tongSoGhe - slGheDaBan));
	}

	//Ham goi tu xa
	public String flightInfo() {
		return "\nSo hieu chuyen bay: " + sohieu + "\n" +
				"Thoi gian ngay " + ngay + "  luc " + gio + "\n" +
				"Di tu: " + noiDi + " den: " + noiDen + "\n" +
				"Tong so ghe: " + (int)tongSoGhe + "\n" +
				"So luong ghe da ban: " + (int)slGheDaBan + "\n" +
				"So luong ghe con trong: " + (int)(tongSoGhe - slGheDaBan)				
				;
	}
	
	public void ticketBuyMethod(int a) {
		slGheDaBan += a;
	}
	public void ticketPayMethod(int b) {
		slGheDaBan -= b;
	}
}
