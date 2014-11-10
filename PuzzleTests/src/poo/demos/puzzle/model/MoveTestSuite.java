package poo.demos.puzzle.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import poo.demos.puzzle.model.Move;
import poo.demos.puzzle.model.ModifiablePiece;
import poo.demos.puzzle.model.Delta;

/**
 * Note to students:
 * Just for fun, my test suits are using Hamcrest's matchers.
 * Notice the increased expressiveness.. ;)
 * 
 * For your own tests I recommend you use (for now) JUnit's assertions (e.g. assertSame,
 * assertEqual, assertTrue, and so on).
 */
public class MoveTestSuite {
	
	private ModifiablePiece piece;
	
	@Before
	public void initPieceInstance()
	{
		piece = new ModifiablePiece(0,0);
	}
		
	@Test
	public void instantiation_validConstructorArguments_noExceptionThrownAndFieldsAreCorrect() 
	{
		Move move = new Move(Delta.STEP_UP, piece);
		assertThat(move.delta, is(sameInstance(Delta.STEP_UP)));
		assertThat(move.target, is(sameInstance(piece)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void instantiation_nullPieceInConstructorArgument_exceptionThrown() 
	{
		new Move(Delta.STEP_UP, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void instantiation_nullDeltaInConstructorArgument_exceptionThrown() 
	{
		new Move(null, piece);
	}

	@Test
	public void equals_equivalentMoves_returnsTrue()
	{
		Move one = new Move(Delta.STEP_UP, piece);
		Move other = new Move(Delta.STEP_UP, piece);
		assertThat(one, is(equalTo(other)));
		assertThat(other, is(equalTo(one)));
	}
	
	@Test
	public void hashCode_equivalentMoves_returnsSameValue()
	{
		Move one = new Move(Delta.STEP_UP, piece);
		Move other = new Move(Delta.STEP_UP, piece);
		assertThat(one.hashCode(), is(equalTo(other.hashCode())));
	}
	
	@Test
	public void equals_nullArgument_returnsFalse()
	{
		Move move = new Move(Delta.STEP_UP, piece);
		assertThat(move, is(not(equalTo(null))));
	}
	
	@Test
	public void equals_sameMove_returnsTrue()
	{
		Move move = new Move(Delta.STEP_UP, piece);
		assertThat(move, is(equalTo(move)));
	}
	
	@Test
	public void equals_differentMoves_returnsFalse()
	{
		Move one = new Move(Delta.STEP_DOWN, piece);
		Move other = new Move(Delta.STEP_UP, piece);
		assertThat(one, is(not(equalTo(other))));
		assertThat(other, is(not(equalTo(one))));
	}

	@Test
	public void getReverseMove_reverseUp_returnsDown() 
	{
		Move move = new Move(Delta.STEP_UP, piece);
		Move expectedReverseMove = new Move(Delta.STEP_DOWN, piece);
		assertThat(move.getReverseMove(), is(equalTo(expectedReverseMove)));
	}

	@Test
	public void getReverseMove_reverseDown_returnsUp() 
	{
		Move move = new Move(Delta.STEP_DOWN, piece);
		Move expectedReverseMove = new Move(Delta.STEP_UP, piece);
		assertThat(move.getReverseMove(), is(equalTo(expectedReverseMove)));
	}

	@Test
	public void getReverseMove_reverseLeft_returnsRight() 
	{
		Move move = new Move(Delta.STEP_LEFT, piece);
		Move expectedReverseMove = new Move(Delta.STEP_RIGHT, piece);
		assertThat(move.getReverseMove(), is(equalTo(expectedReverseMove)));
	}

	@Test
	public void getReverseMove_reverseRight_returnsLeft() 
	{
		Move move = new Move(Delta.STEP_RIGHT, piece);
		Move expectedReverseMove = new Move(Delta.STEP_LEFT, piece);
		assertThat(move.getReverseMove(), is(equalTo(expectedReverseMove)));
	}	
}
