package poo.demos.puzzle.model.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import poo.demos.puzzle.model.Move;
import poo.demos.puzzle.model.Piece;
import poo.demos.puzzle.model.Delta;

/**
 * Note to students:
 * Just for fun, my test suits are using Hamcrest's matchers.
 * Notice the increased expressiveness.. ;)
 * 
 * For your own tests I recommend you use (for now) JUnit's assertions (e.g. assertSame,
 * assertEqual, assertTrue, and so on).
 * 
 * The next example illustrates the use of JUnit's assertions to express the 
 * deltaGetReverse_correctReverseComputation_returnsReverse unit test.
 * <pre> 
 * {@code
 * 		assertSame(Delta.DOWN, Delta.UP.getReverse());
 * 		assertSame(Delta.UP, Delta.DOWN.getReverse());
 * 		assertSame(Delta.LEFT, Delta.RIGHT.getReverse());
 * 		assertSame(Delta.RIGHT, Delta.LEFT.getReverse());
 * }
 * </pre>
 */
public class MoveTestSuite {
	
	private Piece piece;
	
	@Before
	public void initPieceInstance()
	{
		piece = new Piece(0,0);
	}
	
	@Test
	public void deltaGetReverse_correctReverseComputation_returnsReverse()
	{
		assertThat(Delta.STEP_UP.getReverse(), is(sameInstance(Delta.STEP_DOWN)));
		assertThat(Delta.STEP_DOWN.getReverse(), is(sameInstance(Delta.STEP_UP)));
		assertThat(Delta.STEP_RIGHT.getReverse(), is(sameInstance(Delta.STEP_LEFT)));
		assertThat(Delta.STEP_LEFT.getReverse(), is(sameInstance(Delta.STEP_RIGHT)));
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
