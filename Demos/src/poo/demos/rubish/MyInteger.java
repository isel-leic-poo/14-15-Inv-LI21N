package poo.demos.rubish;

public class MyInteger {
	
	private final int value;
	
	private MyInteger(int value)
	{
		this.value = value; 
	}
	
	public int getValue()
	{
		return value;
	}
	
	public static MyInteger newMyInteger(int value)
	{
		return new MyInteger(value);
	}

}
