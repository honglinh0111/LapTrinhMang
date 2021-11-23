package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BaiTap3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.print("Nhap ten va duong dan file: ");
		s = sc.nextLine();
		
		try {
			FileInputStream input = new FileInputStream(s);
			byte[] bytes = new byte[50];
			int bytesReaded = input.read(bytes); //file da doc duoc chua
			
			while (bytesReaded != -1) {
				for(int j=0; j<bytesReaded; j++) {
					System.out.print((char) bytes[j]);
				}
				bytesReaded = input.read(bytes);
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
