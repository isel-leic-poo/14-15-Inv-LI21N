package poo.demos.rubish;

public class Pen {

	private final String color;
	private int inkPercentage;
	
	public Pen(String color)
	{
		this.color = color;
		inkPercentage = 100;
	}

	public String write(String writting)
	{
		inkPercentage -= 1;
		return "In " + color + " -> " + writting;
	}
}
