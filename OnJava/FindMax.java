package Test;

public class FindMax {

	public static void main(String[] args) {
		int vitri = -1;
		int max = Integer.MIN_VALUE;
		try {
			max = Integer.valueOf(args[0]).intValue();
			vitri = 0;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.print("Chua nhap tham so"); return;
		}
		catch(NumberFormatException e) {
			System.out.print("Sai dinh dang tai vi tri so thu 1");
		}
		for(int i=1; i<args.length; i++) {
			try {
				int x = Integer.valueOf(args[i]).intValue();
				if(vitri==-1) {//chua tim duoc max ban dau
					max = x;
					vitri = i;
				}else
					if(max<x) {
						max = x;
						vitri = i;
					}
			}catch(NumberFormatException e) {
				System.out.print("Sai dinh dang tai vi tri so thu "+(i+1));
			}
		}
		if(vitri != -1) {
			System.out.print("So lon nhat la: "+max+", tai vi tri: "+ (vitri+1) );
		}else {
			System.out.print("Trong day so khong co so nguyen.");
		}
		
	}

}
