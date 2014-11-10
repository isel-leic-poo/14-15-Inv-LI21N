package poo.demos.puzzle.model;

/**
 * Class used to increase the robustness of the solution.
 * 
 * {@link ModifiablePiece} instances which are used internally are never directly accessed
 * from the outside. Instead, the {@link Grid} implementation always produces
 * instances of {@link UnmodifiablePiece}, thus preventing direct access to the mutable state.
 * 
 * This {@link Piece} realization could be implemented as a private nested class of the 
 * {@link Grid} class because it is the only existing source code dependency, but this solution 
 * would lead to a significant increase of the size of {@link Grid}'s source code, and therefore 
 * instead, it is implemented as a top level class with package accessibility. 
 * 
 * The solution is based in the Decorator Design Pattern, thereby not requiring 
 * defensive copying.
 * 
 * Because the class has package visibility, and therefore it will never be used elsewhere,
 * most operations do not perform argument checking.
 */
class UnmodifiablePiece extends Piece {

	/**
	 * Holds the instance which effectively contains the piece's state.
	 */
	private final ModifiablePiece original;
	
	/**
	 * Initiates an instance with the underlying modifiable instance.
	 * 
	 * @param piece the instance which effectively holds the piece's state.
	 */
	public UnmodifiablePiece(ModifiablePiece piece) 
	{
		original = piece;
	}

	/**
	 * {@see Piece#getInitialPosition()}
	 */
	@Override
	public Position getInitialPosition() 
	{
		return original.getInitialPosition();
	}

	/**
	 * {@see Piece#getPosition()}
	 */
	@Override
	public Position getPosition() 
	{
		return original.getPosition();
	}

}
