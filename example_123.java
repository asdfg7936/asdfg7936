package example01;

import java.util.ArrayList;

public class example_123 {

	public static void main(String[] args) {
		Dog dog1 =  new Dog("±î¹Ì","°ËÁ¤»ö",10.2);
		Dog dog2 =  new Dog("²¿¹Ì","Èò»ö",9.9);
		Cat cat1 = new Cat("Ä¡Áî","³ë¶õ»ö",9.9);
		Cat cat2 = new Cat("Â¯ÀÌ","°ËÁ¤»ö",9.9);
		Chicken chicken1 = new Chicken("´ß", "Èò»ö", 1);
		Chicken chicken2 = new Chicken("´ß", "°ËÁ¤»ö", 1);
		ArrayList<Animal> A_List = new ArrayList<>();
		A_List.add(dog1);
		A_List.add(dog2);
		A_List.add(cat1);
		A_List.add(cat2);
		A_List.add(chicken1);
		A_List.add(chicken2);
		for(int i=0;i<A_List.size();i++) {
			Animal animal = A_List.get(i);
			animal.speak();
		}
		
		
	}
}
class Animal{
	String name;
	String color;
	double kg;
	Animal(String name,String color, double kg){
		this.name = name;
		this.color = color;
		this.kg =kg;
	}
	public void speak() {
		System.out.println("µ¿¹°ÀÇ ¿ïÀ½¼Ò¸®");
	}
}

class Dog  extends Animal{

	Dog(String name, String color, double kg) {
		super(name, color, kg);
		// TODO Auto-generated constructor stub
	}
	public void speak() {
		System.out.println("¸Û¸Û!");
	}
}
class Cat  extends Animal{

	Cat(String name, String color, double kg) {
		super(name, color, kg);
		// TODO Auto-generated constructor stub
	}
	public void speak() {
		System.out.println("¾ß¿Ë~");
	}
}
class  Chicken  extends Animal{

	Chicken(String name, String color, double kg) {
		super(name, color, kg);
		// TODO Auto-generated constructor stub
	}
	public void speak() {
		System.out.println("²¿²¿´ì!");
	}
}