package buoi1;//bai 4

import java.util.Scanner;

public class Tong2so {
	private static Scanner sc;
	public static int input() {
		int n=0;
		sc = new Scanner(System.in);
		do {
			System.out.print("");
			String s= sc.nextLine();
			try {
				n=Integer.parseInt(s);
			}
			catch(Exception e) {
				n=Integer.MAX_VALUE;
				System.out.print("Ban nhap lai: ");
			}
		}
		while(n==Integer.MAX_VALUE);
		return n;	
	}
	public static void main(String[] args) {
		System.out.print("Nhap a= ");
		int a=Tong2so.input();
		System.out.print("Nhap b= ");
		int b=Tong2so.input();
		System.out.print("=>"+a+"+"+b+"="+(a+b));
	}

}
