package poo.demos.puzzle.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import poo.demos.puzzle.model.Delta;
import poo.demos.puzzle.model.ModifiablePiece;
import poo.demos.puzzle.model.Piece;
import poo.demos.puzzle.model.Position;
import poo.demos.puzzle.model.UnmodifiablePiece;

/**
 * Class that contains the unit tests for the {@link Piece} hierarchy.
 */
public class PieceTestSuit {

	private static final int X = 2, Y = 0;
	
	@Test
	public void instatiationOfUnmodifiablePiece_withValidArgument_returnsValidInstance()
	{
		ModifiablePiece original = new ModifiablePiece(X, Y);
		Piece decorator = new UnmodifiablePiece(original);
		assertThat(decorator, is(equalTo((Piece)original)));
		assertThat(original, is(equalTo(decorator)));
	}

	@Test
	public void equals_equivalentPieces_returnsTrue()
	{
		Piece one = new ModifiablePiece(X, Y);
		Piece other = new ModifiablePiece(X, Y);
		assertThat(one, is(equalTo(other)));
		assertThat(other, is(equalTo(one)));
	}
	
	@Test
	public void hashCode_equivalentPieces_returnsSameValue()
	{
		Piece one = new ModifiablePiece(X, Y);
		Piece other = new ModifiablePiece(X, Y);
		assertThat(one.hashCode(), is(equalTo(other.hashCode())));
	}
	
	@Test
	public void equals_nullArgument_returnsFalse()
	{
		Piece piece = new ModifiablePiece(X, Y);
		assertThat(piece, is(not(equalTo(null))));
	}
	
	@Test
	public void equals_samePiece_returnsTrue()
	{
		Piece piece = new ModifiablePiece(X, Y);
		assertThat(piece, is(equalTo(piece)));
	}
	
	@Test
	public void equals_differentPieces_returnsFalse()
	{
		Piece one = new ModifiablePiece(X, Y);
		Piece other = new ModifiablePiece(X, Y+1);

		assertThat(one, is(not(equalTo(other))));
		assertThat(other, is(not(equalTo(one))));
	}
	
	
	@Test
	public void moveTo_withValidArgument_modifiesInstanceAccordingly()
	{
		ModifiablePiece piece = new ModifiablePiece(X, Y);
		piece.moveTo(Position.fromCoordinates(X, Y+1));
		
		assertThat(piece.isAtCorrectPosition(), is(false));
		assertThat(piece.getPosition().X , is(X));
		assertThat(piece.getPosition().Y , is(Y+1));
	}
	
	@Test(expected=IllegalStateException.class)
	public void moveBy_withInvalidVariation_throwsException()
	{
		new ModifiablePiece(X, Y).moveBy(Delta.STEP_UP);
	}
	
	@Test
	public void moveBy_withValidVariation_modifiesInstanceAccordingly()
	{
		ModifiablePiece piece = new ModifiablePiece(X, Y);
		piece.moveBy(Delta.STEP_DOWN);
		
		assertThat(piece.isAtCorrectPosition(), is(false));
		assertThat(piece.getPosition().X , is(X));
		assertThat(piece.getPosition().Y , is(Y+1));
	}
	
}
