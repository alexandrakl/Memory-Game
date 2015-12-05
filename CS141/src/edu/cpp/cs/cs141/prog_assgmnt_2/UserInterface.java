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
 * 
 */

import java.util.Scanner;

/**
 * @author alexandra User Interface: the entity in charge of the interactive
 *         part of the program: displaying information and obtaining input from
 *         the user.
 */
public class UserInterface {

	GameEngine game = new GameEngine();

	void printArrayintoString() {
		System.out.println(game.printArrayintoString());
	}

	private Scanner sc = new Scanner(System.in);

	/**
	 * Create the CreateUI method who calls all the other methods in the class.
	 * Prints out a welcome message.
	 * Gives user the choice to start or quit the game.
	 */
	public void createUI() {
		System.out.println("Welcome to Memory Game!\n");

		boolean quit = false;

		while (!quit) {

			int userChoice;

			System.out.println("Please enter " + "[1] to start the game "
					+ "or [2] to quit:");

			userChoice = sc.nextInt();
			sc.nextLine();

			switch (userChoice) {
			case 1:
				startGame();
				break;
			case 2:
				quit = true;
				break;
			default:
				System.out.println("Wrong entry. Please enter "
						+ "[1] to continue " + "or [2] to quit:");
				break;
			}

		}
	}

	/**
	 * Starts the game and prints out the grid taken from the GameEngine.
	 * Calls the shuffle method.
	 * Uncovers and covers the cards in dependence if they match or not.
	 */
	private void startGame() {
		System.out.println("Starting the game. ");

		game.createShuffle();

		while (!(game.getsuccessfulUncovered() == 8)) {

			printArrayintoString();

			System.out.println("Enter the number of the card"
					+ " you would like to uncover:");
			int a, b;
			a = sc.nextInt();
			sc.nextLine();
			game.uncoverCard1((a / 4), (a % 4));

			System.out.println("Enter the number of another card"
					+ " you would like to uncover:");
			b = sc.nextInt();
			sc.nextLine();
			if (a == b) {
				System.out.println("You cannot pick same card.");

			} else {
				game.uncoverCard2((b / 4), (b % 4));

				printArrayintoString();

				game.coverCard((a / 4), (a % 4), (b / 4), (b % 4));
				game.checkMatch((a / 4), (a % 4), (b / 4), (b % 4));
				
			}
		}
		
		System.out.println("You won!");
		System.out.println("You opened " + game.gettotalUncovered()
				+ " pairs. ");
	}
}
