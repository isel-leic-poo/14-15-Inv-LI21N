package poo.demos.rubish;

public class CheapPen extends Pen {

	public CheapPen(String color) 
	{
		super(color);
	}

	@Override
	public String write(String message)
	{
		if(inkPercentage == 0)
			return "";
		
		inkPercentage -= 10;
		return "In " + color + " -> " + message;
	}
}
