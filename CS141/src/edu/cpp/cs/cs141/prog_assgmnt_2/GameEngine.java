/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #2
 *
 * This assignment creates a memory game.
 * It uses a two-dimensional array that represents the grid.
 * There are 16 cards arranged, upside down, and there are 2 cards of each type.
 * The player flips over two cards each turn by choosing the number of the card
 * displayed on each card.
 * The game ends when the player uncovers all the cards.
 *
 * Alexandra Klimenkoimport java.util.Formatter;
 */
package edu.cpp.cs.cs141.prog_assgmnt_2;

/**
 * @author alexandra Game Engine: the entity that represents an instance of the
 *         game. Keeps track the current state of the game, statistics like the
 *         number of moves, etc.
 */
public class GameEngine {

	private int successfulUncovered;
	private int totalUncovered;

	private Grid grid = new Grid();

	/**
	 * @return
	 */
	public int getsuccessfulUncovered() {
		return successfulUncovered;
	}

	/**
	 * @return
	 */
	public int gettotalUncovered() {
		return totalUncovered;
	}

	/**
	 * 
	 */
	public void createShuffle() {
		Grid.createShuffle();

	}

	/**
	 * @return
	 */
	public String printArrayintoString() {
		return grid.printArrayintoString();
	}

	/**
	 * @param i
	 * @param j
	 */
	public void uncoverCard1(int i, int j) {
		grid.getCardat(i, j).setIsUncovered(true);
	}

	
	/**
	 * @param x
	 * @param y
	 */
	public void uncoverCard2(int x, int y) {
		grid.getCardat(x, y).setIsUncovered(true);
	}

	/**
	 * @param i
	 * @param j
	 * @param x
	 * @param y
	 */
	public void coverCard(int i, int j, int x, int y) {

		if (grid.getCardat(i, j).getIsUncovered()) {
			grid.getCardat(i, j).setIsUncovered(false);

			if (grid.getCardat(x, y).getIsUncovered())
				grid.getCardat(x, y).setIsUncovered(false);
		}
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public AbstractCard getCardAt(int x, int y) {
		return grid.getCardat(x, y);
	}
	
	/**
	 * @param i
	 * @param j
	 * @param x
	 * @param y
	 * The checkMark method marks the card as Uncovered.
	 * Then it checks if the cards are the same.
	 * Creates a counter for all successfully and total uncovered cards.
	 */
	public void checkMatch(int i, int j, int x, int y) {
		AbstractCard a = grid.getCardat(i, j);
		AbstractCard b = grid.getCardat(x, y);

		if (a.getFace().equals(b.getFace())) {
			grid.getCardat(i, j).setIsUncovered(true);
			grid.getCardat(x, y).setIsUncovered(true);
			++successfulUncovered;
			++totalUncovered;

		} else {
			++totalUncovered;
		}
	}
}
