package poo.demos.puzzle.model;

/**
 * Class whose instances represent the last N moves made so far in the game.
 * 
 * MoveStack instances have limited capacity, specified upon construction.
 * When the instance's capacity is reached, oldest moves are replaced by new
 * ones. The goal is therefore to store the last N moves. 
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
		// TODO
		size += 1;
	}
	
	/**
	 * Removes the element currently at the top of the stack.
	 * 
	 * @return The removed element
	 * @throws IllegalStateException if the stack is empty
	 */
	public Move pop()
	{
		// TODO
		size -= 1;
		return null;
	}
	
	/**
	 * Gets the element currently at the top of the stack, or null if none exists.
	 * 
	 * @return The element at the top of the stack, or {@code null} if the stack 
	 * is empty
	 */
	public Move top()
	{
		if(isEmpty())
			return null;
		
		// TODO
		return null;
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
