package poo.demos.puzzle.model;

/**
 * Abstract class used to represent puzzle pieces.
 * 
 * Puzzle pieces have an initial position (which is considered the correct 
 * piece position) and a current position. Positions are represented as instances of
 * {@link Position}, which contain rectangular coordinates (i.e. x and y) that must 
 * be positive values (i.e. >= 0).
 * 
 * The {@link Piece} abstraction serves the purpose of increasing the solution's robustness 
 * because it does not provide operations that mutate the state of the instance, and therefore it
 * is appropriate to use it at the {@link Grid}'s public interface. 
 * 
 * <ul>
 * There are two realizations of this abstractions: 
 * <li> {@link ModifiablePiece} whose instances are used in the grid's implementation and that 
 * support operations for modifying the piece's state, in particular its current position; </li>
 * <li> {@link UnmodifiablePiece} which does not provide state modification operations and that 
 * delegates the remaining operations to the underlying modifiable instance. </li>
 * </ul> 
 * 
 * These realizations could be implemented as private nested classes of the {@link Grid} class because
 * it is the only class who has any dependencies to them. This solution would lead to a significant 
 * increase of the size of {@link Grid}'s source code, and therefore both realizations are instead 
 * implemented as top level classes, with package visibility.      
 */
public abstract class Piece {

	/**
	 * Gets the piece's initial position.
	 * 
	 * @return The instance's initial position
	 */
	public abstract Position getInitialPosition(); 
	
	/**
	 * Gets the piece's current position.
	 * 
	 * @return The instance's current position
	 */
	public abstract Position getPosition(); 
	
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
	 * Two piece instances are equivalent if they are of the same concrete type and if 
	 * their coordinates (initial and current) have the same values.  
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
		if(this == other)
			return true;
		
		if(other == null || !(other instanceof Piece))
			return false;
		
		Piece otherPiece = (Piece) other;
		return 	this.getInitialPosition().equals(otherPiece.getInitialPosition()) 
				&& this.getPosition().equals(otherPiece.getPosition()); 
	}
}
