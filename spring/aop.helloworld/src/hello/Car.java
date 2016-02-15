package hello;

public class Car {

	private Engine engine;

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public int run(String name) {
		System.out.println("car.run...");
		return 2;
		// System.out.println(engine.getName());
	}
}
