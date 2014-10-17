package poo.demos.puzzle.model;

/**
 * Class whose instances represent the last N moves made so far in the game.
 * 
 * MoveStack instances have limited capacity, specified upon construction.
 * When the instance's capacity is reached, oldest moves are replaced by new
 * ones. The goal is therefore to store the last N moves. 
 * 
 * Each instance supports, at most, 2^31 pushes between pops without overflowing 
 * the put index. This is more than enough for realistic use-cases.
 */
public class MovesStack {

	/**
	 * The array where the elements are stored.
	 */
	private final Move[] moves;
	
	/**
	 * The next free index in the array, which is organized as a ring-buffer.
	 */
	private int putIndex;
	
	/**
	 * The number of elements currently stored.
	 */
	private int size;
	
	/**
	 * Initiates an instance with the given capacity.
	 * 
	 * @param capacity The maximum number of stored elements. 
	 * @throws IllegalArgumentException if the {@code capacity} argument is not greater
	 * than zero. 
	 */
	public MovesStack(int capacity)
	{
		if(capacity <= 0)
			throw new IllegalArgumentException();
		
		moves = new Move[capacity];
		size = putIndex = 0;
	}
	
	/**
	 * Pushes the given element to the top of the stack.
	 * 
	 * @param move The element to add at the top of the stack
	 * @throws IllegalArgumentException if the {@code move} argument is {@code null}
	 */
	public void push(Move move)
	{
		if(move == null)
			throw new IllegalArgumentException();
		
		moves[putIndex++ % moves.length] = move;
		size = size != moves.length ? size + 1 : size;
	}
	
	/**
	 * Removes the element currently at the top of the stack.
	 * 
	 * @return The removed element
	 * @throws IllegalStateException if the stack is empty
	 */
	public Move pop()
	{
		if(isEmpty())
			throw new IllegalStateException();
		
		int lastElementeIndex = (putIndex - 1) % moves.length; 

		Move move = moves[lastElementeIndex];
		// Ensuring that the Move instance is not inappropriately retained 
		moves[lastElementeIndex] = null;

		// Removing an element always creates an empty space
		putIndex -= 1;
		size -= 1;
		
		return move;
	}
	
	/**
	 * Gets the element currently at the top of the stack, or null if none exists.
	 * 
	 * @return The element at the top of the stack, or {@code null} if the stack 
	 * is empty
	 */
	public Move top()
	{
		return isEmpty() ? null : moves[(putIndex - 1) % moves.length];
	}

	/**
	 * Gets a boolean value indicating whether the stack is empty.
	 * 
	 * @return {@code true} if the stack is empty, {@code false} otherwise 
	 */
	public boolean isEmpty()
	{
		return getSize() == 0;
	}
	
	/**
	 * Gets the current number of elements.
	 * 
	 * @return the number of elements stored in the stack
	 */
	public int getSize()
	{
		return size;
	}	
}
