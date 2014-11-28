package poo.demos.rubish;

public enum Variation {

	UP(0, -1), DOWN(0, 1);
	
	public final int x;
	public final int y;
	
	private Variation(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}