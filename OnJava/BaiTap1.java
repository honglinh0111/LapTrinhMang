package Test;

import java.util.Scanner;

public class BaiTap1 {

	public static float checkDouble() {
		Scanner sc = new Scanner(System.in);
		String s;
		float x = 0;
		do {
			try {
				s = sc.nextLine();
				x = Float.parseFloat(s);
			}
			catch (Exception ex) {
				System.out.print("Nhap sai kieu - Nhap lai");
				x = Integer.MAX_VALUE;
			}
		}while(x == Integer.MAX_VALUE);
		
		return x;
	}
	
	public static int checkInt() {
		Scanner sc = new Scanner(System.in);
		String s;
		int n = 0;
		do {
			try {
				s = sc.nextLine();
				n = Integer.parseInt(s);
			}
			catch (Exception ex) {
				System.out.print("Nhap sai kieu - Nhap lai");
				n = Integer.MAX_VALUE;
			}
		}while(n == Integer.MAX_VALUE);
		
		return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float x;
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("x="); x = BaiTap1.checkDouble();
		System.out.print("n="); n = BaiTap1.checkInt();
		System.out.print(Math.pow(x, n));
	}

}
