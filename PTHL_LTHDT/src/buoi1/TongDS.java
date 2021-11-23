package buoi1;//bai 8

import java.util.Scanner;

public class TongDS {
	int a[];
	private Scanner sc;
	private static Scanner sc2;
	public void nhap() {
		sc = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua mang: ");
		int n=sc.nextInt();
		a=new int[n];
		for(int i=0;i<a.length;i++) {
			System.out.print("Nhap phan tu thu "+(i+1)+": ");
			a[i]=sc.nextInt();
		}
	}
	public void in() {
		for(int x:a)
			System.out.print(x+" ");
	}
	public int dem(int x) {
		int count=0;
		for(int e:a)
			if(e==x)
				count++;
		return count;
	}
	public void sapxep() {
		int temp;
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.print("Danh sach sau khi sap xep: ");
	}
	public static void main(String[] args) {
		TongDS t=new TongDS();
		t.nhap();
		t.in();
		System.out.print("Nhap phan tu can dem: ");
		sc2 = new Scanner(System.in);
		int x=sc2.nextInt();
		int c=t.dem(x);
		System.out.println("So phan tu "+x+" trong danh sach la "+c);
		t.sapxep();
		t.in();
	}

}
