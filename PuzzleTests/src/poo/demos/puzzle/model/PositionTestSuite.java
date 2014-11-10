package poo.demos.puzzle.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import poo.demos.puzzle.model.Position;

public class PositionTestSuite {

	@Test(expected=IllegalArgumentException.class)
	public void fromCoordinates_withInvalidHorizontalCoordinate_throwsException() 
	{
		Position.fromCoordinates(-1, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void fromCoordinates_withInvalidVerticalCoordinate_throwsException() 
	{
		Position.fromCoordinates(1, -3);
	}
	
	@Test
	public void fromCoordinates_withValidCoordinates_noExceptionThrownAndFieldsAreCorrect() 
	{
		final int CORRECT_X = 1, CORRECT_Y = 2;
		Position position = Position.fromCoordinates(CORRECT_X, CORRECT_Y);
		assertThat(position.X, is(equalTo(CORRECT_X)));
		assertThat(position.Y, is(equalTo(CORRECT_Y)));
	}
	
	@Test
	public void equals_equivalentPositions_returnsTrue()
	{
		final int X = 1, Y = 2;
		Position one = Position.fromCoordinates(X, Y);
		Position other = Position.fromCoordinates(X, Y);
		assertThat(one, is(equalTo(other)));
		assertThat(other, is(equalTo(one)));
	}
	
	@Test
	public void hashCode_equivalentMoves_returnsSameValue()
	{
		final int X = 1, Y = 2;
		Position one = Position.fromCoordinates(X, Y);
		Position other = Position.fromCoordinates(X, Y);
		assertThat(one.hashCode(), is(equalTo(other.hashCode())));
	}
	
	@Test
	public void equals_nullArgument_returnsFalse()
	{
		Position position = Position.fromCoordinates(1, 2);
		assertThat(position, is(not(equalTo(null))));
	}
	
	@Test
	public void equals_sameMove_returnsTrue()
	{
		Position position = Position.fromCoordinates(1, 2);
		assertThat(position, is(equalTo(position)));
	}
	
	@Test
	public void equals_differentMoves_returnsFalse()
	{
		Position one = Position.fromCoordinates(1, 2);
		Position other = Position.fromCoordinates(2, 1);
		Position yetAnother = Position.fromCoordinates(3, 4);
		
		assertThat(one, is(not(equalTo(other))));
		assertThat(other, is(not(equalTo(one))));
		
		assertThat(one, is(not(equalTo(yetAnother))));
		assertThat(yetAnother, is(not(equalTo(one))));
	}
}
