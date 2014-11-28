package poo.demos.rubish.vehicles;

public abstract class Vehicle {
	
	public abstract String motionMedium();
	
	public void move()
	{
		System.out.println("Moving through " + motionMedium());
	}
}
