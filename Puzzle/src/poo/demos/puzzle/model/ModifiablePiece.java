package poo.demos.puzzle.model;

/**
 * Class whose instances represent puzzle pieces which support state mutation operations.
 * 
 * {@link ModifiablePiece} instances are used in the grid's implementation and support 
 * operations for modifying the piece's state, in particular its current position.
 * 
 * This {@link Piece} realization could be implemented as a private nested class of the 
 * {@link Grid} class because it is the only existing source code dependency, but this solution 
 * would lead to a significant increase of the size of {@link Grid}'s source code, and therefore 
 * it is implemented as a top level class instead.
 * 
 * Because the class has package visibility, and therefore it will never be used elsewhere,
 * most operations do not perform argument checking.
 */
class ModifiablePiece extends Piece {

	/**
	 * The instance's initial position.
	 */
	private final Position initialPosition;
	
	/**
	 * The instance's current position.
	 */
	private Position currentPosition;
	
	/**
	 * Initiates an instance with the given coordinates.
	 * 
	 * @param x The horizontal coordinate value
	 * @param y The vertical coordinate value
	 * @throws IllegalArgumentException if either coordinate has a negative value
	 */
	public ModifiablePiece(int x, int y)
	{
		this(Position.fromCoordinates(x, y));
	}

	/**
	 * Initiates an instance with the given position.
	 * 
	 * @param position The instance's initial position
	 */
	public ModifiablePiece(Position position)
	{
		this(position, position);
	}
	
	/**
	 * Initiates an instance with the given initial and current positions
	 * 
	 * @param initial the instance's initial position
	 * @param current the instance's current position
	 */
	public ModifiablePiece(Position initial, Position current)
	{
		initialPosition = initial;
		currentPosition = current;
	}

	/**
	 * Gets the piece's initial position.
	 * 
	 * @return The instance's initial position
	 */
	@Override
	public Position getInitialPosition() 
	{
		return initialPosition;
	}
	
	/**
	 * Gets the piece's current position.
	 * 
	 * @return The instance's current position
	 */
	@Override
	public Position getPosition() 
	{
		return currentPosition;
	}
	
	/**
	 * Moves the instance's to the given position.
	 * 
	 * @param newPosition the instance's new position
	 */
	public void moveTo(Position newPosition)
	{
		currentPosition = newPosition;
	}
	
	/**
	 * Moves the instance by the given distance.
	 * 
	 * @param delta the distance that the instance will move. 
	 * @throws IllegalStateException if the resulting position is an illegal one,
	 * that is, it has a negative value in one of its coordinates
	 */
	public void moveBy(Delta delta)
	{
		try {
			currentPosition = Position.fromCoordinates(currentPosition.X + delta.X, currentPosition.Y + delta.Y);
		}
		catch(IllegalArgumentException invalidDelta)
		{
			// Convert exception to convey the correct semantics 
			throw new IllegalStateException(invalidDelta);
		}
	}
	
}
