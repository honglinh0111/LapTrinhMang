package Test;

public class Customer extends Person{
	
	int telephone;
	long buy;
	
	public Customer(String n, String address, int t, long b) {
		super(n, address); //thua ke thuoc tinh tu lop cha Person
		telephone = t;
		buy = b;
	}
	
	public void display() {
		super.display();
		System.out.print(", phone: "+telephone+ ", buy:"+buy);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer Linh = new Customer("Linh","Vinh Long",794246163,200000);
		Linh.display();
	}

}
