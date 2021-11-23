package LTHDT;//bai 3

public class TongsothucDS {

	public static void main(String args[]) {
		String a[]= {"3.4","7.5","6a.5","1.0"};
		Double tong=0.0,  n=0.0;
		for(int i=0;i<a.length;i++) {
			try {
				n=Double.parseDouble(a[i]);}
			catch(Exception e) {
				n=0.0;
			}
		tong+=n;	
		}
		System.out.print("Tong= "+tong);
	}

}
