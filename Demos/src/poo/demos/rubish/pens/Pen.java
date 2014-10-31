package poo.demos.rubish.pens;

public class Pen {

	protected final String color;
	protected int inkPercentage;

	public Pen(String color, int initialPercentage)
	{
		this.color = color;
		inkPercentage = initialPercentage;
	}
	
	public Pen(String color)
	{
		this(color, 100);
	}
	
	public Pen()
	{
		this("black", 100);
	}

	public String write(String writting)
	{
		if(inkPercentage == 0)
			return "";
		
		inkPercentage -= 1;
		return "In " + color + " -> " + writting;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof Pen))
			return false;
		
		Pen another = (Pen) other;
		return color == another.color && inkPercentage == another.inkPercentage;
	}
	
	@Override
	public String toString()
	{
		return color + "; " + inkPercentage;
	}
}
