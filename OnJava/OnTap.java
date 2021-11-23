package Test;

import java.io.*;

public class OnTap {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int i=10;
//		String str = " nam yeu ";
//		char ch = 'm';
//		System.out.print('\n'+"Bai hat "+i+str+ch);
//	}
	
//	public static void main(String[] args) {
//		try {
//			System.out.print("Nhap 1 ky tu: ");
//			int ch = System.in.read(); // thu tu trong bang ma ASCII
//			System.out.print("Ky tu "+ (char)ch + " co ma ASCII = "+ch);
//		}
//		catch(Exception e) {
//			System.out.print("Error: " + e);
//		}
//	}

//	public static void main(String[] args) {// chuyen chuoi sang mang cac ky ty
//		String s = "Hong Linh";
//		byte b[] = s.getBytes();
//		System.out.print("Cac ky tu gom: ");
//		for(int i=0; i<b.length; i++)
//			System.out.print((char)b[i]+" ");
//	}
	
	public static void main(String[] args) {//Chuyen mang cac byte thanh chuoi
		byte b[] = new byte[50];
		int i = 0;
		for(byte x='A'; x<='a'; x++)
			b[i++]=x;
		String str = new String(b,0,i);
		System.out.print(str + " Chieu dai: "+str.length());
		
	}
	
}
