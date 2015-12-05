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
public class CardMinus1 extends AbstractCard {

	/**
	 * @param face
	 * @param back
	 * @param uncovered
	 */
	public CardMinus1() {
		super("-", 7, false);
	}
}
