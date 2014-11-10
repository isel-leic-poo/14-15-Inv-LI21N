package poo.demos.rubish.vehicles;

public class VehiclesApp {

	public static void main(String[] args) 
	{
		Vehicle[] tripToRome = { 
			new Car(), new Plane(), new Car()
		};
		
		for(int i = 0; i < tripToRome.length; ++i)
			tripToRome[i].move();
	}
}
