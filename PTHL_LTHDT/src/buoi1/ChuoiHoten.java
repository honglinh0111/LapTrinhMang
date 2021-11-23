package buoi1;//bai 7

import java.util.Scanner;

public class ChuoiHoten {
	private static Scanner sc;
	public static String catTen(String hten) {
		String ten=hten.trim();
		ten=ten.substring(ten.lastIndexOf(" ")+1);
		return ten;
	}
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Nhap ho ten: ");
		String hten=sc.nextLine();
		String ten=ChuoiHoten.catTen(hten);
		System.out.print("Phan ten: "+ten);
	}
	
}
