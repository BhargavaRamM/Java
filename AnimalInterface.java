import java.util.*;

 interface Animal {
	void age();
	void weight();
	void display();
	void sound();
}
 abstract class Dogs implements Animal {
	public abstract void sound();
	public abstract void doTricks();
}

 abstract class Birds implements Animal {
	public abstract void sound();
	public abstract void fly();
}

class chihuahuas extends Dogs {
	public void sound() {
		System.out.println(" Yo quiero taco bell ");
	}
	public void doTricks() {
		System.out.println("Chihuahuas doing tricks like sit up and lie down.");
	}
	public void display() {
		System.out.println("chihuahuas at display");
	} 
	public void age() {
		System.out.println("Age of chihuahua is 3 years...");
	}
	public void weight() {
		System.out.println("Weight of chihuahua is 3lbs");
	}
}

class FrenchPoodle extends Dogs {
	public void sound() {
		System.out.println(" Bonjour mon ami ");
	}
	public void doTricks() {
		System.out.println("FrenchPoodle can sit up, lie down, and shake hands. ");
	}
	public void display() {
		System.out.println("FrenchPoodle at display.");
	}
	public void age() {
		System.out.println("Age of FrenchPoodleis 3 years...");
	}
	public void weight() {
		System.out.println("Weight of FrenchPoodle is 10lbs");
	}
}

class Robins extends Birds {
	public void sound() {
		System.out.println(" chirp chirp chirp chirp... ");
	}
	public void fly() {
		System.out.println("Robins can fly...");
	}
	public void display() {
		System.out.println("Robins at display..");
	}
	public void age() {
		System.out.println("Age of Robins is 3 months...");
	}
	public void weight() {
		System.out.println("Weight of Robins is 100 grams..");
	}
}

class BlueBirds extends Birds {
	public void sound() {
		System.out.println(" eek eek eek eek eek eek... ");
	}
	public void fly() {
		System.out.println("BlueBirds can fly as well.");
	}
	public void display() {
		System.out.println("BlueBirds at display");
	}
	public void age() {
		System.out.println("Age of BlueBirds is 3 months...");
	}
	public void weight() {
		System.out.println("Weight of BlueBirds is 150grams");
	}
}

public class AnimalInterface {
	public static void main(String[] args) {
		Animal[] objects = {new chihuahuas(), new FrenchPoodle(),new Robins(), new BlueBirds()};
		Random r = new Random();
		int x = r.nextInt(4);
		objects[x].sound();
	}
}