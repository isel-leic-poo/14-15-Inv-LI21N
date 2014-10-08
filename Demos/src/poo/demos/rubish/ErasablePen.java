package poo.demos.rubish;

public class ErasablePen extends Pen {

	public ErasablePen(String color) 
	{
		super(color);
	}
	
	public void erase()
	{
		System.out.println("Erased!");
	}
}
