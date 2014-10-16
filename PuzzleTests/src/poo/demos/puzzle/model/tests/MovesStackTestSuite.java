package poo.demos.puzzle.model.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poo.demos.puzzle.model.Move;
import poo.demos.puzzle.model.MovesStack;

public class MovesStackTestSuite {

	private static final int NEGATIVE_STACK_CAPACITY = -1;
	private static final int ZERO_STACK_CAPACITY = 0;
	private static final int SMALL_STACK_CAPACITY = 5;

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
	public void instantiateWithPositiveCapacity_succeeds() 
	{
		new MovesStack(SMALL_STACK_CAPACITY);
	}
	
	@Test
	public void isEmpty_onAnEmptyStack_returnsTrue() 
	{
		MovesStack stack = new MovesStack(SMALL_STACK_CAPACITY);
		assertTrue("Stack should be empty", stack.isEmpty());
	}
	
	@Test
	public void isEmpty_onAnNonEmptyStack_returnsFalse() 
	{
		MovesStack stack = new MovesStack(SMALL_STACK_CAPACITY);
		stack.push(new Move());
		assertFalse("Stack should not be empty", stack.isEmpty());
	}	

	@Test
	public void getSize_onAnEmptyStack_returnsZero() 
	{
		MovesStack stack = new MovesStack(SMALL_STACK_CAPACITY);
		assertEquals("Stack should be empty", 0, stack.getSize());
	}
	
	@Test
	public void getSize_onAnNonEmptyStack_returnsTheCorrectCount() 
	{
		MovesStack stack = new MovesStack(SMALL_STACK_CAPACITY);
		stack.push(new Move());
		final int COUNT = 1;
		assertEquals("Stack size is incorrect", COUNT, stack.getSize());
	}	
}
