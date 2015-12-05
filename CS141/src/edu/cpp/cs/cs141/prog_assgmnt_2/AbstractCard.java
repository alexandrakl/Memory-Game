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
 * Alexandra Klimenko
 */
package edu.cpp.cs.cs141.prog_assgmnt_2;

/**
 * @author alexandra
 * 
 */
public abstract class AbstractCard {

	String face;
	int back;
	Boolean isUncovered = false;

	/**
	 * @param face
	 * @param back
	 * @param isUncovered
	 *            Creates a super constructor that will be inherited by all the
	 *            cardClasses.
	 */
	public AbstractCard(String face, int back, Boolean isUncovered) {
		super();
		this.face = face;
		this.back = back;
		this.isUncovered = isUncovered;
	}

	public int getBack() {
		return back;
	}

	public void setBack(int back) {
		this.back = back;
	}

	public Boolean getIsUncovered() {
		return isUncovered;
	}

	public void setIsUncovered(Boolean isUncovered) {
		this.isUncovered = isUncovered;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

}
