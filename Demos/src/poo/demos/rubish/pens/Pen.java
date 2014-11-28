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
	public boolean equals(Object another)
	{
		if(!(another instanceof Pen))
			return false;
		
		Pen other = (Pen) another;
		if(this == other)
			return true;
		
		return this.getClass() == other.getClass() && 
				this.color == other.color && 
				this.inkPercentage == other.inkPercentage;
	}
	
	@Override
	public String toString()
	{
		return color + " ; " + inkPercentage;
	}
	
	@Override
	public int hashCode() 
	{
		return (this.getClass() + toString()).hashCode();
	}
}
