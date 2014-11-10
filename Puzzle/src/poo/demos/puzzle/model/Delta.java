package poo.demos.puzzle.model;

/**
 * Enumeration of valid displacements of puzzle pieces.
 * Instances of this class are immutable.
 */
public enum Delta {

	/**
	 * The existing enumeration instances. Notice that the order of declaration
	 * is relevant: it is used to compute the reverse delta.
	 */
	STEP_DOWN(0,1), STEP_UP(0,-1), STEP_RIGHT(1,0), STEP_LEFT(-1,0); 
	
	/**
	 * The horizontal delta
	 */
	public final int X;
	
	/**
	 * The vertical delta
	 */
	public final int Y;
	
	/**
	 * Initiates an instance with the given arguments.
	 * 
	 * @param dX The horizontal delta
	 * @param dY The vertical delta
	 */
	private Delta(int dX, int dY)
	{
		X = dX;
		Y = dY;
	}
	
	/**
	 * Gets this instance's reverse delta, that is, UP.getReverse() produces DOWN,
	 * LEFT.getReverse() produces RIGHT, and vice-versa. 
	 * 
	 * @return The reverse delta of the this instance.
	 */
	public Delta getReverse()
	{
		switch(this)
		{
			case STEP_UP: return STEP_DOWN;
			case STEP_DOWN: return STEP_UP;
			case STEP_LEFT: return STEP_RIGHT;
			default: return STEP_LEFT;
		}
	}
	
	/**
	 * Gets the instance that represents the given coordinates' variation, 
	 * or null if none exists.
	 * 
	 * @param dX The horizontal variation
	 * @param dY The vertical variation
	 * @return The instance that represents the given variation, or {@code null} 
	 * if none exists 
	 */
	public static Delta getInstanceFromCoordinates(int dX, int dY)
	{
		// Is it a valid delta?
		if(Math.abs(dX) + Math.abs(dY) != 1) 
			return null;
		
		// Is it a vertical delta?
		if(dX == 0)
			return dY == -1 ? STEP_UP : STEP_DOWN;
		
		// It's an horizontal delta
		return dX == -1 ? STEP_LEFT : STEP_RIGHT;
	}
}