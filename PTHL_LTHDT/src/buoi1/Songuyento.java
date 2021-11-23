package buoi1;//bai 6

import java.util.Scanner;

public class Songuyento {
	private static Scanner sc;
	public static boolean nguyento(int n) {
		if(n<2) {
			return false;
		}			
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0)
				return false;
		}return true;
	}
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Nhap mot so: ");
		int n=sc.nextInt();	
		if(nguyento(n))
			System.out.print(n+"la so nguyen to");
		else
			System.out.print(n+"khong la so nguyen to");
		System.out.print("\nSo nhi phan cua "+n+" la:"+Integer.toBinaryString(n));

	}

}
