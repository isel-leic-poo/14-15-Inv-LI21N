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
			case STEP_RIGHT: return STEP_LEFT;
			default: throw new InternalError();
		}
	}
	
	/**
	 * Gets the instance that represents the given coordinates' variation, 
	 * or null if none exists.
	 * 
	 * Note that the implementation does not ensure that a {@code null} value 
	 * is always returned for invalid coordinates (a best effort approach).
	 * It is the responsibility of the call site to ensure that the coordinates 
	 * are within the represented range.
	 * 
	 * @param dX The horizontal variation
	 * @param dY The vertical variation
	 * @return The instance that represents the given variation 
	 */
	public static Delta getInstanceFromCoordinates(int dX, int dY)
	{
		if(Math.abs(dX + dY) != 1) return null;
		int index = Math.abs(dX) * 2 + Math.abs((dX + dY) - 1) / 2;
		return index < 0 || index >= values().length ? null : values()[index];
	}
}