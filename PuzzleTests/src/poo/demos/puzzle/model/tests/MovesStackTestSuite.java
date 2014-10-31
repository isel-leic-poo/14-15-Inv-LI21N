package poo.demos.puzzle.model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poo.demos.puzzle.model.Delta;
import poo.demos.puzzle.model.Move;
import poo.demos.puzzle.model.MovesStack;
import poo.demos.puzzle.model.Piece;

public class MovesStackTestSuite {

	private static final int NEGATIVE_STACK_CAPACITY = -1;
	private static final int ZERO_STACK_CAPACITY = 0;
	private static final int SMALL_STACK_CAPACITY = 5;
	
	/**
	 * Holds the reference to the instance used in a test. Each test 
	 * receives a freshly instantiated stack.
	 * 
	 * {@see #instantiateSmallCapacityEmptyStack()}
	 */
	private MovesStack stack;
	
	/**
	 * Holds the reference to a {@link Move} instance used in a test. Each test 
	 * receives a freshly instantiated stack.
	 * 
	 * {@see #instantiateSmallCapacityEmptyStack()}
	 */
	private Move aMove;
	
	/**
	 * Helper method that creates a new {@link Move} instance, thus isolating the tests
	 * from the construction specificities.
	 * 
	 * @return A newly instantiated {@link Move} object
	 */
	private Move createAMove()
	{
		return new Move(Delta.STEP_DOWN, new Piece(0,0));
	}
	
	/**
	 * Helper method that fills the moves' stack and produces the array with the 
	 * pushed {@link Move} instances.
	 * 
	 * @return The pushed instances
	 */
	private Move[] fillStack() 
	{
		Move[] moves = new Move[SMALL_STACK_CAPACITY];
		for(int idx = 0; idx < moves.length; ++idx)
			stack.push(moves[idx] = createAMove());
		
		return moves;
	}
	
	@Before
	public void instantiateSmallCapacityEmptyStack()
	{
		stack = new MovesStack(SMALL_STACK_CAPACITY);
		aMove = createAMove();
	}

	@Test(expected=IllegalArgumentException.class)
	public void instantiateWithNegativeCapacity_throwsException() 
	{
		new MovesStack(NEGATIVE_STACK_CAPACITY);
	}

	@Test(expected=IllegalArgumentException.class)
	public void instantiateWithZeroCapacity_throwsException() 
	{
		new MovesStack(ZERO_STACK_CAPACITY);
	}
	
	@Test
	public void isEmpty_onAnEmptyStack_returnsTrue() 
	{
		assertTrue("Stack should be empty", stack.isEmpty());
	}
	
	@Test
	public void isEmpty_onAnNonEmptyStack_returnsFalse() 
	{
		stack.push(aMove);
		assertFalse("Stack should not be empty", stack.isEmpty());
	}	

	@Test
	public void getSize_onAnEmptyStack_returnsZero() 
	{
		assertEquals("Stack should be empty", 0, stack.getSize());
	}
	
	@Test
	public void getSize_onAnNonEmptyStack_returnsTheCorrectCount() 
	{
		final int PUSHED_COUNT = 1;
		stack.push(aMove);
		assertEquals("Stack size is incorrect", PUSHED_COUNT, stack.getSize());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void push_ANullElement_throwsException()
	{
		stack.push(null);
	}
	
	@Test
	public void top_onAnEmptyStack_returnsNull()
	{
		assertNull("Peeking at an empty stack should produce a null value", stack.top());
	}

	@Test
	public void top_onANonEmptyStack_returnsLastPushedElement()
	{
		stack.push(aMove);
		assertSame("Should have obtained the last pushed element", aMove, stack.top());
	}

	@Test(expected=IllegalStateException.class)
	public void pop_onAnEmptyStack_throwsException()
	{
		stack.pop();
	}
	
	@Test
	public void pop_onANonEmptyStack_returnsLastPushedElement()
	{
		stack.push(aMove);
		assertSame("Should have obtained the last pushed element", aMove, stack.pop());
	}
	
	@Test
	public void push_onAFullStack_replacesFirstElement()
	{
		// Arrange
		Move[] pushedMoves = fillStack();
		// Act
		Move lastPushedMove = aMove;
		stack.push(lastPushedMove);
		// Assert
		assertSame("Should have obtained the last pushed element", lastPushedMove, stack.pop());
		for(int idx = pushedMoves.length - 1; idx != 0; --idx)
			assertSame("Should have obtained the last pushed element", pushedMoves[idx], stack.pop());
		assertTrue("By now, the stack should be empty", stack.isEmpty());
	}
}
