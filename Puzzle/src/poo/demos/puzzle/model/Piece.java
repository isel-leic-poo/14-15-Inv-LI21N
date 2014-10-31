package poo.demos.puzzle.model;

/**
 * Class whose instances represent puzzle pieces.
 * 
 * Puzzle pieces have an initial position (which is considered the correct 
 * piece position) and a current position. Positions are represented as instances of
 * {@link Position}, which contain rectangular coordinates (i.e. x and y) that must 
 * be positive values (i.e. >= 0).
 */
public class Piece {

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
	public Piece(int x, int y)
	{
		this(Position.fromCoordinates(x, y));
	}

	/**
	 * Initiates an instance with the given position.
	 * 
	 * @param position The instance's initial position
	 */
	public Piece(Position position)
	{
		this(position, position);
	}
	
	/**
	 * Initiates an instance with the given initial and current positions
	 * 
	 * @param initial the instance's initial position
	 * @param current the instance's current position
	 */
	public Piece(Position initial, Position current)
	{
		initialPosition = initial;
		currentPosition = current;
	}

	/**
	 * Gets the piece's initial position.
	 * 
	 * @return The instance's initial position
	 */
	public Position getInitialPosition() 
	{
		return initialPosition;
	}
	
	/**
	 * Gets the piece's current position.
	 * 
	 * @return The instance's current position
	 */
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
	
	/**
	 * Checks if the piece is at its correct (initial) position.
	 * 
	 * @return {@code true} if the piece is at its initial position, {@code false}
	 * otherwise 
	 */
	public boolean isAtCorrectPosition()
	{
		return getPosition().equals(getInitialPosition()); 
	}

	// Canonical methods
	
	/**
	 * {@see java.lang.Object#toString}
	 */
	@Override
	public String toString() 
	{
		return new StringBuilder("{ initial=")
			.append(getInitialPosition())
			.append("; current=")
			.append(getPosition())
			.append(" }")
			.toString();
	}	
	
	/**
	 * {@see java.lang.Object#hashCode}
	 */
	@Override
	public int hashCode() 
	{
		return this.toString().hashCode();
	}

	/**
	 * Checks if the instance is equivalent to the given one.
	 * Two piece instances are equivalent if their coordinates (initial and current)
	 * have the same values.  
	 * 
	 * @param other the other instance to use in the equivalence check
	 * @return {@code true} if the current instance is equivalent to the given one,
	 * {@code false} otherwise 
	 * 
	 * {@see java.lang.Object#equals}
	 */
	@Override
	public boolean equals(Object other) 
	{
		if(!(other instanceof Piece))
			return false;
		
		if(this == other)
			return true;
		
		Piece otherPiece = (Piece) other;
		return 	this.getInitialPosition().equals(otherPiece.getInitialPosition()) 
				&& this.getPosition().equals(otherPiece.getPosition()); 
	}
}
