package Test;

public class Person {
	
	//Thuoc tinh ten va diachi
	String name;
	String address;
	
	//Ham xay dung 
	Person(String n, String address){
		name = n;
		this.address = address;
	}
	//Ham hien thi ten va diachi ra man hinh
	void display() {
		System.out.print(name+" is at "+address);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person Linh = new Person("Linh","Vinh Long");
		Linh.display();
	}

}
