package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BaiTap4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.print("Nhap ten va duong dan file: ");
		s = sc.nextLine();
		Scanner sc2 = new Scanner(new FileInputStream(s));
		do {
			try {
				System.out.println(sc2.nextLine());
			}
			catch(NoSuchElementException e) {
				break;
			}
		}while(true);
	}

}
