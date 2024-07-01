package com.tightcouling;


class PetrolEngine{
	void show() {
		System.out.println("This is Petrol Engine Car.");
	}
}
class DesielEngine{
	void show() {
		System.out.println("This is Desiel Engine Car.");
	}
}
class Car{
	PetrolEngine petrolEngine = new PetrolEngine();
	void move(){
		System.out.println("This car is moving with ");
		petrolEngine.show();
	}
}
public class TightCoupling {
	public static void main(String[] args) {
		Car c = new Car();
		c.move();
//		If we Want to change our engine then we have to internally change the car engine.
//		hence it also called hard coded.
//		When we are directly creating a object in another class it is called tight coupling.
	}
	
}
