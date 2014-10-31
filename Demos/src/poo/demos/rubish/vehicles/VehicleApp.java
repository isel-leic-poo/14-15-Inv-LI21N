package poo.demos.rubish.vehicles;

public class VehicleApp {

	public static void main(String[] args) 
	{
		Vehicle[] tripToRome = new Vehicle[] {
			new Car(), new Plane(), new Car()
		};
		
		for(int i = 0; i < tripToRome.length; ++i)
			tripToRome[i].move();
	}
}
