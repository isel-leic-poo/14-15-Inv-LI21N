package poo.demos.puzzle.model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import poo.demos.puzzle.model.Move;
import poo.demos.puzzle.model.MovesStack;

public class MovesStackTestSuite {

	private static final int NEGATIVE_STACK_CAPACITY = -1;
	private static final int ZERO_STACK_CAPACITY = 0;
	private static final int SMALL_STACK_CAPACITY = 5;
	
	private MovesStack stack;
	
	@Before
	public void instantiateSmallCapacityEmptyStack()
	{
		stack = new MovesStack(SMALL_STACK_CAPACITY);
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
		stack.push(new Move());
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
		stack.push(new Move());
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
		Move move = new Move(); 
		stack.push(move);
		assertSame("Should have obtained the last pushed element", move, stack.top());
	}

	@Test(expected=IllegalStateException.class)
	public void pop_onAnEmptyStack_throwsException()
	{
		stack.pop();
	}
	
	@Test
	public void pop_onANonEmptyStack_returnsLastPushedElement()
	{
		Move move = new Move(); 
		stack.push(move);
		assertSame("Should have obtained the last pushed element", move, stack.pop());
	}
	
	@Test
	public void push_onAFullStack_replacesFirstElement()
	{
		// Arrange
		Move[] pushedMoves = fillStack();
		// Act
		Move lastPushedMove = new Move();
		stack.push(lastPushedMove);
		// Assert
		assertSame("Should have obtained the last pushed element", lastPushedMove, stack.pop());
		for(int idx = pushedMoves.length - 1; idx != 0; --idx)
			assertSame("Should have obtained the last pushed element", pushedMoves[idx], stack.pop());
		assertTrue("By now, the stack should be empty", stack.isEmpty());
	}

	private Move[] fillStack() 
	{
		Move[] moves = new Move[SMALL_STACK_CAPACITY];
		for(int idx = 0; idx < moves.length; ++idx)
			stack.push(moves[idx] = new Move());
		
		return moves;
	}
}
