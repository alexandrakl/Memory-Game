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

import java.util.Arrays;
import java.util.Collections;

/**
 * @author alexandra The Class called Grid represents the grid. It holds
 *         internally the two-dimensional array used to represent the card
 *         layout which has 4x4 dimensions.
 */
public class Grid {

	private static AbstractCard zero = new CardDivide();
	private static AbstractCard one = new CardDivide1();
	private static AbstractCard two = new CardExclamation();
	private static AbstractCard three = new CardExclamation1();
	private static AbstractCard four = new CardHashtag();
	private static AbstractCard five = new CardHashtag1();
	private static AbstractCard six = new CardMinus();
	private static AbstractCard seven = new CardMinus1();
	private static AbstractCard eight = new CardMultiply();
	private static AbstractCard nine = new CardMultiply1();
	private static AbstractCard ten = new CardPercentage();
	private static AbstractCard eleven = new CardPercentage1();
	private static AbstractCard twelve = new CardPlus();
	private static AbstractCard thirteen = new CardPlus1();
	private static AbstractCard fourteen = new CardQuestion();
	private static AbstractCard fifteen = new CardQuestion1();

	// create array of names of the cards, then put in a loop and shuffle
	private static AbstractCard[][] aCard = new AbstractCard[][] {
			{ zero, one, two, three }, { four, five, six, seven },
			{ eight, nine, ten, eleven },
			{ twelve, thirteen, fourteen, fifteen } };

	/**
	 * 
	 * Create a createShuffle() method that shuffles the cards in the array by
	 * changing the two-dimensional array into a one dimensional shuffle, and
	 * then transform back to the two-dimensional array.
	 */
	public static void createShuffle() {
		AbstractCard[] aCards = new AbstractCard[16];
		int x = 0;
		for (int row = 0; row < aCard.length; row++) {
			for (int col = 0; col < aCard[row].length; col++) {
				aCards[x] = aCard[row][col];
				x++;
			}
		}

		Collections.shuffle(Arrays.asList(aCards));
		for (int i = 0; i < aCards.length; i++) {
			aCards[i].setBack(i);
		}
		int y = 0;
		for (int row = 0; row < aCard.length; row++) {
			for (int col = 0; col < aCard[row].length; col++) {
				aCard[row][col] = aCards[y];
				y++;
			}
		}
	}

	/**
	 * @return Creates a printArrayintoString method that will allow the
	 *         GameEngine class to access the string that the array is changed
	 *         into.
	 */
	public String printArrayintoString() {
		String s = "";
		for (AbstractCard[] row : aCard) {
			for (AbstractCard a : row) {
				if (a.getIsUncovered())
					s += ("[ " + a.getFace() + "]");
				else
				{
					if(a.getBack() <=9)
					{
						s += ("[ " + a.getBack() + "]");
					}
					else 
					{
						s += ("[" + a.getBack() + "]");	
					};
				}
			}
			s += "\n";
		}
		return s;
	}

	/**
	 * @param i
	 * @param j
	 * @return
	 */
	public AbstractCard getCardat(int i, int j) {
		return aCard[i][j];
	}

}
