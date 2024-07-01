package com.loosecoupling;

interface Engine{
	void show();
}
class PetrolEngine implements Engine{
	public void show() {
		System.out.println("This is Petrol Engine");
	}
}
class DesielEngine implements Engine{
	public void show() {
		System.out.println("This is Desiel Engine");
	}
}
class Car { 
	Engine e;
	Car(Engine e){
		this.e = e;
	}
	void move() {
		System.out.print("This is Currently Moving with ");
		e.show();
	}
}
public class LooseCoupling {
	public static void main(String[] args) {
	
		Car c =new Car(new PetrolEngine());
		c.move();
	}
	

}
