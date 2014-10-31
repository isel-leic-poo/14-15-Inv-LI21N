package poo.demos.puzzle.model;

public class App {

	public static void main(String[] args) 
	{
		Grid puzzle = Grid.createPuzzle(3);
		
		puzzle.doMove(
				puzzle.getPieceAtPosition(Position.fromCoordinates(1, 1)),
				Position.fromCoordinates(0, 1)
		);
		
		Piece p = puzzle.getPieceAtPosition(Position.fromCoordinates(1, 1));
		p.moveTo(Position.fromCoordinates(0, 1));
	}

}
