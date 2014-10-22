package poo.demos.puzzle.model;
/**
 * Class whose instances represent puzzle moves.
 */
public class Move {
	
	/**
	 * The move's coordinates variation.
	 */
	public final Delta delta;
	
	/**
	 * The piece to which the move is to be applied.
	 */
	public final Piece target;
	
	/**
	 * Initiates an instance with the given arguments.
	 * 
	 * @param delta The variation to apply to the piece 
	 * @param piece The piece to which the move is to be applied
	 * @throws IllegalArgumentException if either argument is {@code null}
	 */
	public Move(Delta delta, Piece piece)
	{
		if(delta == null || piece == null)
			throw new IllegalArgumentException();
		
		this.delta = delta;
		this.target = piece;
	}
	
	/**
	 * Creates and returns the inverse move (i.e. relative to the 
	 * current move instance).
	 * 
	 * @return The inverse move 
	 */
	public Move getReverseMove()
	{
		return new Move(delta.getReverse(), this.target);
	}

	/**
	 * {@see java.lang.Object#hashCode()}
	 */
	@Override
	public int hashCode() 
	{
		return this.toString().hashCode();
	}

	/**
	 * Checks if the instance is equivalent to the given one.
	 * Two move instances are equivalent if their delta is equivalent and 
	 * they refer to the same piece instance.
	 * 
	 * {@see java.lang.Object#equals(Object)}
	 * 
	 * @param other the other instance to use in the equivalence check
	 * @return {@code true} if the current instance is equivalent to the given one,
	 * {@code false} otherwise 
	 */
	@Override
	public boolean equals(Object other) 
	{
		if(!(other instanceof Move))
			return false;
		
		Move otherPiece = (Move) other;
		if(this == other)
			return true;
		
		return this.delta.equals(otherPiece.delta) && this.target == otherPiece.target;
	}

	/**
	 * {@see java.lang.Object#toString()}
	 */
	@Override
	public String toString() 
	{
		return "Move " + target.toString() + " " + this.delta.toString();
	}
}
