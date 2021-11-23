package buoi1;//bai 3

public class TongDSthuc {
	public static void main(String[] args) {
		Double tong=0.0,  n=0.0;
		for(int i=0;i<args.length;i++) {
			try {
				n=Double.parseDouble(args[i]);}
			catch(Exception e) {
				n=0.0;
			}
		tong+=n;	
		}
		System.out.print("Tong= "+tong);
		
	}
}
