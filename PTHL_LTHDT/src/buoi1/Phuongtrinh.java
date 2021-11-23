package buoi1;//bai 5

import java.util.Scanner;

public class Phuongtrinh {
	private static Scanner sc;
	public void giaiptbac1(int a, int b) {
		if(a==0)
			if(b==0)
				System.out.print("\nPhuong trinh vo so nghiem");
			else 
				System.out.print("\nPhuong trinh vo nghiem");
		else
			System.out.print("\nPhuong trinh theo 2 tham so a va b co nghiem x= "+(-(float)(b/a)));
	}
	public void giaiptbac2(int a, int b, int c) {
		if(a==0)
			giaiptbac1(b,c);
		else {
			int denta=b*b-4*a*c;
			if(denta<0)
				System.out.print("Phuong trinh vo nghiem");
			else {
				if(denta==0)
					System.out.print("Phuong trinh co nghiem kep x1 =x2 = "+(-(float)(b/2*a)));
				else {
					System.out.print("Phuong trinh co 2 nghiem phan biet x1 x2");
					System.out.print("Nghiem x1= "+((-b+Math.sqrt(denta))/(2*a)));
					System.out.print("Nghiem x2= "+((-b-Math.sqrt(denta))/(2*a)));	
				}									
			}
		}
	}
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Phuongtrinh t= new Phuongtrinh();
		System.out.print("Nhap a= ");
		int a=sc.nextInt();
		System.out.print("Nhap b= ");
		int b=sc.nextInt();
		System.out.print("Nhap c= ");
		int c=sc.nextInt();
		t.giaiptbac2(a, b, c);
		t.giaiptbac1(a, b);
	}

}
