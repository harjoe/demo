package hello;

public class Car {

	private Engine engine;

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void run() {
		System.out.println("car.run");
		System.out.println(engine.getName());
	}
}
