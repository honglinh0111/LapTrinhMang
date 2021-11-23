package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BaiTap2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap Ten va duong dan: ");
		String s;
		s = sc.nextLine();
		try {
			FileInputStream input = new FileInputStream(s);
			int i = input.read();
			while (i != -1) {
				System.out.print((char)i);
				i = input.read();
			}
			input.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
//D:\HocJava\vidu.txt

}
